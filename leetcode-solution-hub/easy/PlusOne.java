import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        int[] digits = {9, 9, 9, 9, 9, 9, 9, 9, 9, 9};
        System.out.println(Arrays.toString(solution(digits)));
    }

    public static int[] solution(int[] digits) {
        int arrayLength = digits.length;
        for (int i = arrayLength - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        digits = new int[arrayLength + 1];
        digits[0] = 1;
        return digits;
    }
}
