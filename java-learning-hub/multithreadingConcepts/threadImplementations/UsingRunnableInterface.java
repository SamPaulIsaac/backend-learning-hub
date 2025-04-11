class Cricketer implements Runnable {

    private final String cricketerName;

    public Cricketer(String name) {
        this.cricketerName = name;  // Assign a name to each Cricketer
    }

    @Override
    public void run() {
        // Log the start of the task
        System.out.println(cricketerName + " is executed by thread: " + Thread.currentThread().getName() +
                " with priority: " + Thread.currentThread().getPriority());
        try {
            // Simulate task execution with a delay
            Thread.sleep(500);  // 500ms delay to simulate a task
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " was interrupted.");
        }
        // Log the end of the task
        System.out.println(cricketerName + " has finished execution by thread: " + Thread.currentThread().getName());
    }
}

public class UsingRunnableInterface {
    public static void main(String[] args) {
        // Create 5 Cricketer objects with names
        Cricketer cricketer1 = new Cricketer("First Cricketer");
        Cricketer cricketer2 = new Cricketer("Second Cricketer");
        Cricketer cricketer3 = new Cricketer("Third Cricketer");
        Cricketer cricketer4 = new Cricketer("Fourth Cricketer");
        Cricketer cricketer5 = new Cricketer("Fifth Cricketer");

        // Create threads and assign custom priorities
        Thread thread1 = new Thread(cricketer1);
        thread1.setName("First");
        thread1.setPriority(Thread.MAX_PRIORITY);  // Priority 10

        Thread thread2 = new Thread(cricketer2);
        thread2.setName("Two");
        thread2.setPriority(Thread.NORM_PRIORITY + 2);  // Priority 7

        Thread thread3 = new Thread(cricketer3);
        thread3.setName("Three");
        thread3.setPriority(Thread.NORM_PRIORITY);  // Priority 5

        Thread thread4 = new Thread(cricketer4);
        thread4.setName("Four");
        thread4.setPriority(Thread.NORM_PRIORITY - 2);  // Priority 3

        Thread thread5 = new Thread(cricketer5);
        thread5.setName("Five");
        thread5.setPriority(Thread.MIN_PRIORITY);  // Priority 1

        // Start all threads
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        // Wait for all threads to complete execution
        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted.");
        }

        // Indicate that all threads have finished
        System.out.println("All cricketers have completed their tasks.");
    }
}
