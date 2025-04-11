public class GenericImplementation {
    public static void main(String[] args) {
        Pair<String, String> pair1 = new Pair<>("system", "admin");
        pair1.getValueAndType();
        Pair<String, Integer> pair2 = new Pair<>("system", 5);
        pair2.getValueAndType();
        Pair<Integer, Integer> pair3 = new Pair<>(1, 100);
        pair3.getValueAndType();
        Pair<Double, Long> pair4 = new Pair<>(22.5, 10503L);
        pair4.getValueAndType();
        Pair<Float, Byte> pair5 = new Pair<>(12.5F, (byte) 5);
        pair5.getValueAndType();
    }
}

class Pair<S, P> {

    private S first;
    private P second;

    public Pair(S first, P second) {
        this.first = first;
        this.second = second;
    }

    public S getFirst() {
        return first;
    }

    public void setFirst(S first) {
        this.first = first;
    }

    public P getSecond() {
        return second;
    }

    public void setSecond(P second) {
        this.second = second;
    }

    public void getValueAndType() {
        System.out.println("Value of S: " + getFirst());
        System.out.println("Type of S: " + getFirst().getClass());
        System.out.println("Value of P: " + getSecond());
        System.out.println("Type of P: " + getSecond().getClass());
    }
}
