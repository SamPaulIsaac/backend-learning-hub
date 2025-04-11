public class ArithmeticExceptionTrial {
    public static void main(String[] args) {
        /* Divide by zero come under arithmetic exception */
        try {
            int value1 = 15;
            int value2 = 0;
            int result = value1 / value2;
            System.out.println("Result :- " + result);

        } catch (java.lang.ArithmeticException exception) {
            System.out.println("Exception" + exception.toString());
            throw new java.lang.ArithmeticException(exception.getMessage());
        } finally {
            System.out.println("How are you man, I can still execute!!!");
        }
    }

}

