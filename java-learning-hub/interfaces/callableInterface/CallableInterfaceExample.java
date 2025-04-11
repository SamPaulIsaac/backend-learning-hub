package callableInterface;

import java.util.concurrent.*;


public class CallableInterfaceExample implements Callable<Integer> {

    public static void main(String[] args) {

        /* Types of Executor Services - many but mainly focusing on the below 3.
          1. Fixed Thread Pool
          2. Cached Thread Pool - Dynamic
          3. Single Thread
         */
//            ExecutorService executorService = Executors.newFixedThreadPool(5);
//            ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future = executorService.submit(new CallableInterfaceExample());
        try {
            int result = future.get();
            System.out.println(result);
            executorService.shutdown();
        } catch (ExecutionException e) {
            System.out.println("Execution Exception occurred: " + e.getMessage());

        } catch (InterruptedException ie) {
            System.out.println("Interrupted Exception occurred: " + ie.getMessage());
        }
    }

    @Override
    public Integer call() {
        int result = 0;
        for (int i = 1; i <= 10; i++) result += i;
        return result;
    }
}
