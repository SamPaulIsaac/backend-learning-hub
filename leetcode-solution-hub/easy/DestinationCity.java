import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DestinationCity {
    public static void main(String[] args) {
        List<String> strings1 = new ArrayList<>();
        List<String> strings2 = new ArrayList<>();
        List<String> strings3 = new ArrayList<>();
        strings1.add("London");
        strings1.add("New York");
        strings2.add("New York");
        strings2.add("Lima");
        strings3.add("Lima");
        strings3.add("Sao Paulo");
        List<List<String>> paths = new ArrayList<>();
        paths.add(strings1);
        paths.add(strings2);
        paths.add(strings3);


        Set<String> set = new HashSet<>();
        for (List<String> path : paths) {
            set.add(path.get(0));
        }

        for (List<String> path : paths) {
            if (!set.contains(path.get(1))) {
                System.out.println(path.get(1));
                break;
            }
        }
    }
}
