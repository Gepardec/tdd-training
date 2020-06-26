package input;

import java.util.Scanner;

public class PasswordInput {

    public String getInputFromConsole(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter text: ");
        return input.next();
    }
}
