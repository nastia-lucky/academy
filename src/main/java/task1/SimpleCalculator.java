package task1;

public class SimpleCalculator extends AbstractCalculator {

    @Override
    protected void apply(Operation operation, Stack<Double> stack) throws UnsupportedCalculatorOperationException{
        double a;
        double b;
        switch (operation) {
            case PLUS:
                a = stack.pop();
                b = stack.pop();
                stack.push(a + b);
                break;
            case MINUS:
                a = stack.pop();
                b = stack.pop();
                stack.push(b - a);
                break;
            case MULTI:
                a = stack.pop();
                b = stack.pop();
                stack.push(a * b);
                break;
            case DIVISION:
                a = stack.pop();
                b = stack.pop();
                stack.push(b / a);
                break;
            default:
                throw new UnsupportedCalculatorOperationException();
        }
    }
}
