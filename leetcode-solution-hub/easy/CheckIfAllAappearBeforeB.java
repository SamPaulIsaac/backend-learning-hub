public class CheckIfAllAappearBeforeB {
    public static void main(String[] args) {
        String s = "bbb";
        System.out.println("Does all 'A/a' appear before 'B/b' in the given String: " + s + " => " + !s.contains("ba"));
    }
}

