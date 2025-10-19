package calculator;

import java.util.*;
import java.util.stream.IntStream;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String userInput = readLine();
        String basicDelimiterRegex = "[,:]";
        String[] operands = userInput.split(basicDelimiterRegex);
        int sum  = Arrays.stream(operands).mapToInt(Integer::parseInt).sum();
        System.out.println("결과 : " + sum);
    }

}
