package controller;

import java.math.BigDecimal;
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
    private static Map<String, String> operators;

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

        operators = new HashMap<String, String>();
        operators.put("plus", "＋");
        operators.put("minus", "－");
        operators.put("mult", "×");
        operators.put("div", "÷");
    }


    public void handleOnAnyButtonClicked(String buttonText) {

        final String bText = buttonText;

        if (bText.equals("C") || bText.equals("AC")) {

            displayBuffer.setLength(0);
            if (bText.equals("AC")) {
                left = BigDecimal.ZERO;
                displayBuffer.append("");
            } else
                displayBuffer.append(left);

            selectedOperator = "";
            numberInputting = false;
            display.setLength(0);
            display.append(left);
            displayBuffer.setLength(0);
            displayBuffer.append(left);
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
            final BigDecimal right = numberInputting ? new BigDecimal(display.toString()) : left;
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

        String[] numbers = string.split("[＋－×÷]");
        String[] operators = string.split("[0-9\\.]");
        BigDecimal left = new BigDecimal(numbers[0]);
        BigDecimal right;

        try {
            for (int i = 0; i < operators.length; i++) {

                right = new BigDecimal(numbers[i + 1]);
                switch (operators[i]) {
                    case "＋":
                        return left.add(right);
                    case "－":
                        return left.subtract(right);
                    case "×":
                        return left.multiply(right);
                    case "÷":
                        if (right.toString().equals("0"))
                            return right;
                        return left.divide(right);
                    default:
                }
            }

        } catch (ArithmeticException e) {
            left = new BigDecimal(0);
        } finally {
            return left;
        }


    }

}
