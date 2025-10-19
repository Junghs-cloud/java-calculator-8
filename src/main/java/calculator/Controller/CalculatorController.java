package calculator.Controller;

import calculator.Model.CalculatorModel;
import calculator.View.*;

public class CalculatorController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final CalculatorModel calculatorModel = new CalculatorModel();

    public void execute() {
        String input = inputView.getInput();
        int result = calculatorModel.calculate(input);
        outputView.printResult(result);
    }
}
