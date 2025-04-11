public class UnnamedPatternAndVariable {
    public static void main(String[] args) {
        String inputString = "Hello everyone.";
        try {
            int number = Integer.parseInt(inputString);
        } catch (NumberFormatException _) {
            System.out.println("Invalid input: " + inputString);
        }
    }
}
