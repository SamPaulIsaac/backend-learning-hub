import java.util.HashMap;
import java.util.Map;

public class LuckyInteger {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 3};
        System.out.println("Is Lucky Integer: " + solution(arr));
    }

    public static int solution(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) map.put(i, map.getOrDefault(i, 0) + 1);
        return map.entrySet().stream().filter((entry) -> entry.getKey().equals(entry.getValue())).map(Map.Entry::getKey).reduce(
                Integer::max).orElse(-1);
    }
}
