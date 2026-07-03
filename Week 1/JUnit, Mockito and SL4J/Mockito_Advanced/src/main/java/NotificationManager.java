
public class NotificationManager {

    private EmailService emailService;

    public NotificationManager(EmailService emailService) {
        this.emailService = emailService;
    }

    public void sendNotifications() {
        emailService.sendEmail("Welcome");
        emailService.sendEmail("Reminder");
    }
}