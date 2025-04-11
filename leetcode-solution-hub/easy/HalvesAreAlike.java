public class HalvesAreAlike {
    public static void main(String[] args) {
        String s = "textbook";
        String split1 = s.substring(0, s.length() / 2).replaceAll("[^aeiouAEIOU]", "");
        String split2 = s.substring(s.length() / 2).replaceAll("[^aeiouAEIOU]", "");
        if (split1.length() == split2.length())
            System.out.println("TRUE");
        else
            System.out.println("FALSE");
    }
}
