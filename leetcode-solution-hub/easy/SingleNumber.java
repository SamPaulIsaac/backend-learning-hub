public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1};
        System.out.println(solution(nums));
    }

    public static int solution(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int n : nums)
//            map.put(n, map.getOrDefault(n, 0) + 1);
//        return map.entrySet().stream()
//                .filter(a -> a.getValue() == 1)
//                .map(Map.Entry::getKey).findFirst().get();

        int result = 0;
        for (int num : nums) result ^= num;
        return result;
    }
}
