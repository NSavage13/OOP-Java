import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatePassword {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a password: ");
        String password = input.nextLine();

        while (!isValidPassword(password)) {
            System.out.println("Invalid password. Must contain:");
            System.out.println("- At least two uppercase letters");
            System.out.println("- At least three lowercase letters");
            System.out.println("- At least one digit");
            System.out.print("Enter a password: ");
            password = input.nextLine();
        }

        System.out.println("Password is valid.");
        input.close();
    }

    public static boolean isValidPassword(String password) {
        
        /** The Regular expression .* will tell the computer that any character
        can be used any number of times. **/

        String upperCasePattern = ".*[A-Z].*[A-Z].*";
        String lowerCasePattern = ".*[a-z].*[a-z].*[a-z].*";
        String digitPattern = ".*[0-9].*";

        // check for at least two uppercase letters
        Matcher upperCaseMatcher = Pattern.compile(upperCasePattern).matcher(password);
        // check for at least three lowercase letters
        Matcher lowerCaseMatcher = Pattern.compile(lowerCasePattern).matcher(password);
        // check for at least one digit
        Matcher digitMatcher = Pattern.compile(digitPattern).matcher(password);

        return upperCaseMatcher.matches() && lowerCaseMatcher.matches() && digitMatcher.matches();
        
    }
    
}
