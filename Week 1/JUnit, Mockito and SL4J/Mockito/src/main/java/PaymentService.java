public class PaymentService {

    private PaymentGateway paymentGateway;

    public PaymentService(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public String makePayment(double amount) {
        return paymentGateway.processPayment(amount);
    }
}
