public class RemoveTrailingzeroes {
    public static void main(String[] args) {
        String input = "51230100";
        int lastIndex = input.length() - 1;
        while (lastIndex >= 0 && input.charAt(lastIndex) == '0') lastIndex--;
        System.out.println(input.substring(0, lastIndex + 1));
    }
}
