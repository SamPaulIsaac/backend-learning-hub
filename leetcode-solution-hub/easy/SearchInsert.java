public class SearchInsert {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println("Result: " + solution(nums));
    }

    public static int solution(int[] nums) {
        int target = 4;
        int index = 0;
        if (target > nums[nums.length - 1]) return nums.length;
        else {
            for (int i = 0; i < nums.length; i++) {
                if (target == nums[i]) return i;
                else if (target < nums[i]) return i;
            }
        }
        return index;
    }
}
