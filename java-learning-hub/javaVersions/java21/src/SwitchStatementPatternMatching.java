import java.util.Scanner;

public class SwitchStatementPatternMatching {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the value: ");
        String input = scanner.next();
        switch (input) {
            case "yes", "yup", "yeah" -> System.out.println("Yes Man!");
            case "no", "nah", "nope" -> System.out.println("Sorry, no Man!");
            default -> System.out.println("Thank you");
        }
    }
}