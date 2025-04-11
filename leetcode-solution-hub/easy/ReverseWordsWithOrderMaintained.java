public class ReverseWordsWithOrderMaintained {
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        StringBuilder finalResult = new StringBuilder();
        for (String splitString : s.split(" ")) {
            if (finalResult.length() != 0)
                finalResult.append(" ");
            finalResult.append(new StringBuilder(splitString).reverse());
        }
        System.out.println("RESULT: " + finalResult);
    }
}
