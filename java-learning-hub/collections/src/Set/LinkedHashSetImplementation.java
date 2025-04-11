package Set;

import java.util.LinkedHashSet;

public class LinkedHashSetImplementation {
    public static void main(String[] args) {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("adam");
        linkedHashSet.add("abraham");
        linkedHashSet.add("brahmin");
        linkedHashSet.add("calvin");
        linkedHashSet.forEach(System.out::println); //Maintains Order
    }
}
