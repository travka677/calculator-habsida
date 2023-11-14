package com.habsida.calculator;

import com.habsida.calculator.exception.IllegalExpressionException;
import com.habsida.calculator.formatter.NumberFormatter;
import com.habsida.calculator.model.Calculator;
import com.habsida.calculator.model.Expression;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.habsida.calculator.constant.ExpressionPattern.ARITHMETIC_EXPRESSION;
import static com.habsida.calculator.validator.ExpressionValidator.validateExpression;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Please, enter the expression");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String value = reader.readLine();

        boolean expressionCorrect;
        try {
            expressionCorrect = validateExpression(value, ARITHMETIC_EXPRESSION);
        } catch (IllegalExpressionException e) {
            System.out.println(e.getMessage());
            return;
        }
        if (expressionCorrect) {
            Expression expression = new Expression(value);
            double result = new Calculator(expression).calculate();
            String resultToPrint = new NumberFormatter(result).getFormattedValue();
            System.out.println(expression.getValue() + " = " + resultToPrint);
        }
    }
}
