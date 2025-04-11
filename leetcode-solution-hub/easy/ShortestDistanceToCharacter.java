import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShortestDistanceToCharacter {
    public static void main(String[] args) {
        String s = "loveleetcode";
        char c = 'e';
        System.out.println("The result is: " + Arrays.toString(shortestToChar(s, c)));
    }

    public static int[] shortestToChar(String s, char c) {
        List<Integer> positions = new ArrayList<>();
        int[] result = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) positions.add(i);
        }

        for (int i = 0; i < s.length(); i++) {
            int minDistance = Integer.MAX_VALUE;
            for (int pos : positions)
                minDistance = Math.min(minDistance, Math.abs(i - pos));
            result[i] = minDistance;
        }
        return result;
    }
}
