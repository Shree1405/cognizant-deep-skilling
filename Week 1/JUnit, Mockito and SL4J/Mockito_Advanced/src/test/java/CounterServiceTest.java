import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CounterServiceTest {

    @Test
    public void testMultipleReturns() {

        // Create mock repository
        CounterRepository mockRepository = mock(CounterRepository.class);

        // Return different values on successive calls
        when(mockRepository.getCount()).thenReturn(1, 2, 3);

        // Create service
        CounterService service = new CounterService(mockRepository);

        // Verify returned values
        assertEquals(1, service.getNextCount());
        assertEquals(2, service.getNextCount());
        assertEquals(3, service.getNextCount());
    }
} 

