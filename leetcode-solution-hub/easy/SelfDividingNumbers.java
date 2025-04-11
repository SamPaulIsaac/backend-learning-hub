import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {
    public static void main(String[] args) {
        int left = 47, right = 85;
        List<Integer> list = new ArrayList<>();
        while (left <= right) {
            String str = Integer.toString(left);
            char[] chars = str.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (char aChar : chars) {
                int current = aChar - '0';
                if (current != 0) {
                    if (left % current == 0) {
                        sb.append(current);
                    }
                }
                if (sb.length() == str.length())
                    list.add(Integer.valueOf(sb.toString()));
            }
            left++;
        }
        System.out.println("Final List: " + list);
    }
}
