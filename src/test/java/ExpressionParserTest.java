import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.ouch.ExpressionParser;

import java.util.Deque;

public class ExpressionParserTest {
    @Test
    public void testConvertToRpn() {
        ExpressionParser parser = new ExpressionParser();
        Deque<String> firstResult = parser.convertToRPN("3 + 10 - 34");
        Deque<String> secondResult = parser.convertToRPN("30 / 5 + 100 * 56 - 34");

        Assertions.assertEquals("3 10 + 34 -",
                convertDequeToString(firstResult));
        Assertions.assertEquals("30 5 / 100 56 * + 34 -",
                convertDequeToString(secondResult));
    }

    private String convertDequeToString(Deque<String> deque) {
        StringBuilder resultInString = new StringBuilder();
        for (String element : deque) {
            resultInString.append(element).append(" ");
        }
        return resultInString.toString().trim();
    }

}
