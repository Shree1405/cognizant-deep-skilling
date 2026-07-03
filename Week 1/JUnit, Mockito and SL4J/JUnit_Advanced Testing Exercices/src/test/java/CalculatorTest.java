import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    void testAddition() {
        assertEquals(10, 5 + 5);
    }

    @Test
    void testMultiplication() {
        assertEquals(20, 4 * 5);
    }
}
