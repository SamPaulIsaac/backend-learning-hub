import java.util.HashSet;
import java.util.Set;

public class StringPairs {
    public static void main(String[] args) {
        String[] words = {"aa", "ab"};
        int count = 0;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (!words[i].equals(words[j])) {
                    if (words[i].contentEquals(new StringBuilder(words[j]).reverse())) {
                        count++;
                        if (set.isEmpty()) set.add(words[i]);
                        if (!set.contains(words[i]) ||
                                !set.contains(new StringBuilder(words[j]).reverse().toString())) {
                            set.add(words[i]);
                        }
                    }
                }
            }
            System.out.println(count);
        }
        System.out.println("SET: " + set);
        System.out.println("SET SIZE: " + set.size());

    }
}
