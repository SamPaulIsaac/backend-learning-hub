public class ReversePrefixOfWord {
    public static void main(String[] args) {
        String word = "abcdefd", ch = "d";
        int index = word.indexOf(ch);
        new StringBuilder(word.substring(0, index + 1)).reverse().append(word.substring(index + 1));
        //System.out.println(new StringBuilder(word.substring(0,index+1)).reverse().append(word.substring(index+1)));
    }
}
