package com.itacademy.task1;

public class MemoryCalculator extends AbstractCalculator {
    public static double memory;
    private final SimpleCalculator internalCalculator;

    public MemoryCalculator(SimpleCalculator internalCalculator) {
        this.internalCalculator = internalCalculator;
    }

    @Override
    protected void apply(Operation operation, Stack<Double> stack) throws UnsupportedCalculatorOperationException {
        if (operation.isMemory()) {
            switch (operation) {
                case MC:
                    memory = 0;
                    break;
                case MPlUS:
                    memory = memory + stack.peek();
                    break;
                case MMINUS:
                    memory = memory - stack.peek();
                    break;
                case MS:
                    memory = stack.peek();
                    break;
                case MR: {
                    stack.push(memory);
                }
                break;
                default: {
                    throw new UnsupportedCalculatorOperationException();
                }
            }
        } else {
            internalCalculator.apply(operation, stack);
        }
    }
}
