package com.habsida.calculator.constant;

public enum ArithmeticOperator {
    SUBTRACTION("-", 2),
    ADDITION("+", 2),
    MULTIPLICATION("*", 1),
    DIVISION("/", 1);

    private final String view;
    private final int priority;

    ArithmeticOperator(String view, int priority) {
        this.view = view;
        this.priority = priority;
    }

    public String getView() {
        return view;
    }

    public int getPriority() {
        return priority;
    }
}
