import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnitTests {
    @Test
    @DisplayName("can add two short numbers")
    void canAddTwoShortNumbers() {
        String num1 = "11", num2 = "22";
        assertEquals("33", Main.addNumeric(num1, num2));
    }

    @Test
    @DisplayName("can add two uneven length numbers")
    void canAddTwoUnevenLengthNumbers() {
        String num1 = "111", num2 = "22";
        assertEquals("133", Main.addNumeric(num1, num2));
    }

    @Test
    @DisplayName("can add two numbers with carry")
    void canAddTwoNumbersWithCarry() {
        String num1 = "777", num2 = "54";
        assertEquals("831", Main.addNumeric(num1, num2));
    }
}
