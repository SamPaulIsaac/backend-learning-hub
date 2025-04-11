import java.util.concurrent.atomic.AtomicInteger;

/*
Using synchronized is not mandatory with AtomicInteger because AtomicInteger provides atomic operations that are inherently thread-safe. However, the key issue is coordinating multiple operations.

In your scenario, you're performing two operations:

Checking if the balance is sufficient (balance.get() >= withdraw)
Deducting the withdrawal amount (balance.getAndAdd(-withdraw))
Even though each individual operation on AtomicInteger is thread-safe, the combination of these two operations is not atomic. Without synchronization, a race condition can occur:

Thread 1 checks the balance and finds it sufficient.
Before Thread 1 can withdraw, Thread 2 also checks the balance and finds it sufficient (both threads may see the same initial balance).
Both threads proceed to withdraw the same amount, potentially leaving the balance negative, which is incorrect.
 */
class AccountUpdated extends Thread {
    private final String number;
    private final int withdraw;
    private static final AtomicInteger balance = new AtomicInteger(100);

    public AccountUpdated(String number, int withdraw) {
        this.number = number;
        this.withdraw = withdraw;
    }

    @Override
    public void run() {
        synchronized (balance) {
            if (balance.get() >= withdraw) {
                balance.getAndAdd(-withdraw);
                System.out.println(Thread.currentThread().getName() + " is trying to withdraw "
                        + this.withdraw + " from the account " + this.number
                        + " and the remaining balance is " + balance.get());
            } else {
                System.out.println(Thread.currentThread().getName() + " is trying to withdraw "
                        + this.withdraw + " from the account " + this.number + " but withdraw not possible due to insufficient funds.");
            }
        }
    }
}

public class ResolutionForCRAScenario {
    public static void main(String[] args) {
        AccountUpdated thread1 = new AccountUpdated("ICICI100", 100);
        thread1.setName("First Thread");
        AccountUpdated thread2 = new AccountUpdated("ICICI100", 100);
        thread2.setName("Second Thread");
        thread1.start();
        thread2.start();
    }
}