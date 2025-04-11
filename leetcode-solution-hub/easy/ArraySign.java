import java.math.BigInteger;
import java.util.Arrays;

public class ArraySign {
    public static void main(String[] args) {
        int[] nums = {41, 65, 14, 80, 20, 10, 55, 58, 24, 56, 28, 86, 96, 10, 3, 84, 4, 41, 13, 32, 42, 43, 83, 78, 82, 70, 15, -41};

        System.out.println("Sign using biginteger approach: " + solutionUsingBigInteger(nums));
        System.out.println("Sign using alternative approach: " + solution(nums));

    }

    private static int solution(int[] nums) {
        int negativeCount = 0;
        for (int i : nums) {
            if (i == 0) return 0;
            else if (i < 0) negativeCount++;
        }
        if (negativeCount % 2 == 0) return 1;
        else return -1;
    }

    private static int solutionUsingBigInteger(int[] nums) {
        BigInteger multiply = Arrays.stream(nums).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE, BigInteger::multiply);
        return multiply.signum();
    }
}
