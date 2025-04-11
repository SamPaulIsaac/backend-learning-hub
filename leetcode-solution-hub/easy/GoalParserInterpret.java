public class GoalParserInterpret {
    public static void main(String[] args) {

        String command = "(al)G(al)()()G";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < command.length(); i++) {
            char currentChar = command.charAt(i);
            if (currentChar == 'G') {
                stringBuilder.append(currentChar);
            } else if (currentChar == '(' && command.charAt(i + 1) == ')') {
                stringBuilder.append('o');
            } else if (currentChar == '('
                    && command.charAt(i + 1) == 'a'
                    && command.charAt(i + 2) == 'l'
                    && command.charAt(i + 3) == ')') {
                stringBuilder.append('a');
                stringBuilder.append('l');
            }
        }
        System.out.println("SB: " + stringBuilder);
    }
}
