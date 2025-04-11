import java.util.Arrays;

public class MaxNoOfWordsInASentence {
    public static void main(String[] args) {
        String[] sentences = {"alice and bob love leetcode", "i think so too", "this is great thanks very much"};
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < sentences.length; i++) {
//            map.put(i, sentences[i].split(" ").length);
//        }
//        System.out.println(map.values().stream().max(Integer::compareTo).get());

        System.out.println(Arrays.stream(sentences)
                .mapToInt(sentence -> sentence.split(" ").length)
                .max()
                .orElse(0));
    }
}
