public class SegmentsInString {
    public static void main(String[] args) {
        String s = "        ";
        if (s.trim().length() == 0) System.out.println("Length: 0");
        System.out.println("Length: " + s.trim().split("\\s+").length);
    }
}
