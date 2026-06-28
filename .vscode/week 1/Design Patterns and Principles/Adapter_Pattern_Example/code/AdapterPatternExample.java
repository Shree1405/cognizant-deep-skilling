package Adapter_Pattern_Example.code;
interface PaymentProcessor {

    void processPayment();
}
class GooglePayGateway {

    public void sendPayment() {

        System.out.println("Payment processed through Google Pay");
    }
}
class PaytmGateway {

    public void makePayment() {

        System.out.println("Payment processed through Paytm");
    }
}
class RazorpayGateway {

    public void payNow() {

        System.out.println("Payment processed through Razorpay");
    }
}
class GooglePayAdapter
        implements PaymentProcessor {

    private GooglePayGateway gateway;

    public GooglePayAdapter(
            GooglePayGateway gateway) {

        this.gateway = gateway;
    }

    @Override
    public void processPayment() {

        gateway.sendPayment();
    }
}
class PaytmAdapter
        implements PaymentProcessor {

    private PaytmGateway gateway;

    public PaytmAdapter(
            PaytmGateway gateway) {

        this.gateway = gateway;
    }

    @Override
    public void processPayment() {

        gateway.makePayment();
    }
}
class RazorpayAdapter
        implements PaymentProcessor {

    private RazorpayGateway gateway;

    public RazorpayAdapter(
            RazorpayGateway gateway) {

        this.gateway = gateway;
    }

    @Override
    public void processPayment() {

        gateway.payNow();
    }
}
public class AdapterPatternExample {
    public static void main(String[] args) {

        PaymentProcessor googlepay =
            new GooglePayAdapter(
                new GooglePayGateway());

        PaymentProcessor paytm =
            new PaytmAdapter(
                new PaytmGateway());

        PaymentProcessor razorpay =
            new RazorpayAdapter(
                new RazorpayGateway());

        googlepay.processPayment();
        paytm.processPayment();
        razorpay.processPayment();
    }
    
}
