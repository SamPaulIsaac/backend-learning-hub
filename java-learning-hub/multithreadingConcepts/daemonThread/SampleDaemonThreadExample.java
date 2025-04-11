class ThreadType extends Thread {

    public void run() {
        if (Thread.currentThread().isDaemon())
            System.out.println(Thread.currentThread().getName() + " is a daemon thread.");
        else System.out.println(Thread.currentThread().getName() + " is a user thread.");


        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(Thread.currentThread().getName() + " is working...");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName() + " has finished execution.");
    }
}

public class SampleDaemonThreadExample {
    public static void main(String[] args) throws InterruptedException {
        ThreadType thread1 = new ThreadType();
        thread1.setName("t1");
        ThreadType thread2 = new ThreadType();
        thread2.setName("t2");
        thread2.setDaemon(true);
        thread2.setPriority(1);
        thread1.start();
        thread2.start();

        // Main thread sleeps for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main thread finished.");
        System.out.println(thread1.getState());
        System.out.println(thread2.getState());
    }
}
