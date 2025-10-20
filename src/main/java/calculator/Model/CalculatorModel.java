package calculator.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CalculatorModel {
    String customDelimiterRegex = "^//[^0-9]\\\\n.*";

    public int calculate(String userInput) {
        ArrayList<String> delimiters = new ArrayList<>(Arrays.asList(",", ":"));

        if (Pattern.matches(customDelimiterRegex, userInput)) {
            String customDelimiter = Character.toString(userInput.charAt(2));
            delimiters.add(customDelimiter);
            userInput = userInput.substring(5);
            return splitByDelimitersAndCalculate(userInput, delimiters);
        }
        else {
            if (userInput.isEmpty()) {
                return 0;
            }
            else {
                return splitByDelimitersAndCalculate(userInput, delimiters);
            }
        }
    }

    private Vector<Integer> getOperandValues(String[] operands) {
        Vector<Integer> operandValues = new Vector<>();
        try {
            for (String operand: operands) {
                int value = Integer.parseInt(operand);
                if (value <= 0) {
                    throw new IllegalArgumentException();
                }
                operandValues.add(value);
            }
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return operandValues;
    }

    private int splitByDelimitersAndCalculate(String input, ArrayList<String> delimiters) {
        String delimiterRegex = delimiters.stream().collect(Collectors.joining("", "[", "]+"));
        String[] operands = input.split(delimiterRegex);
        Vector<Integer> operandValues = getOperandValues(operands);
        return operandValues.stream().mapToInt(Integer::intValue).sum();
    }
}
