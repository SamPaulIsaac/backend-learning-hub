import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Operation extends Thread {
    private final List<Integer> integerList;
    private final Boolean isInsertOperation;

    public Operation(List<Integer> integerList, Boolean isInsertOperation) {
        this.integerList = integerList;
        this.isInsertOperation = isInsertOperation;
    }

    @Override
    public void run() {
        if (isInsertOperation) {
            insert();
        } else {
            delete();
        }
    }

    public void insert() {
        synchronized (integerList) {
            System.out.println(Thread.currentThread().getName() + " - Inserting elements...");
            for (int i = 0; i < 10; i++) {
                integerList.add(i);
                System.out.println(Thread.currentThread().getName() + " - Inserted: " + i);
            }
        }
    }

    public void delete() {
        synchronized (integerList) {
            System.out.println(Thread.currentThread().getName() + " - Removing elements...");
            while (!integerList.isEmpty()) {
                int num = integerList.removeFirst();
                System.out.println(Thread.currentThread().getName() + " - Removed: " + num);
            }
        }
    }


}

public class SynchronizedBlockExample {
    public static void main(String[] args) {
        List<Integer> integerList = Collections.synchronizedList(new ArrayList<>());
        Operation insert = new Operation(integerList, true);
        insert.setName("Thread 1");
        Operation delete = new Operation(integerList, false);
        delete.setName("Thread 2");
        insert.start();
        try {
            insert.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        delete.start();
        try {
            insert.join();
            delete.join();
        } catch (InterruptedException e) {
            System.out.println("IE: " + e.getMessage());
        }
        System.out.println("EXECUTED!!!!!!!!");
    }
}
