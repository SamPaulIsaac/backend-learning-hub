import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByWordLength {
    public static void main(String[] args) {
        List<String> words = List.of("apple", "bat", "banana", "ant", "dog", "elephant");
        Map<Integer,List<String>> result = words
                .stream().collect(Collectors.groupingBy(String::length));
        System.out.println("Group by word length: "+result);


    }
}
