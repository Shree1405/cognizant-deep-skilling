import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;

public class OrderProcessorTest {

    @Test
    void testInteractionOrder() {

        OrderService mockService = mock(OrderService.class);

        OrderProcessor processor = new OrderProcessor(mockService);

        processor.processOrder();

        InOrder inOrder = inOrder(mockService);

        inOrder.verify(mockService).login();
        inOrder.verify(mockService).placeOrder();
        inOrder.verify(mockService).logout();
    }
}
