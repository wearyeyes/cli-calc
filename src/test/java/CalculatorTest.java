import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.ouch.Calculator;
import org.ouch.exception.DividingByZeroException;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class CalculatorTest {

    @Test
    public void checkDividingByZeroException() {
        Calculator calculator = new Calculator();
        Deque<String> rpn = new ArrayDeque<>();
        rpn.add("30");
        rpn.add("0");
        rpn.add("/");
        assertThrows(DividingByZeroException.class, () -> calculator.calculate(rpn));
    }

    @Test
    public void testCalculate() throws DividingByZeroException {
        Calculator calculator = new Calculator();
        Deque<String> rpn = new ArrayDeque<>(List.of("45", "90", "30.5", "*", "0.5", "/", "-"));
        String result = calculator.calculate(rpn);
        assertEquals("-5445", result);
    }
}
