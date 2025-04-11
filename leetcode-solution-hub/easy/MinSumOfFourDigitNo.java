import java.util.Arrays;

public class MinSumOfFourDigitNo {
    public static void main(String[] args) {
        int num = 1234;
        int[] numArray = new int[4];
        for (int i = 0; i < 4; i++) {
            numArray[i] = num % 10;
            num = num / 10;
        }
        Arrays.sort(numArray);
        System.out.println((numArray[0] * 10 + numArray[2]) + (numArray[1] * 10 + numArray[3]));

    }
}
