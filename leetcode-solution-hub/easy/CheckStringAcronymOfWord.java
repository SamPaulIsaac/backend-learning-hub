public class CheckStringAcronymOfWord {
    public static void main(String[] args) {
        String[] words = {"alice", "bob", "charlie"};
        String s = "abc";
        StringBuilder response = new StringBuilder();
        for (String string : words)
            response.append(string.charAt(0));
        if (response.toString().equals(s))
            System.out.println("TRUE");
        else
            System.out.println("FALSE");
    }
}
