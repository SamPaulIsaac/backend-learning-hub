import java.util.Arrays;

public class ArithmeticProgression {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4};
        System.out.println("Can make arithmetic progression: " + solution(arr));
    }

    public static boolean solution(int[] arr) {
        if (arr.length <= 2) return true;
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++)
            if (Math.abs(arr[i] - arr[i - 1]) != diff) return false;
        return true;
    }
}
