import java.util.ArrayList;
import java.util.List;

public class LivelockExample {
    private static final List<Integer> sharedList = new ArrayList<>();

    public static void main(String[] args) {
        Thread adder = new Thread(() -> {
            while (true) {
                synchronized (sharedList) {
                    if (sharedList.isEmpty()) {
                        System.out.println("Adder: Adding 1 to the list");
                        sharedList.add(1); // Adds an element
                    } else {
                        System.out.println("Adder: List is not empty, waiting for remover...");
                    }
                }
                try {
                    Thread.sleep(100); // Simulate some delay
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread remover = new Thread(() -> {
            while (true) {
                synchronized (sharedList) {
                    if (!sharedList.isEmpty()) {
                        System.out.println("Remover: Removing the element from the list");
                        sharedList.remove(0); // Removes an element
                    } else {
                        System.out.println("Remover: List is empty, waiting for adder...");
                    }
                }
                try {
                    Thread.sleep(100); // Simulate some delay
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        adder.start();
        remover.start();
    }
}

