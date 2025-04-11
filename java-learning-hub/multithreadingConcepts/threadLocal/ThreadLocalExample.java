import java.util.concurrent.*;

public class ThreadLocalExample implements Callable<Integer> {
    private final ThreadLocal<Integer> threadLocal = new ThreadLocal<>();


    @Override
    public Integer call() {
        int result = 0;
        for (int i = 1; i <= 10; i++) {
            result += i;
            System.out.println("CHECK: " + threadLocal.get());
            threadLocal.set(threadLocal.get() == null ? 1 : threadLocal.get() + 1);
            System.out.println("Thread " + Thread.currentThread().getName() + " counter: " + threadLocal.get());
        }
        return result;
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<Integer> future = executorService.submit(new ThreadLocalExample());
        try {
            int result = future.get();
            System.out.println(result);
        } catch (ExecutionException e) {
            System.out.println("Execution Exception occurred: " + e.getMessage());
        } catch (InterruptedException ie) {
            System.out.println("Interrupted Exception occurred: " + ie.getMessage());
        } finally {
            executorService.shutdown();
        }
    }
}