package output;

public class OutputFormatter {

    public String createOutputStringFromValidation(boolean isValid){
        if (isValid){
            return "The password is valid.";
        }else{
            return "The password is NOT valid!";
        }
    }
}
