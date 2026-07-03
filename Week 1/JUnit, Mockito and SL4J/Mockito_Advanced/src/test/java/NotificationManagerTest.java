import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

public class NotificationManagerTest {

    @Test
    public void testMethodInvocationCount() {

        EmailService mockEmail = mock(EmailService.class);

        NotificationManager manager =
                new NotificationManager(mockEmail);

        manager.sendNotifications();

        verify(mockEmail, times(2)).sendEmail(anyString());

        verify(mockEmail, atLeastOnce()).sendEmail(anyString());

        verify(mockEmail, never()).sendEmail("Failed");
    }
}