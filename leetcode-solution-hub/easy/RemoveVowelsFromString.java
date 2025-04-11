public class RemoveVowelsFromString {
    public static void main(String[] args) {
        String s = "life is awesome";
        System.out.println(s.replaceAll("[aeiouAEIOU]", ""));
    }
}
