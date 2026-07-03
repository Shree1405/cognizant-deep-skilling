import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExceptionThrowerTest {

    @Test
    void testException() {

        ExceptionThrower exceptionThrower = new ExceptionThrower();

        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> {
                    exceptionThrower.throwException();
                });

        assertEquals("This is an exception", exception.getMessage());
    }
}