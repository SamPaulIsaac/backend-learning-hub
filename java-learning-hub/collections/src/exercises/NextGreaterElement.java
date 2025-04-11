package exercises;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement {

    public static int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                map.put(stack.pop(), nums[i]);
            }
            stack.push(i);
        }

        for (int i = 0; i < nums.length; i++) {
            result[i] = map.getOrDefault(i, -1);
        }

        stack.empty();
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 2, 10, 8};
        int[] result = nextGreaterElements(nums);

        System.out.println("Original Array: " + java.util.Arrays.toString(nums));
        System.out.println("Next Greater Elements: " + java.util.Arrays.toString(result));
    }
}

