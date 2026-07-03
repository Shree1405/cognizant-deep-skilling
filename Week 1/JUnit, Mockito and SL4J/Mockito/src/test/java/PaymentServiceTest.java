import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PaymentServiceTest {

    @Mock
    PaymentGateway paymentGateway;

    @InjectMocks
    PaymentService paymentService;

    @Test
    void testPayment() {

        when(paymentGateway.processPayment(500.0))
                .thenReturn("Payment Successful");

        String result = paymentService.makePayment(500.0);

        assertEquals("Payment Successful", result);
    }
}
