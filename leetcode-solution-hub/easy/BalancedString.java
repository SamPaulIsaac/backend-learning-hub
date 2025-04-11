import java.util.ArrayList;
import java.util.List;

public class BalancedString {
    public static void main(String[] args) {
        String input = "LLLLRRRR";
        List<String> strings = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) != input.charAt(i + 1)) {
                stringBuilder.append(input, i, i + 2);
                i += 1;
                strings.add(stringBuilder.toString());
            }
        }
        System.out.println("SB: " + stringBuilder);
        System.out.println("L: " + strings);
    }
}
