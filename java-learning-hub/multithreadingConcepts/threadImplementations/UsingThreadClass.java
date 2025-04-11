class Footballer extends Thread {

    @Override
    public void run() {
        System.out.println("Execution started by the thread: " + Thread.currentThread().getName()
                + " & having the priority value: " + Thread.currentThread().getPriority());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " is Interrupted by: " + e.getMessage());
        }
        System.out.println("Execution completed by the thread: " + Thread.currentThread().getName());
    }
}

public class UsingThreadClass {
    public static void main(String[] args) {
        Footballer thread1 = new Footballer();
        Footballer thread2 = new Footballer();
        Footballer thread3 = new Footballer();
        Footballer thread4 = new Footballer();
        Footballer thread5 = new Footballer();
        thread1.setName("First");
        thread2.setName("Two");
        thread3.setName("Three");
        thread4.setName("Four");
        thread5.setName("Five");

        // Set custom priorities (1 = MIN, 10 = MAX, 5 = NORM)
        thread1.setPriority(Thread.MAX_PRIORITY);  // Priority 10
        thread2.setPriority(Thread.NORM_PRIORITY + 2);  // Priority 7
        thread3.setPriority(Thread.NORM_PRIORITY);  // Priority 5
        thread4.setPriority(Thread.NORM_PRIORITY - 2);  // Priority 3
        thread5.setPriority(Thread.MIN_PRIORITY);  // Priority 1

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " is Interrupted by: " + e.getMessage());
        }
        System.out.println("JUST TO SEE main thread is not executed before the completion of all other child threads!");
    }
}
