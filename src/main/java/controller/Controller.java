package controller;

import java.math.BigDecimal;

public class Controller {

    private BigDecimal left;
    private String selectedOperator;
    private boolean numberInputting;
    private StringBuffer display;

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

    public void setNumberInputting(boolean numberInputting) {
        this.numberInputting = numberInputting;
    }

    public String getSelectedOperator() {
        return selectedOperator;
    }

    public void setSelectedOperator(String selectedOperator) {
        this.selectedOperator = selectedOperator;
    }

    public Controller() {
        this.left = BigDecimal.ZERO;
        this.selectedOperator = "";
        this.numberInputting = false;
        display = new StringBuffer("0");
    }

    public void handleOnAnyButtonClicked(String evt) {

        final String bText = evt;

        if (bText.equals("C") || bText.equals("AC")) {
            if (bText.equals("AC")) {
                left = BigDecimal.ZERO;
            }
            selectedOperator = "";
            numberInputting = false;
            display.setLength(0);
            display.append(left);
            return;
        }
        if (bText.matches("[0-9\\.]")) {
            if (!numberInputting) {
                numberInputting = true;
                display.setLength(0);
            }
            display.append(bText);
            return;
        }
        if (bText.equals("plus") || bText.equals("minus") || bText.equals("div") || bText.equals("mult")) {
            left = new BigDecimal(display.toString());
            selectedOperator = bText;
            numberInputting = false;
            return;
        }
        if (bText.equals("res")) {
            final BigDecimal right = numberInputting ? new BigDecimal(display.toString()) : left;
            left = calculate(selectedOperator, left, right);
            display.setLength(0);
            display.append(left.toString());
            numberInputting = false;
            return;
        }

    }

    public static BigDecimal calculate(String operator, BigDecimal left, BigDecimal right) {
        switch (operator) {
            case "plus":
                return left.add(right);
            case "minus":
                return left.subtract(right);
            case "mult":
                return left.multiply(right);
            case "div":
                if (right.toString().equals("0"))
                    return right;
                return left.divide(right);
            default:
        }
        return right;
    }

}
