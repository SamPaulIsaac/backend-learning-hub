class DaemonThread extends Thread {
    private volatile boolean running = true; // Flag to control the loop

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is a daemon thread.");

        while (running) { // Check flag condition
            try {
                Thread.sleep(1000); // Simulate a background task every second
                System.out.println(Thread.currentThread().getName() + " is still running...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName() + " has stopped.");
    }

    // Method to stop the thread
//    public void stopRunning() {
//        running = false;
//    }
}

public class DaemonExampleWithCondition {
    public static void main(String[] args) throws InterruptedException {
        DaemonThread daemonThread = new DaemonThread();
        daemonThread.setDaemon(true);
        daemonThread.setName("DaemonThread");

        daemonThread.start();

        // Main thread simulates work for 5 seconds
        Thread.sleep(5000);

        System.out.println("Main thread has finished.");

        // Adding a delay to observe the daemon thread's behavior
        Thread.sleep(5000); // Additional 5 seconds to observe daemon thread

        System.out.println("Exiting program...");
    }
}
