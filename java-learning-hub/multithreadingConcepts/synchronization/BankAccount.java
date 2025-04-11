public class BankAccount {
    private int balance = 0;


    public int getBalance() {
        return this.balance;
    }
    public void deposit(int amount) {
        System.out.println("Attempting to deposit: " + amount);

        synchronized (this) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Deposited: " + amount + ". New balance: " + balance);
            } else {
                System.out.println("Invalid deposit amount: " + amount);
            }
        }

        // This message will be printed only after the synchronized block is completed
        System.out.println("Deposit operation complete.");
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        Thread t1 = new Thread(() -> account.deposit(100));
        Thread t2 = new Thread(() -> account.deposit(200));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final balance: " + account.getBalance());
    }
}
