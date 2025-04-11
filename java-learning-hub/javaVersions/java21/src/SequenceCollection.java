import java.util.ArrayList;
import java.util.List;

public class SequenceCollection {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.addFirst(0);
        list.add(1);
        list.addLast(2);
        int firstElement = list.getFirst();
        int lastElement = list.getLast();
        System.out.println(STR."First element: \{firstElement}");
        System.out.println(STR."Last element: \{lastElement}");
        System.out.println(STR."Second element: \{list.get(1)}");
    }
}
