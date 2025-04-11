import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

public class ThirdMax {
    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 1};
        System.out.println("Third max: " + solution(nums));
    }

    public static int solution(int[] nums) {
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        for (int i : nums)
            linkedHashSet.add(i);

        List<Integer> list = new ArrayList<>(linkedHashSet);
        Collections.sort(list, Collections.reverseOrder());

        if (list.size() < 3) return list.get(0);
        else return list.get(2);
    }
}
