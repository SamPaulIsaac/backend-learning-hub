public class ValidPalindrome {
    public static void main(String[] args) {

        String input = "A man, a plan, a canal: Panama";
        String updated = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        System.out.println(new StringBuilder(updated).reverse().toString().equals(updated));
    }
}
