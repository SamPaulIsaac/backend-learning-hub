public class PrefixOfWord {
    public static void main(String[] args) {
        String sentence = "hellohello hellohellohello";
        String searchWord = "ell";
        String[] arr = sentence.split(" ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].startsWith(searchWord)) {
                System.out.println("Index: " + (i + 1));
                break;
            }
        }
        System.out.println("No match: -1");
    }
}
