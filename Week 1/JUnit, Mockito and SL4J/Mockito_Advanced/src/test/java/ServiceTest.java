import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ServiceTest {

    @Test
    public void testServiceWithMockRepository() {

        // Create mock repository
        Repository mockRepository = mock(Repository.class);

        // Stub the repository method
        when(mockRepository.getData()).thenReturn("Mock Data");

        // Create service
        Service service = new Service(mockRepository);

        // Call service method
        String result = service.processData();

        // Verify output
        assertEquals("Processed Mock Data", result);
    }
}