
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    private Calculator calc;

    @BeforeEach
    void setUp() {
        calc = new Calculator();
    }

    @Test
    void testAdd() {
        assertEquals(5, calc.add(2, 3));
        assertEquals(0, calc.add(-1, 1));
        assertEquals(-5, calc.add(-2, -3));
    }
//
    @Test
    void testSubtract() {
        assertEquals(2, calc.subtract(5, 3));
        assertEquals(-2, calc.subtract(3, 5));
        assertEquals(0, calc.subtract(5, 5));
    }

    @Test
    void testMultiply() {
        assertEquals(6, calc.multiply(2, 3));
        assertEquals(0, calc.multiply(0, 5));
        assertEquals(-10, calc.multiply(-2, 5));
    }

    @Test
    void testDivide() {
        assertEquals(2.5, calc.divide(5, 2), 0.001);
        assertEquals(1.0, calc.divide(3, 3), 0.001);
    }

    @Test
    void testDivideByZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calc.divide(10, 0);
        });
        assertEquals("Cannot divide by zero", exception.getMessage());
    }
}