package validator;

import java.util.regex.Pattern;

public class PasswordValidator {

    private Pattern letter = Pattern.compile("[a-zA-z]");
    private Pattern digit = Pattern.compile("[0-9]");
    private Pattern special = Pattern.compile ("[\\W]");
    private Pattern whiteSpace = Pattern.compile("[\\s]");

    public boolean isValid(String password) {
        return lengthIsValid(password) &&
                digit.matcher(password).find() &&
                letter.matcher(password).find() &&
                special.matcher(password).find() &&
                !whiteSpace.matcher(password).find();
    }

    private boolean lengthIsValid(String input) {
        return 10 >= input.length() && input.length() >= 5;
    }
}
