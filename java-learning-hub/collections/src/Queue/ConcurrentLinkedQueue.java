package Queue;

public class ConcurrentLinkedQueue {
    public static void main(String[] args) {
        java.util.concurrent.ConcurrentLinkedQueue<Integer> linkedBlockingQueue = new java.util.concurrent.ConcurrentLinkedQueue<>();

        Thread thread = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    linkedBlockingQueue.add(i);
                    System.out.println("First: " + i);
                }
            } catch (Exception e) {
                System.out.println("Ex: " + e.getMessage());
            }
        });

        Thread another = new Thread(() -> {
            try {
                for (int i = 6; i <= 10; i++) {
                    linkedBlockingQueue.add(i);
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
                    System.out.println("TAKE: " + linkedBlockingQueue.poll());
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
