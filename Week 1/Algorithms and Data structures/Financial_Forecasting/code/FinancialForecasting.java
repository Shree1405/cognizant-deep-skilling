package Financial_Forecasting.code;

public class FinancialForecasting {

    // Recursive Method
    public static double predictFutureValue(
            double presentValue,
            double growthRate,
            int years) {

        if (years == 0) {

            return presentValue;
        }

        return predictFutureValue(
                presentValue * (1 + growthRate),
                growthRate,
                years - 1);
    }

    public static void main(
            String[] args) {

        double presentValue = 100000;

        double growthRate = 0.10;

        int years = 5;

        double futureValue =
                predictFutureValue(
                        presentValue,
                        growthRate,
                        years);

        System.out.println(
                "Present Value : ₹"
                + presentValue);

        System.out.println(
                "Growth Rate : "
                + (growthRate * 100)
                + "%");

        System.out.println(
                "Years : "
                + years);

        System.out.println(
                "Predicted Future Value : ₹"
                + futureValue);
    }
}
