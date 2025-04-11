class Account extends Thread {
    private final String number;
    private final int withdraw;
    private final int balance = 100;
    // private final AtomicInteger balanceAmount = new AtomicInteger(100);

    public Account(String number, int withdraw) {
        this.number = number;
        this.withdraw = withdraw;
    }

    @Override
    public void run() {
        if (balance >= withdraw) {
            int calc = withdraw - balance;
            System.out.println(Thread.currentThread().getName() + " is trying to withdraw "
                    + this.withdraw + " from the account " + this.number
                    + " and the remaining balance is " + calc);
        } else {
            System.out.println("Withdraw not possible due to insufficient funds.");
        }
    }
}

public class CRAScenario {
    public static void main(String[] args) {
        Account thread1 = new Account("ICICI100", 100);
        thread1.setName("First Thread");
        Account thread2 = new Account("ICICI100", 100);
        thread2.setName("Second Thread");
        thread1.start();
        thread2.start();
    }
}
