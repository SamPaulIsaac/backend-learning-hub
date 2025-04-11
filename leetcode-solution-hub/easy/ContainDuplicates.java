import java.util.HashSet;
import java.util.Set;

public class ContainDuplicates {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println("Does it contain duplicates: " + checkDuplicates(nums));

    }

    public static boolean checkDuplicates(int[] nums) {
        Set<Integer> seenNumbers = new HashSet<>();
        for (int num : nums) {
            if (!seenNumbers.add(num)) {
                return true; // Duplicate found
            }
        }
        return false;
    }
}
