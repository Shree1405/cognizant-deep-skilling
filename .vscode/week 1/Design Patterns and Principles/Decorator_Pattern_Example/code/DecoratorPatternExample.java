package Decorator_Pattern_Example.code;
interface Notifier {

    void send();
}
class EmailNotifier
        implements Notifier {

    @Override
    public void send() {

        System.out.println(
            "Sending Email Notification");
    }
}
abstract class NotifierDecorator
        implements Notifier {

    protected Notifier notifier;

    public NotifierDecorator(
            Notifier notifier) {

        this.notifier = notifier;
    }
}
class SMSNotifierDecorator
        extends NotifierDecorator {

    public SMSNotifierDecorator(
            Notifier notifier) {

        super(notifier);
    }

    @Override
    public void send() {

        notifier.send();

        System.out.println(
            "Sending SMS Notification");
    }
}
class SlackNotifierDecorator
        extends NotifierDecorator {

    public SlackNotifierDecorator(
            Notifier notifier) {

        super(notifier);
    }

    @Override
    public void send() {

        notifier.send();

        System.out.println(
            "Sending Slack Notification");
    }
}
public class DecoratorPatternExample {
    public static void main(String[] args) {

        Notifier notifier =
            new SlackNotifierDecorator(
                new SMSNotifierDecorator(
                    new EmailNotifier()
                )
            );

        notifier.send();
    }
    
    
}
