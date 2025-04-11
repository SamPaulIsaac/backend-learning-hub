package Set;

import java.util.HashSet;
import java.util.Set;

public class HashSetImplementation {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("abraham");
        set.add("brahmin");
        set.add("calvin");
        set.add("calvin");
        set.forEach(System.out::println);
    }
}
