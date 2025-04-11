import java.util.HashMap;
import java.util.Map;

public class EqualCharOccurrence {
    public static void main(String[] args) {
        String s = "abacbc";
        Map<Character, Integer> integerMap = new HashMap<>();
        for (Character c : s.toCharArray())
            integerMap.put(c, integerMap.getOrDefault(c, 0) + 1);
        int firstValue = integerMap.values().iterator().next();
        System.out.println(integerMap.values().stream().allMatch(a -> a == firstValue));
    }
}
