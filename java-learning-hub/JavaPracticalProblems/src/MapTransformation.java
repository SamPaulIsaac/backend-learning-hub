import java.util.Map;
import java.util.stream.Collectors;

public class MapTransformation {
    public static void main(String[] args) {
        Map<String, Double> input1 = Map.of(
                "apple", 1.5,
                "banana", 2.0,
                "cherry", 3.0
        );

        System.out.println("Scenario 1: transforming fruit name and price: " + transformFruitNameAndPrice(input1));

        Map<Integer, String> input2 = Map.of(
                101, "john doe",
                105, "carter",
                107, "parkinson"
        );

        System.out.println("Scenario 2: transforming employee details: " + transformEmployee(input2));


    }

    private static Map<Integer, String> transformEmployee(Map<Integer, String> input2) {
            return input2.entrySet()
                    .stream().collect(Collectors.toMap(
                            Map.Entry::getKey,
                            entry-> entry.getValue().toLowerCase()
                            +"(ID: "+entry.getKey() +")"
                    ));
    }

    private static Map<String, Double> transformFruitNameAndPrice(Map<String, Double> input) {
        System.out.println("Input for map transformation: " + input);
        return input.entrySet()
                        .stream().collect(Collectors.toMap(
                                entry -> entry.getKey().toUpperCase(),
                                entry -> entry.getValue() * 0.85
                        ));
    }
}
