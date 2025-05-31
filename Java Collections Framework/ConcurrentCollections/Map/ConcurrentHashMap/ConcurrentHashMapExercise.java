import java.util.Iterator;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.lang.Thread;
import java.util.Map;

public class ConcurrentHashMapExercise {
    public static void main(String [] args) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("1", "Apple");
        map.put("2", "Banana");
        map.put("3", "Orange");
        map.put("4", "Grapes");
        map.put("5", "Mango");

        ExecutorService executor = Executors.newFixedThreadPool(3);

        // First two tasks
        CompletableFuture<Void> task1 = CompletableFuture.runAsync(() -> {
            Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
            System.out.println("Thread 1: Iterating over the map");
            // Simulate some processing
            try {
                System.out.println("Thread 1: Sleeping for 100ms, after creating iterator1, meanwhile the map will be modified to contain one more element \"6\" : \"Pineapple\"");
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("You will see the Iterator1 is weakly consistent has only some of the updated Map values:");
            while (iterator.hasNext()) {
                Map.Entry<String, String> entry = iterator.next();
                System.out.println("Iterator1: " + entry.getKey() + " : " + entry.getValue());
            }
        }, executor);

        CompletableFuture<Void> task2 = CompletableFuture.runAsync(() -> {
            map.put("0", "Kiwi");
            map.put("6", "Pineapple");
            System.out.println("Added Pineapple, Kiwi");
        }, executor);

        CompletableFuture<Void> combined = CompletableFuture.allOf(task1, task2);

        CompletableFuture<Void> task3 = combined.thenRunAsync(() -> {
            Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
            System.out.println("Thread 2: Iterating over the map");
            while (iterator.hasNext()) {
                Map.Entry<String, String> entry = iterator.next();
                System.out.println("Iterator2: " + entry.getKey() + " : " + entry.getValue());
            }
        }, executor);


        
        // Wait for all tasks to finish
        try {
            task3.get();
            executor.shutdown();
            if (!executor.awaitTermination(1, java.util.concurrent.TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        

        System.out.println("Final map contents:");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}