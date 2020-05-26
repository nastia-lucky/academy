package com.itacademy.task1;

public class EngineerCalculator extends SimpleCalculator {

    @Override
    protected void apply(Operation operation, Stack<Double> stack) throws UnsupportedCalculatorOperationException{
        try {
            super.apply(operation, stack);
        } catch (UnsupportedCalculatorOperationException e) {
            double a;
            switch (operation){
                case ROOT:
                    a = stack.pop();
                    stack.push(Math.sqrt(a));
                    break;
                case SIN:
                    a = stack.pop();
                    stack.push(Math.sin(a));
                    break;
                case COS:
                    a = stack.pop();
                    stack.push(Math.cos(a));
                    break;
                default:
                    throw new UnsupportedCalculatorOperationException();
            }
        }
    }

}
