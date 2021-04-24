import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.ouch.Validator;

public class ValidatorTest {
    @Test
    public void testValidate() {
        Validator validator = new Validator();
        Assertions.assertFalse(validator.validate("- 10 + 3 / 5"));
        Assertions.assertFalse(validator.validate("4++3"));
        Assertions.assertFalse(validator.validate("10 - a"));
        Assertions.assertFalse(validator.validate("10-(3+6)"));
    }
}
