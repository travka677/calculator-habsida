package com.habsida.calculator.constant;

public class ExpressionPattern {
    public static final String ARITHMETIC_EXPRESSION = "-?([1-9]|10)\\s?[-+*/]\\s?([1-9]|10)((\\s?)[-+*/]\\s?([1-9]|10))?";
    public static final String ARITHMETIC_OPERATOR = "(?<!^)-|[+*/]";
    public static final String NUMBER_FROM_ZERO_TO_TEN = "(^-(10|[1-9]))|(10|[1-9])";

    private ExpressionPattern() {}
}
