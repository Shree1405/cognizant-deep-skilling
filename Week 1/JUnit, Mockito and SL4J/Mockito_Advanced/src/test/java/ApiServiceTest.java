import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ApiServiceTest {

    @Test
    public void testApiService() {

        // Create mock API
        ExternalApi mockApi = mock(ExternalApi.class);

        // Stub API response
        when(mockApi.fetchData()).thenReturn("Mock API Data");

        // Create service
        ApiService service = new ApiService(mockApi);

        // Call service method
        String result = service.getApiData();

        // Verify result
        assertEquals("API Response: Mock API Data", result);
    }
}
