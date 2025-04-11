import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeAndRemoveDuplicates {
    public static void main(String[] args) {
        List<Integer> integerList1 = List.of(1, 2, 5, 1, 3, 2);
        List<Integer> integerList2 = List.of(1, 4, 6, 9, 3, 5);

        List<Character> charList1 = List.of('a', 'c', 'e', 'f');
        List<Character> charList2 = List.of('a', 'b', 'd', 'g');

        System.out.println("Merge and remove duplication(Integers): " + genericSolution(integerList1, integerList2));
        System.out.println("Merge and remove duplication(Chars): " + genericSolution(charList1, charList2));

    }

    public static <T> Set<T> genericSolution(List<T> list1, List<T> list2) {
        return Stream.concat(list1.stream(), list2.stream()).collect(Collectors.toSet());
    }
}
