import input.PasswordInput;
import output.OutputFormatter;
import validator.PasswordValidator;

public class Main {

    public static void main(String[] args) {
        PasswordInput passwordInput = new PasswordInput();
        PasswordValidator validator = new PasswordValidator();
        OutputFormatter outputFormatter = new OutputFormatter();

        String inputString = passwordInput.getInputFromConsole();
        boolean isValid = validator.isValid(inputString);
        String outputString = outputFormatter.createOutputStringFromValidation(isValid);

        System.out.println(outputString);
    }

}
