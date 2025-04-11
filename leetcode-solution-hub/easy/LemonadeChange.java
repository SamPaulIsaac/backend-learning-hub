import java.util.HashMap;
import java.util.Map;

public class LemonadeChange {
    public static void main(String[] args) {
        int[] bills = {5, 5, 10, 20, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 5, 20, 5, 20, 5};
        System.out.println(solution(bills));
    }

    public static boolean solution(int[] bills) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(5, 0);
        map.put(10, 0);
        for (int bill : bills) {
            if (bill == 5) {
                map.put(5, map.get(5) + 1);
            } else if (bill == 10) {
                if (map.get(5) == 0) return false;
                map.put(5, map.get(5) - 1);
                map.put(10, map.get(10) + 1);
            } else if (bill == 20) {
                if (map.get(10) > 0 && map.get(5) > 0) {
                    map.put(10, map.get(10) - 1);
                    map.put(5, map.get(5) - 1);
                } else if (map.get(5) >= 3) {
                    map.put(5, map.get(5) - 3);
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
