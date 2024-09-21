import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnitTests {
    @Test
    @DisplayName("add two short numbers")
    void canAddTwoShortNumbers() {
        String num1 = "11", num2 = "22";
        assertEquals(33, Main.addNumeric(num1, num2));
    }
}
