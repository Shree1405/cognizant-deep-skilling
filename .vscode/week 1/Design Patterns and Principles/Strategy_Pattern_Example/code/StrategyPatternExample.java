package Strategy_Pattern_Example.code;
interface PaymentStrategy {

    void pay(int amount);
}
class CreditCardPayment
        implements PaymentStrategy {

    @Override
    public void pay(int amount) {

        System.out.println(
            "Paid ₹" +
            amount +
            " using Credit Card");
    }
}
class PayPalPayment
        implements PaymentStrategy {

    @Override
    public void pay(int amount) {

        System.out.println(
            "Paid ₹" +
            amount +
            " using PayPal");
    }
}
class UPIPayment
        implements PaymentStrategy {

    @Override
    public void pay(int amount) {

        System.out.println(
            "Paid ₹" +
            amount +
            " using UPI");
    }
}
class PaymentContext {

    private PaymentStrategy strategy;

    public PaymentContext(
            PaymentStrategy strategy) {

        this.strategy = strategy;
    }

    public void makePayment(
            int amount) {

        strategy.pay(amount);
    }
}
public class StrategyPatternExample {

    public static void main(String[] args) {

        PaymentContext payment;

        payment =
            new PaymentContext(
                new CreditCardPayment());

        payment.makePayment(5000);

        payment =
            new PaymentContext(
                new PayPalPayment());

        payment.makePayment(3000);

        payment =
            new PaymentContext(
                new UPIPayment());

        payment.makePayment(1000);
    }
}
