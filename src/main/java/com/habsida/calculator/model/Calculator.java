package com.habsida.calculator.model;

import com.habsida.calculator.constant.ArithmeticOperator;

import java.util.List;

public class Calculator {
    private final Expression expression;

    public Calculator(Expression expression) {
        this.expression = expression;
    }

    public double calculate() {
        List<Integer> numbers = expression.getNumbers();
        List<ArithmeticOperator> operators = expression.getOperators();

        if (operators.size() == 1) {
            return calculateWithOneNumber(numbers, operators);
        } else if (operators.size() == 2) {
            return calculateWithTwoNumber(numbers, operators);
        } else {
            return 0.0;
        }
    }

    private double calculateWithOneNumber(List<Integer> numbers, List<ArithmeticOperator> operators) {
        return switch (operators.get(0)) {
            case ADDITION -> (double) numbers.get(0) + numbers.get(1);
            case SUBTRACTION -> (double) numbers.get(0) - numbers.get(1);
            case MULTIPLICATION -> (double) numbers.get(0) * numbers.get(1);
            case DIVISION -> (double) numbers.get(0) / numbers.get(1);
        };
    }

    private double calculateWithTwoNumber(List<Integer> numbers, List<ArithmeticOperator> operators) {
        double temp = 0.0;
        if (operators.get(0).getPriority() > operators.get(1).getPriority()) {
            switch (operators.get(1)) {
                case MULTIPLICATION:
                    temp = (double) numbers.get(1) * numbers.get(2);
                    break;
                case DIVISION:
                    temp = (double) numbers.get(1) / numbers.get(2);
                    break;
                default:
                    break;
            }
            return switch (operators.get(0)) {
                case ADDITION -> numbers.get(0) + temp;
                case SUBTRACTION -> numbers.get(0) - temp;
                default -> 0.0;
            };
        } else {
            switch (operators.get(0)) {
                case ADDITION:
                    temp = (double) numbers.get(0) + numbers.get(1);
                    break;
                case SUBTRACTION:
                    temp = (double) numbers.get(0) - numbers.get(1);
                    break;
                case MULTIPLICATION:
                    temp = (double) numbers.get(0) * numbers.get(1);
                    break;
                case DIVISION:
                    temp = (double) numbers.get(0) / numbers.get(1);
                    break;
                default:
                    break;
            }
            return switch (operators.get(1)) {
                case ADDITION -> temp + numbers.get(2);
                case SUBTRACTION -> temp - numbers.get(2);
                case MULTIPLICATION -> temp * numbers.get(2);
                case DIVISION -> temp / numbers.get(2);
            };
        }
    }
}
