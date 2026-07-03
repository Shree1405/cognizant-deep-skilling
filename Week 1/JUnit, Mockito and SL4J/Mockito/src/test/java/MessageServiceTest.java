import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MessageServiceTest {

    @Test
    void testSpy() {

        // Create a real object
        MessageService realService = new MessageService();

        // Create a spy
        MessageService spyService = spy(realService);

        // Stub one method
        doReturn("Mocked Hello").when(spyService).getMessage();

        // Test stubbed method
        assertEquals("Mocked Hello", spyService.getMessage());

        // Test real method
        assertEquals("Hello Shubaashree", spyService.greet("Shubaashree"));

        // Verify interaction
        verify(spyService).getMessage();
        verify(spyService).greet("Shubaashree");
    }
}
