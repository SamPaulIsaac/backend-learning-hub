public class NumJewelsInStone {
    public static void main(String[] args) {
        String jewels = "z";
        String stones = "ZZ";
        int count = 0;
        for (int i = 0; i < stones.toCharArray().length; i++) {
            if (jewels.indexOf(stones.charAt(i)) != -1)
                count++;
        }
        System.out.println("COUNT: " + count);
    }
}
