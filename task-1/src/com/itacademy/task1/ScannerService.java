package com.itacademy.task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ScannerService {


    public static void main(String[] args) {

        Scanner scannerForConsole = new Scanner(System.in);

        File file = new File(scannerForConsole.nextLine());


        ArrayList<String> polishArray = new ArrayList<>();
        Stack<Operation> stack = new Stack<>();

        int calculatorType;
        try {
            Scanner scannerForFile = new Scanner(file);
            calculatorType = scannerForFile.nextInt();
            while (scannerForFile.hasNext()) {
                String value = scannerForFile.next();
                if (Utils.isNumeric(value)) {
                    polishArray.add(value);
                } else {
                    Operation operation = Operation.of(value);
                    if (operation.isPrefix()) {
                        stack.push(Operation.of(value));
                    } else if (operation == Operation.LEFT_BRACKET) {
                        stack.push(Operation.of(value));
                    }
                    else if (operation.isMemory()){
                        Operation lastOperation = stack.peek();
                        while (!stack.isEmpty() && stack.peek().getPriority() > operation.getPriority()){
                            polishArray.add(stack.pop().getSymbol());
                        }
                        polishArray.add(operation.getSymbol());
                    }
                    else if (operation == Operation.RIGHT_BRACKET) {
                        Operation lastItem = stack.pop();
                        while (lastItem != null && Operation.LEFT_BRACKET != lastItem) {
                            polishArray.add(lastItem.getSymbol());
                            lastItem = stack.pop();
                        }
                    } else if (operation.isBinary()) {
                        Operation lastItem = stack.peek();
                        while (lastItem != null && (lastItem.isPrefix() || lastItem.getPriority() >= operation.getPriority())) {
                            polishArray.add(lastItem.getSymbol());
                            stack.pop();
                            lastItem = stack.peek();
                        }
                        stack.push(operation);
                    }
                }
            }
            while (!stack.isEmpty()) {
                Operation lastItem = stack.pop();
                polishArray.add(lastItem.getSymbol());
            }

            System.out.println(polishArray);

        } catch (FileNotFoundException e) {
            System.out.println("Something wrong with file");
            e.printStackTrace();
            return;
        } finally {
            scannerForConsole.close();
        }

        scannerForConsole.close();

        AbstractCalculator calculator = null;

        switch (calculatorType) {
            case 1:
                calculator= new SimpleCalculator();
                break;
            case 2:
                calculator= new MemoryCalculator(new SimpleCalculator());
                break;
            case 3:
                calculator= new EngineerCalculator();
                break;
            case 4:
                calculator= new MemoryCalculator(new EngineerCalculator());
                break;
            default:
                System.out.println("Such calculator doesn't exist: "+calculatorType );

        }

        try {
            System.out.println(calculator.calculate(polishArray));
        } catch (UnsupportedCalculatorOperationException e) {
            System.out.println("Wrong input");
        }
    }
}


