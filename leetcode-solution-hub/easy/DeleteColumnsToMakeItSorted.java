public class DeleteColumnsToMakeItSorted {
    public static void main(String[] args) {
        int deleteCount = 0;
        String[] strs = {"zyx", "wvu", "tsr"};

        for (int col = 0; col < strs[0].length(); col++) {
            for (int row = 1; row < strs.length; row++) {
                if (strs[row - 1].charAt(col) > strs[row].charAt(col)) {
                    deleteCount++;
                    break;
                }
            }
        }
        System.out.println("Number of columns to delete: " + deleteCount);
    }
}
