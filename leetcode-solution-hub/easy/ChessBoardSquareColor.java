import java.util.Scanner;

public class ChessBoardSquareColor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the coordinates: ");
        String s = scanner.next();
        System.out.println(isSquareWhite(s));
        scanner.close();
    }

    static boolean isSquareWhite(String s) {
        int result = (s.charAt(0) - 'A') % 2;
        return (result == 0) == (s.charAt(1) % 2 == 0); //FALSE & FALSE IS TRUE
    }
}
