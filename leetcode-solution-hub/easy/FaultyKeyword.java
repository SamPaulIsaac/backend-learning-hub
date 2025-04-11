public class FaultyKeyword {
    public static void main(String[] args) {
        String s = "poiinter";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == 'i') sb.reverse();
            else sb.append(current);
        }
        System.out.println(sb);
    }
}
