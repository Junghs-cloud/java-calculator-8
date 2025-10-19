package calculator;

import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String userInput = readLine();
        ArrayList<String> delimiters = new ArrayList<>(Arrays.asList(",", ":"));
        String customDelimiterRegex = "^//[^0-9]\\\\n.*";

        if (Pattern.matches(customDelimiterRegex, userInput)) {
            String customDelimiter = Character.toString(userInput.charAt(2));
            delimiters.add(customDelimiter);
            userInput = userInput.substring(5);
            splitByDelimitersAndCalculate(userInput, delimiters);
        }
        else {
            if (userInput.isEmpty()) {
                System.out.println("결과 : 0");
            }
            else {
                splitByDelimitersAndCalculate(userInput, delimiters);
            }
        }
    }

    public static Vector<Integer> getOperandValues(String[] operands) {
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

    public static void splitByDelimitersAndCalculate(String input, ArrayList<String> delimiters) {
        String delimiterRegex = delimiters.stream().collect(Collectors.joining("", "[", "]+"));
        String[] operands = input.split(delimiterRegex);
        Vector<Integer> operandValues = getOperandValues(operands);
        int sum  = operandValues.stream().mapToInt(Integer::intValue).sum();
        System.out.println("결과 : " + sum);
    }
}
