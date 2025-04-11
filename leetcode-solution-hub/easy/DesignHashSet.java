import java.util.ArrayList;
import java.util.List;

public class DesignHashSet {

    private static final int SIZE = 1000;
    private List<Integer>[] table;

    public DesignHashSet() {
        table = new ArrayList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            table[i] = new ArrayList<>();
        }
    }

    public void add(int key) {
        int index = hash(key);
        List<Integer> bucket = table[index];
        if (!bucket.contains(key)) {
            bucket.add(key);
        }
    }

    public void remove(int key) {
        int index = hash(key);
        List<Integer> bucket = table[index];
        bucket.remove(Integer.valueOf(key));
    }

    public boolean contains(int key) {
        int index = hash(key);
        List<Integer> bucket = table[index];
        return bucket.contains(key);
    }

    private int hash(int key) {
        return Math.abs(key) % SIZE;
    }

    public static void main(String[] args) {
        DesignHashSet myHashSet = new DesignHashSet();
        myHashSet.add(1);      // set = [1]
        myHashSet.add(2);      // set = [1, 2]
        System.out.println(myHashSet.contains(1)); // return True
        System.out.println(myHashSet.contains(3)); // return False, (not found)
        myHashSet.add(2);      // set = [1, 2]
        System.out.println(myHashSet.contains(2)); // return True
        myHashSet.remove(2);   // set = [1]
        System.out.println(myHashSet.contains(2)); // return False, (already removed)
    }
}
