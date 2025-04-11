import java.util.Scanner;

public class GenerateStringHavingOddCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter count of characters: ");
        int n = scanner.nextInt();
        String output;
        if (n % 2 != 0) output = "a".repeat(Math.max(0, n));
        else output = "a".repeat(Math.max(0, n - 1)) + 'b';
        System.out.println("Result: " + output);
    }
}
