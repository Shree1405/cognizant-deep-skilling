public class CalculatorClient {

    private CalculatorService calculatorService;

    public CalculatorClient(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public int calculate(int x, int y) {
        return calculatorService.add(x, y);
    }
}
