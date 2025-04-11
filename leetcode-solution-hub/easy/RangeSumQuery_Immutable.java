import java.util.Arrays;
import java.util.List;

public class RangeSumQuery_Immutable {
    public static void main(String[] args) {
        List<String> operations = Arrays.asList("NumArray", "sumRange", "sumRange", "sumRange");
        int[][] parameters = {
                {-2, 0, 3, -5, 2, -1}, // Parameters for NumArray
                {0, 2}, // Parameters for first sumRange
                {2, 5}, // Parameters for second sumRange
                {2, 3}, // Parameters for second sumRange
                {0, 5}  // Parameters for third sumRange
        };

        NumArray obj = null;
        for (int i = 0; i < operations.size(); i++) {
            String operation = operations.get(i);
            if (operation.equals("NumArray")) {
                obj = new NumArray(parameters[i]);
                System.out.println("null"); // The return value for constructing NumArray is null
            } else if (operation.equals("sumRange")) {
                int left = parameters[i][0];
                int right = parameters[i][1];
                System.out.println(obj.sumRange(left, right));
            }
        }

    }
}

class NumArray {
    private int[] prefixSums;

//    public NumArray(int[] nums) {
//        prefixSums = new int[nums.length+1];
//        System.out.println("Prefix sums @@@: "+ Arrays.toString(prefixSums));
//        for(int i=0;i<nums.length;i++) prefixSums[i+1] = prefixSums[i]+ nums[i];
//        System.out.println("Prefix sums: "+ Arrays.toString(prefixSums));
//
//    }
//
//    public int sumRange(int left, int right) {
//        return prefixSums[right + 1] - prefixSums[left];
//    }

    int[] nums;

    public NumArray(int[] nums) {
        System.out.println("Nums Before -> " + Arrays.toString(nums));
        for (int i = 1; i < nums.length; i++)
            nums[i] += nums[i - 1];
        this.nums = nums;
        System.out.println("Nums After -> " + Arrays.toString(nums));

    }

    public int sumRange(int left, int right) {
        if (left == 0) return nums[right];
        return nums[right] - nums[left - 1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */