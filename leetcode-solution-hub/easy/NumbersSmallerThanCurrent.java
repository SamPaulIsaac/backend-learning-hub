import java.util.Arrays;

public class NumbersSmallerThanCurrent {
    public static void main(String[] args) {
        int[] nums = {8, 1, 2, 2, 3};
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int num : nums) if (nums[i] > num) count++;
            result[i] = count;
        }
        System.out.println("Result: " + Arrays.toString(result));
    }
}
