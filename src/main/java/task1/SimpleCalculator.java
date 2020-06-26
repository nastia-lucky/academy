package task1;

public class SimpleCalculator extends AbstractCalculator {

    @Override
    protected void apply(Operation operation, Stack<Double> stack) throws UnsupportedCalculatorOperationException {
        double operand1;
        double operand2;
        switch (operation) {
            case PLUS:
                operand1 = stack.pop();
                operand2 = stack.pop();
                stack.push(operand1 + operand2);
                break;
            case MINUS:
                operand1 = stack.pop();
                operand2 = stack.pop();
                stack.push(operand2 - operand1);
                break;
            case MULTI:
                operand1 = stack.pop();
                operand2 = stack.pop();
                stack.push(operand1 * operand2);
                break;
            case DIVISION:
                operand1 = stack.pop();
                operand2 = stack.pop();
                stack.push(operand2 / operand1);
                break;
            default:
                throw new UnsupportedCalculatorOperationException();
        }
    }
}
