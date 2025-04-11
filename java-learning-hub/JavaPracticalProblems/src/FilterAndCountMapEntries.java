import java.util.Map;

public class FilterAndCountMapEntries {
    public static void main(String[] args) {
        Map<String,Integer> map = Map.of(
                "A",7,
                "B",15,
                "D",23,
                "C",5);

        System.out.println("Count of products whose stock quantity is less than 10: "+ map.entrySet()
                .stream()
                .filter(entry -> entry.getValue()<10)
                .count());

    }
}
