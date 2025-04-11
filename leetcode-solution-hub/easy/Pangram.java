import java.util.Arrays;

public class Pangram {
    public static void main(String[] args) {
        String sentence = "thequickbrownfoxjumpsoverthelazydo";
//        Map<Character, Integer> map = new HashMap<>();
//        for (Character s : sentence.toCharArray()) {
//            if (!map.containsKey(s))
//                map.put(s, 1);
//        }
//
//        System.out.println(map.values().size()==26);

        int[] count = new int[26];
        for (char current : sentence.toCharArray()) {
            count['z' - current]++;
        }
        if (Arrays.stream(count).filter(a -> a == 0).findAny().isPresent())
            System.out.println(false);
        System.out.println("true");
    }
}
