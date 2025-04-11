public class FinalValueAfterOperation {
    public static void main(String[] args) {
        String[] operations = {"X++", "++X", "--X", "X--"};
        int x = 0;
        for (String operation : operations) {
            if (operation.startsWith("-") || operation.endsWith("-"))
                x--;
            else
                x++;
        }
        System.out.println(x);
    }
}
