import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {3, 3, 4};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);
        int max = map.entrySet().stream().max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey).orElse(0);

        System.out.println("Max: " + max);
    }
}
