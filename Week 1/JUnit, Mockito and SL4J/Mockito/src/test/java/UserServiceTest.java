import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class UserServiceTest {

    @Test
    void testNotificationSent() {

        
        NotificationService mockService = Mockito.mock(NotificationService.class);

       
        UserService userService = new UserService(mockService);

       
        userService.registerUser("Shubaashree");

       
        verify(mockService).sendNotification("Welcome Shubaashree");
    }
}
