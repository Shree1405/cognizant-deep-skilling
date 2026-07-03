import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Test
    void testGetUserById() {

        // Step 1: Create mock repository
        UserRepository mockRepository = mock(UserRepository.class);

        // Step 2: Create sample user
        User user = new User(1L, "Shubaashree");

        // Step 3: Stub repository method
        when(mockRepository.findById(1L))
                .thenReturn(Optional.of(user));

        // Step 4: Create service
        UserService service = new UserService(mockRepository);

        // Step 5: Call service method
        User result = service.getUserById(1L);

        // Step 6: Verify result
        assertEquals("Shubaashree", result.getName());
    }
}