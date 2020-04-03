package output;

import org.junit.Test;

import static org.junit.Assert.*;

public class OutputFormatterTest {

    private OutputFormatter outputFormatter = new OutputFormatter();

    @Test
    public void test_createOutputStringFromValidator_ValidPassword() {
        String expected = "The password is valid.";
        assertEquals(expected, outputFormatter.createOutputStringFromValidation(true));
    }

    @Test
    public void test_createOutputStringFromValidator_invalidPassword() {
        String expected = "The password is NOT valid!";
        assertEquals(expected, outputFormatter.createOutputStringFromValidation(false));
    }
}