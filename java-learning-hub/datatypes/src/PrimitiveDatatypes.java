public class PrimitiveDatatypes {
    public static void main(String[] args) {

        int i = 5;
        System.out.println("Value of 'i' : " + i);
        System.out.println("Memory location for i (simulated): " + System.identityHashCode(i));
        i = 7;
        System.out.println("Value of 'i' after update: " + i);
        System.out.println("Memory location for i (simulated): " + System.identityHashCode(i));
        /*
        This implies when we try to change the value of i,
        it doesn't necessarily update the value instead
        it reassigns the value of i, potentially causing the change in memory location. - Primitives are Immutable.
         */
    }
}