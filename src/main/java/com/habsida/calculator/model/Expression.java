package com.habsida.calculator.model;

import com.habsida.calculator.constant.ArithmeticOperator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.habsida.calculator.constant.ExpressionPattern.ARITHMETIC_OPERATOR;
import static com.habsida.calculator.constant.ExpressionPattern.NUMBER_FROM_ZERO_TO_TEN;

public class Expression {
    private final String value;
    private final List<Integer> numberList = new ArrayList<>();
    private final List<ArithmeticOperator> operatorList = new ArrayList<>();


    public Expression(String value) {
        this.value = value;
    }

    public List<Integer> getNumbers() {
        if (!numberList.isEmpty()) {
            return numberList;
        }
        Pattern pattern = Pattern.compile(NUMBER_FROM_ZERO_TO_TEN);
        Matcher matcher = pattern.matcher(value);
        while (matcher.find()) {
            numberList.add(Integer.parseInt(matcher.group()));
        }
        return numberList;
    }

    public List<ArithmeticOperator> getOperators() {
        if (!operatorList.isEmpty()) {
            return operatorList;
        }
        Pattern pattern = Pattern.compile(ARITHMETIC_OPERATOR);
        Matcher matcher = pattern.matcher(value);
        while (matcher.find()) {
            String operator = matcher.group();
            switch (operator) {
                case "+":
                    operatorList.add(ArithmeticOperator.ADDITION);
                    break;
                case "-":
                    operatorList.add(ArithmeticOperator.SUBTRACTION);
                    break;
                case "*":
                    operatorList.add(ArithmeticOperator.MULTIPLICATION);
                    break;
                case "/":
                    operatorList.add(ArithmeticOperator.DIVISION);
                    break;
                default:
                    break;
            }
        }
        return operatorList;
    }

    public String getValue() {
        return value;
    }
}
