import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

public class PaymentProcessorTest {

    @Test
    public void testExceptionHandling() {

        PaymentGateway mockGateway =
                mock(PaymentGateway.class);

        doThrow(new RuntimeException("Payment Failed"))
                .when(mockGateway)
                .processPayment();

        PaymentProcessor processor =
                new PaymentProcessor(mockGateway);

        assertThrows(RuntimeException.class,
                () -> processor.makePayment());

        verify(mockGateway).processPayment();
    }
}