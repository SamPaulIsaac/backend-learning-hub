import java.util.ArrayList;
import java.util.List;

public class SetMismatch {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - i;
            if (nums[index] > 0) nums[index] = -nums[index];
        }

        for (int i = 0; i < nums.length; i++)
            if (nums[i] > 0) result.add(i + 1);

        System.out.println("Result: " + result);
    }
}
