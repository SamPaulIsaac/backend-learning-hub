import java.util.Arrays;

public class LargestPerimeterTriangle {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 10};
        System.out.println("Before sorting: " + Arrays.toString(nums));
        Arrays.sort(nums);
        System.out.println("After sorting: " + Arrays.toString(nums));
        System.out.println("Largest perimeter triangle: " + solution(nums));
    }

    public static int solution(int[] nums) {
        for (int i = nums.length - 1; i >= 2; i--) {
            int a = nums[i - 2];
            int b = nums[i - 1];
            int c = nums[i];
            int sum = a + b;
            if (sum > c) return sum + c;
        }
        return 0;
    }
}
