import java.util.HashSet;
import java.util.Set;

public class ArithmeticTriplets {
    public static void main(String[] args) {
        int[] nums = {0, 1, 4, 6, 7, 10};
        int diff = 3;
        int arithmeticTripletsCount = 0;
        Set<Integer> integerSet = new HashSet<>();
        for (int num : nums) integerSet.add(num);
        for (int num : nums) {
            if (integerSet.contains(num - diff) && integerSet.contains(num + diff))
                arithmeticTripletsCount++;
        }
        System.out.println("RESULT: " + arithmeticTripletsCount);
    }

}
