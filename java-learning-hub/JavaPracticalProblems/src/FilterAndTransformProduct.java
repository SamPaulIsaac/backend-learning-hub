import java.util.Map;
import java.util.stream.Collectors;

public class FilterAndTransformProduct {
    public static void main(String[] args) {
        Map<String,Double> product = Map.of("cetaphil",50d,
                "johnson",15d,
                "applecider",27d);

        System.out.println("Input product map: "+product);
        Map<String, Double> result = product.entrySet()
                .stream()
                .filter((entry)->(entry.getValue()>20))
                .collect(Collectors.toMap(
                        entry->"Premium"+entry.getKey(),
                        Map.Entry::getValue
                ));
        System.out.println("Filter and transform product map: "+result);
    }
}
