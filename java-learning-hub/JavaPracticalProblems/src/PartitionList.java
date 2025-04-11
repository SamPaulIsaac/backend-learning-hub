import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitionList {
    public static void main(String[] args) {
        List<Integer> integerList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> odd = integerList.stream().filter(a -> a % 2 == 0).toList();
        List<Integer> even = integerList.stream().filter(a -> a % 2 != 0).toList();
        System.out.println("ODD: " + odd);
        System.out.println("EVEN: " + even);
        System.out.println("-----------SECOND APPROACH----------");
        Map<Boolean, List<Integer>> booleanListMap =
                integerList.stream()
                        .collect(Collectors.partitioningBy(a -> a % 2 == 0));
        System.out.println("Boolean map list: " + booleanListMap);
        System.out.println("Odd numbers in the list: " + booleanListMap.get(false));
        System.out.println("Even numbers in the list: " + booleanListMap.get(even));
    }
}
