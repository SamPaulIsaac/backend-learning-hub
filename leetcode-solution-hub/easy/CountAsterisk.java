public class CountAsterisk {
    public static void main(String[] args) {
        String s = "iamprogrammer";
        int count = 0;
        String[] strings = s.split("\\|");
        for (int i = 0; i < strings.length; i = i + 2) {
            for (int j = 0; j < strings[i].length(); j++) {
                if (strings[i].charAt(j) == '*') count++;
            }
        }
        System.out.println("COUNT: " + count);
    }
}
