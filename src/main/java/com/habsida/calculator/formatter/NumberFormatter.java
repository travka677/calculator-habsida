package com.habsida.calculator.formatter;

public class NumberFormatter {
    private final double value;

    public NumberFormatter(double value) {
        this.value = value;
    }

    public String getFormattedValue() {
        double fraction = value - (int) value;
        if (fraction == 0) {
            return ((int) value) + "";
        }
        return value + "";
    }
}
