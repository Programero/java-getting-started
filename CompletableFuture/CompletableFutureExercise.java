package CompletableFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

// Do this chaining of async tasks using CompletableFuture
// Task1-----Task4----Task5----Print the Results
// Task2-----         Task6----
// Task3-----         

public class CompletableFutureExercise {
    public static void main(String[] args) {
        // Task 1: Simulate a long-running task
        CompletableFuture<String> task1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000); // Simulate a long-running task
                System.out.println("Task 1 completed");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Result of Task 1";
        });

        // Task 2: Simulate another long-running task
        CompletableFuture<String> task2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000); // Simulate a longer-running task
                System.out.println("Task 2 completed");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Result of Task 2";
        });

        // Task 3: Simulate yet another long-running task
        CompletableFuture<String> task3 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000); // Simulate an even longer-running task
                System.out.println("Task 3 completed");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Result of Task 3";
        });

        List<String> results = new ArrayList<>();
        
        // Returns a CompletableFuture that completes when all of the given CompletableFutures complete
        CompletableFuture<Void> combinedCF = CompletableFuture.allOf(task1, task2, task3);

        combinedCF.thenRun(() -> {
            System.out.println("All tasks completed. Now running Task 4.");
            //Store the results of Task 1, Task 2, and Task 3 into List<String> results
            try {
                results.add(task1.get());
                results.add(task2.get());
                results.add(task3.get());
            } catch (Exception e) {
                System.err.println("Error retrieving results: " + e.getMessage());
            }
        });

        combinedCF.join(); // Wait for all tasks to complete
        
        CompletableFuture<String> task4 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println(results); // Print the results of Task 1, Task 2, and Task 3
                Thread.sleep(1000); // task that runs after Task 1, Task 2, and Task 3
                System.out.println("Task 4 completed");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return results.get(0) + results.get(1) + results.get(2) + "Result of Task 4";
        });

        CompletableFuture<String> task5 = task4.thenApplyAsync(result -> {
            System.out.println("Task 5 is running after Task 4");
            return result + " and Result of Task 5";
        });
        
        CompletableFuture<String> task6 = task4.thenApplyAsync(result -> {
            System.out.println("Task 6 is running after Task 4");
            return result + " and Result of Task 6";
        });

        task5.thenCombine(task6, (result5, result6) -> {
            System.out.println("Final Results: " + result5 + " | " + result6);
            return "";
        }).join();
    }
}
