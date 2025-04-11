package Queue;

public class LinkedBlockingQueue {
    public static void main(String[] args) {
        java.util.concurrent.LinkedBlockingQueue<Integer> linkedBlockingQueue = new java.util.concurrent.LinkedBlockingQueue<>();

        Thread thread = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    linkedBlockingQueue.put(i);
                    System.out.println("First: " + i);
                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                System.out.println("Ex: " + e.getMessage());
            }
        });

        Thread another = new Thread(() -> {
            try {
                for (int i = 6; i <= 10; i++) {
                    linkedBlockingQueue.put(i);
                    System.out.println("Another: " + i);
                    Thread.sleep(1000);

                }
            } catch (Exception e) {
                System.out.println("Ex: " + e.getMessage());
            }
        });

        Thread total = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    System.out.println("TAKE: " + linkedBlockingQueue.take());
                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                System.out.println("Ex: " + e.getMessage());
            }
        });
        thread.start();
        another.start();
        total.start();

    }
}
