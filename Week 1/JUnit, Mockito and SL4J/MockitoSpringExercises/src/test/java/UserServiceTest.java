import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Test
    void testGetUserById() {

        UserRepository repository = mock(UserRepository.class);

        when(repository.findById(1L))
                .thenReturn(Optional.of(new User(1L, "Shubaashree")));

        UserService service = new UserService(repository);

        User user = service.getUserById(1L);

        assertEquals("Shubaashree", user.getName());

    }
}