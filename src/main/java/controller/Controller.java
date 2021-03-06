package controller;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Controller {

    private BigDecimal left;
    private String selectedOperator;
    private boolean numberInputting;
    private boolean operatorImputting;
    private StringBuffer display;
    private StringBuffer displayBuffer;
    private static Map<String, String> operators = new HashMap<String, String>();;

    static {
        operators.put("plus", "＋");
        operators.put("minus", "－");
        operators.put("mult", "×");
        operators.put("div", "÷");
    }

    public StringBuffer getDisplay() {
        return display;
    }

    public void setDisplay(StringBuffer display) {
        this.display = display;
    }

    public BigDecimal getLeft() {
        return left;
    }

    public void setLeft(BigDecimal left) {
        this.left = left;
    }

    public boolean isNumberInputting() {
        return numberInputting;
    }

    public String getSelectedOperator() {
        return selectedOperator;
    }

    public StringBuffer getDisplayBuffer() {
        return displayBuffer;
    }

    public Controller() {
        this.left = BigDecimal.ZERO;
        this.selectedOperator = "";
        this.numberInputting = false;
        this.operatorImputting = false;
        this.displayBuffer = new StringBuffer();
        this.display = new StringBuffer("0");
    }


    public void handleOnAnyButtonClicked(String buttonText) {

        final String bText = buttonText;

        if (bText.equals("AC")) {
            left = BigDecimal.ZERO;
            displayBuffer.setLength(0);
            display.setLength(0);
            display.append(left);
            selectedOperator = "";
            numberInputting = false;
            operatorImputting = false;
            return;
        }
        if (bText.equals("C")) {
            if (displayBuffer.lastIndexOf(selectedOperator) > 1)
                displayBuffer.setLength(displayBuffer.lastIndexOf(selectedOperator));
            displayBuffer.setLength(0);
            display.setLength(0);
            display.append("0");
            selectedOperator = "";
            numberInputting = false;
            operatorImputting = false;
            return;
        }
        if (bText.matches("[0-9\\.]")) {
            if (!numberInputting) {
                numberInputting = true;
                display.setLength(0);
            }
            display.append(bText);
            displayBuffer.append(bText);
            operatorImputting = false;
            return;
        }
        if (bText.equals("plus") || bText.equals("minus") || bText.equals("div") || bText.equals("mult")) {

            left = new BigDecimal(display.toString());
            selectedOperator = bText;

            if (operatorImputting) {
                displayBuffer.setLength(displayBuffer.length() - 1);
                displayBuffer.append(operators.get(selectedOperator));
            } else
                displayBuffer.append(operators.get(selectedOperator));

            numberInputting = false;
            operatorImputting = true;
            return;
        }
        if (bText.equals("res")) {
            final String result = displayBuffer.toString();
            left = calculate(result);
            display.setLength(0);
            display.append(left.toString());
            numberInputting = false;
            displayBuffer.setLength(0);
            displayBuffer.append("");
            return;
        }

    }


    public static BigDecimal calculate(String string) {
        if(string.isEmpty() || string.equals(""))
            return new BigDecimal(0);

        String[] numbers = string.split("[＋－×÷]");
        if("".equals(numbers[0]))
            numbers[0] = "0";

        String[] operators = string.split("[0-9\\.]");
        BigDecimal left = new BigDecimal(numbers[0]);
        BigDecimal right;

        int counter = 0;
        for (int i = 1; i < numbers.length; i++) {
            right = new BigDecimal(numbers[i]);

            for (int j = counter; j < operators.length; j++) {
                if (operators[j].equals(""))
                    continue;
                counter = j + 1;
                switch (operators[j]) {
                    case "＋":
                        left = left.add(right);
                        break;
                    case "－":
                        left = left.subtract(right);
                        break;
                    case "×":
                        left = left.multiply(right);
                        break;
                    case "÷":
                        if (right.toString().equals("0"))
                            return right;
                        left = left.divide(right, MathContext.DECIMAL32);
                        break;
                    default:
                }
                break;
            }
        }

        return left;
    }

    /* TEST */
//    public static void main(String[] args) {
//
//        /*String string = "08＋2";
//
//        String[] numbers = string.split("[＋－×÷]");
//        String[] operators = string.split("[0-9\\.]");
//
//        for (String a : numbers) {
//            System.out.println(a);
//        }
//        System.out.println("kjkj");
//        for (String a : operators) {
//            System.out.println(a);
//        }*/
//
//        BigDecimal decimal = calculate("－2");
//        System.out.println(decimal);
//
//        StringBuffer buffer = new StringBuffer("25+3+8-5");
//
//        if (buffer.lastIndexOf("-") != -1) {
//            buffer.setLength(buffer.lastIndexOf("-"));
//            System.out.println(buffer);
//        }
//    }

}
