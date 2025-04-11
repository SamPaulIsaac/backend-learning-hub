class Worker extends Thread {
    private volatile boolean isRunning = true;

    @Override
    public void run() {
        while (isRunning) {
            System.out.println(Thread.currentThread().getName() + " is in execution.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void update() {
        this.isRunning = false;
    }
}

public class VolatileExample {
    public static void main(String[] args) throws InterruptedException {
        Worker obj1 = new Worker();
        obj1.setName("t1");
        Worker obj2 = new Worker();
        obj2.setName("t2");
        obj1.start();
        obj2.start();
        Thread.sleep(3000);
        obj1.update();
        System.out.println("Process completed!");
        //Since obj2 is not updated, it keeps executing!
    }
}
