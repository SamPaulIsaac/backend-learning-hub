import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static void main(String[] args) {
        int n = 11;
        System.out.println("Result: " + isHappy(n));

    }

    public static boolean isHappy(int n) {
        Set<Integer> seenNumbers = new HashSet<>();
        while (n != 1 && !seenNumbers.contains(n)) {
            seenNumbers.add(n);
            n = sumOfSquaresOfDigits(n);
        }
        return n == 1;
    }


    public static int sumOfSquaresOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}
