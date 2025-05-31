package CompletableFuture;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureExercise {
    public static void main(String[] args) {
        Callable<String> callable1 = () -> {
            Thread.sleep(3000); // Simulate a long-running task
            System.out.println("callable1 is runnng");
            return "Task completed";
        };

        Callable<String> callable2 = () -> {
            Thread.sleep(2000); // Simulate a longer-running task
            System.out.println("callable2 is runnng");
            return "Another task completed";
        };

        Callable<String> callable3 = () -> {
            Thread.sleep(1000); // Simulate an even longer-running task
            System.out.println("callable3 is runnng");
            return "Yet another task completed";
        };

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        try {
            List<Future<String>> tasksList = executorService.invokeAll(List.of(callable1, callable2, callable3)); // returns the List of Futures only after all the tasks completes 
            System.out.println("All tasks submitted. Waiting for results...");
            for (Future<String> future : tasksList) {
                try {
                    System.out.println(future.get()); // Get the result of each task
                } catch (Exception e) {
                    System.err.println("Error retrieving result: " + e.getMessage());
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
        System.out.println("All tasks Completed.");
    }
}
