import java.util.HashMap;
import java.util.Map;

public class ContainsNearbyDuplicate {
    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 1};
        int k = 1;
        System.out.println("Result: " + solution(nums, k));
    }

    public static boolean solution(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int value = nums[i];
                if (map.containsKey(value)) {
                    if (Math.abs(map.get(value) - i) <= k) return true;
                }
                map.put(value, i);
            }
            return false;
    }
}
