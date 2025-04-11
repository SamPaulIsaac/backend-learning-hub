public class CountOddNos {
    public static void main(String[] args) {
        int low = 0, high = 1000000000;
        System.out.println("Count odd nos using first approach resulting in longer response time: " + solution1(low, high));
        System.out.println("Count odd nos using second approach which is faster: " + solution2(low, high));
    }

    public static int solution1(int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++)
            if (i % 2 != 0) count++;
        return count;
    }

    public static int solution2(int low, int high) {
        int count = (high - low) / 2;
        if (low % 2 != 0 || high % 2 != 0)
            count++;
        return count;
    }
}
