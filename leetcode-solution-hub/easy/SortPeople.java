import java.util.*;

public class SortPeople {
    public static void main(String[] args) {
        String[] names = {"Alice", "Bob", "Bob"};
        Integer[] height = {155, 185, 150};
        System.out.println(Arrays.toString(check(names, height)));
    }

    public static String[] check(String[] names, Integer[] height) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        List<String> finalList = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            map.put(height[i], i);
        }
        Map<Integer, Integer> sortedMap = new TreeMap<>(Collections.reverseOrder());
        sortedMap.putAll(map);

        System.out.println(sortedMap);
        System.out.println(sortedMap.values());
        for (int i : sortedMap.values()) {
            finalList.add(names[i]);
        }
        return finalList.toArray(new String[0]);
    }
}
