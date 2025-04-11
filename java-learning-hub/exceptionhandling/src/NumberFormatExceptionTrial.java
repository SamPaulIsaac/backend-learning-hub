public class NumberFormatExceptionTrial {
    public static void main(String[] args) {
        try {
            Long value = new Long("Abc");
        } catch (NumberFormatException exception) {
            System.out.println("Exception" + exception.toString());
            throw new NumberFormatException(exception.getMessage());
        } finally {
            System.out.println("Hey, I can still execute!!!");
        }
    }
}
