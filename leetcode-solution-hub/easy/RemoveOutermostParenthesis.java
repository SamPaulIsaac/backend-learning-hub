public class RemoveOutermostParenthesis {
    public static void main(String[] args) {
        String s = "(()())(())";
        int counter = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (counter != 0) stringBuilder.append(c);
                counter++;
            } else if (c == ')') {
                counter--;
                if (counter != 0) stringBuilder.append(c);
            }
        }
        System.out.println(stringBuilder);
    }
}
