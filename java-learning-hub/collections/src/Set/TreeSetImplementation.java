package Set;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetImplementation {
    public static void main(String[] args) {
        Comparator<String> check = Comparator.comparingInt(Object::hashCode);
        TreeSet<String> set = new TreeSet<>(check);
        set.add("adam");
        set.add("abraham");
        set.add("brahmin");
        set.add("calvin");
        set.forEach(System.out::println); //Maintains Order
    }
}
