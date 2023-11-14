package com.habsida.calculator.validator;

import com.habsida.calculator.exception.IllegalExpressionException;

import java.util.regex.Pattern;

public class ExpressionValidator {
    private ExpressionValidator(){}
    public static boolean validateExpression(String expression, String pattern) throws IllegalExpressionException{
        if (Pattern.matches(pattern, expression)) {
            return true;
        }
        throw new IllegalExpressionException("Illegal expression");
    }
}
