import java.util.Arrays;

public class GenericMethodImplementation {

    public static void main(String[] args) {
        GenericMethodImplementation genericMethodImplementation
                = new GenericMethodImplementation();
        Integer[] integers = {1, 2, 3, 4, 5};
        genericMethodImplementation.swap(integers, 1, 3);
        System.out.println("After: " + Arrays.toString(integers));
        String[] strings = {"abc", "def", "ghi", "jkl", "mno"};
        genericMethodImplementation.swap(strings, 1, 3);
        System.out.println("After: " + Arrays.toString(strings));


    }

    public <A> void swap(A[] array, int pos1, int pos2) {
        if (pos1 > 0 && pos1 < array.length && pos2 < array.length) {
            A temp = array[pos1];
            array[pos1] = array[pos2];
            array[pos2] = temp;
        }
    }
}
