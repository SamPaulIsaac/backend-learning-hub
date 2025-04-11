public class MonotonicArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println("Is array monotonic: " + solution(nums));
    }

    public static boolean solution(int[] nums) {
        if (nums.length == 0) return true;
        boolean asc = true, desc = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) desc = false;
            if (nums[i] < nums[i - 1]) asc = false;
        }
        return asc || desc;
    }
}
