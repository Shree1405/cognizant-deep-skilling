import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class CalculatorClientTest {

    @Test
    void testUsingArgumentMatchers() {

        CalculatorService mockService = mock(CalculatorService.class);

        when(mockService.add(anyInt(), anyInt())).thenReturn(100);

        CalculatorClient client = new CalculatorClient(mockService);

        int result = client.calculate(5, 10);

        assertEquals(100, result);

        verify(mockService).add(anyInt(), anyInt());
    }
}
