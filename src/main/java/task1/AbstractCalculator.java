package task1;

import java.util.ArrayList;

public abstract class AbstractCalculator {

    protected abstract void apply(Operation operation, Stack<Double> stack) throws UnsupportedCalculatorOperationException;

    public double calculate(ArrayList<String> polishArray) throws UnsupportedCalculatorOperationException {
        Stack<Double> temp = new Stack();
        for (String value : polishArray) {
            if (Utils.isNumeric(value)) {
                temp.push(Double.parseDouble(value));
            } else {
                Operation operation = Operation.of(value);
                apply(operation, temp);
            }
        }
        return temp.pop();
    }
}
