public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = {0, 1};
        System.out.println("Result: " + solution(nums, nums.length));
    }

    public static int solution(int[] nums, int n) {
        int xor = 0;
        for (int i = 0; i <= n; i++) xor ^= i;
        for (int num : nums) xor ^= num;
        return xor;
    }
}
