import java.util.ArrayList;
import java.util.List;

public class CountItemsMatchingARule {
    public static void main(String[] args) {
        List<String> strings1 = new ArrayList<>();
        List<String> strings2 = new ArrayList<>();
        List<String> strings3 = new ArrayList<>();
        strings1.add("phone");
        strings1.add("blue");
        strings1.add("pixel");
        strings2.add("computer");
        strings2.add("silver");
        strings2.add("lenovo");
        strings3.add("phone");
        strings3.add("gold");
        strings3.add("iphone");
        List<List<String>> items = new ArrayList<>();
        items.add(strings1);
        items.add(strings2);
        items.add(strings3);
        String ruleKey = "type";
        String ruleValue = "phone";

        int position = 0;
        if (ruleKey.equals("color"))
            position = 1;
        else if (ruleKey.equals("name"))
            position = 2;

        System.out.println("RESULT: " + countMatches(items, ruleKey, ruleValue, position));

    }

    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue, int position) {

        int count = 0;
        for (List<String> item : items) {
            if (item.get(position).equals(ruleValue))
                count++;
        }
        return count;
    }
}
