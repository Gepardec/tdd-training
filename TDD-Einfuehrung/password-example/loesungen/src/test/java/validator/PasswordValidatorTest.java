package validator;

import org.junit.Test;

import static org.junit.Assert.*;

public class PasswordValidatorTest {

    private PasswordValidator validator = new PasswordValidator();

    @Test
    public void test_isValid_correctLength(){
        assertTrue(validator.isValid("12345A!"));
    }

    // TODO: 5 und 10 Zeichen lang Tests

    @Test
    public void test_isValid_tooShort() {
        assertFalse(validator.isValid("1234"));
    }

    @Test
    public void test_isValid_tooLong() {
        assertFalse(validator.isValid("12345678901"));
    }

    @Test
    public void test_isValid_withoutNumber(){
        assertFalse(validator.isValid("abcde"));
    }

    @Test
    public void test_isValid_withNumber(){
        assertTrue(validator.isValid("abc123!"));
    }

    @Test
    public void test_isValid_withoutLetter(){
        assertFalse(validator.isValid("12345"));
    }

    @Test
    public void test_isValid_withtLetter(){
        assertTrue(validator.isValid("Abc123!"));
    }

    @Test
    public void test_isValid_withoutSpecialChar(){
        assertFalse(validator.isValid("Abc123"));
    }

    @Test
    public void test_isValid_withSpecialChar(){
        assertTrue(validator.isValid("Abc123!"));
    }

    @Test
    public void test_isValid_withWhitespace(){
        assertFalse(validator.isValid("Abc 123!"));
    }
}