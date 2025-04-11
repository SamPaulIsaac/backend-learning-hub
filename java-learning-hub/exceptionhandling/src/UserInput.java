import exceptions.customException.AgeCannotBeNegativeException;

public class UserInput {
    public static void main(String[] args) throws Exception {
        UserInput userInput = new UserInput();
        try {
            userInput.isValidAge(25);
            userInput.isValidAge(-5);
        } catch (AgeCannotBeNegativeException exception) {
            System.out.println("Exception:- " + exception);
        } finally {
            System.out.println("Finally!!!!!!!!!!");
        }
        userInput.sam();
    }

    void isValidAge(int age) throws Exception {

        if (age < 0) {
            throw new AgeCannotBeNegativeException("Hey, Age cannot be less than 1! Wish you spent at least the time " +
                    "to learn using the system");
        } else {
            System.out.println("Hey Genuine Person :) ");
        }
    }

    void sam() {
        System.out.println("Inside");
    }

}
