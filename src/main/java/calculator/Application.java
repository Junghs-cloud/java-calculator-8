package calculator;

import java.util.*;
import java.util.stream.IntStream;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String userInput = readLine();
        String basicDelimiterRegex = "[,:]+";
        String[] operands = userInput.split(basicDelimiterRegex);
        if (userInput.isEmpty()) {
            System.out.println("결과 : 0");
        }
        else {
            Vector<Integer> operandValues = getOperandValues(operands);
            int sum  = operandValues.stream().mapToInt(Integer::intValue).sum();
            System.out.println("결과 : " + sum);
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
}
