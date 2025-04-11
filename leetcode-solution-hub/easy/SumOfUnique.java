import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class SumOfUnique {
    public static void main(String[] args) {
        int[] integerArray = {1, 2, 3, 2};
        solveUsingMap(integerArray);
        solveUsingArray(integerArray);
    }

    private static void solveUsingArray(int[] integerArray) {
        int[] result = new int[101];
        for (int value : integerArray) result[value] = result[value] == 0 ? 1 : -1;
        System.out.println("SUM using Array: " + IntStream.range(0, result.length)
                .filter(a -> result[a] == 1).sum());
    }

    private static void solveUsingMap(int[] integerArray) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int i : integerArray) {
            if (result.containsKey(i)) result.put(i, result.get(i) + 1);
            else result.put(i, 1);
        }

        int sum = 0;
        for (int value : integerArray)
            if (result.get(value) == 1) sum += value;

        System.out.println("SUM using Map: " + sum);

        // Commenting below since it takes more time.
        /*System.out.println("SUM using Map: " +
                result.entrySet().stream().filter(integerEntry -> integerEntry.getValue() == 1).mapToInt(Map.Entry::getKey).sum());
    */
    }
}
