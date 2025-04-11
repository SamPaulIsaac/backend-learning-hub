import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortMapValues {
    public static void main(String[] args) {
        Map<String, Integer> map =
                Map.of(
                        "India",100000,
                        "SL",5000,
                        "Barbados",25000
                );

        Map<String,Integer> result = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        ( e1,e2)->e1, LinkedHashMap::new
                ));
        System.out.println("Result: "+result);
    }
}
