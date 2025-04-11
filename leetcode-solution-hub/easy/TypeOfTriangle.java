public class TypeOfTriangle {
    public static void main(String[] args) {
        int[] nums = {3, 4, 4};
        System.out.println(solution(nums));
    }

    static String solution(int[] nums) {
        if (checkValidTriangle(nums)) {
            if (nums[0] == nums[1] && nums[1] == nums[2] && nums[0] == nums[2]) return "equilateral";
            else if (nums[0] == nums[1] || nums[1] == nums[2] || nums[0] == nums[2]) return "isosceles";
            else if (nums[0] != nums[1] && nums[1] != nums[2] && nums[0] != nums[2]) return "scalene";
        }
        return "none";
    }

    static boolean checkValidTriangle(int[] nums) {
        return nums[0] + nums[1] > nums[2] && nums[1] + nums[2] > nums[0] && nums[0] + nums[2] > nums[1];
    }
}
