import java.util.Iterator;
import java.util.Set;

import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import java.lang.Thread;



public class CopyOnWriteArraySetExercise {
    public static void main(String [] args) {
        CopyOnWriteArraySet<String> set = new CopyOnWriteArraySet<>();
        set.add("Apple");
        set.add("Banana");
        set.add("Orange");
        set.add("Grapes");
        set.add("Mango");

        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.execute(() -> {
            Iterator<String> iterator = set.iterator();
            System.out.println("Thread 1: Iterating over the set");
            // Simulate some processing
            try {
                System.out.println("Thread 1: Sleeping for 100ms, after creating iterator1, meanwhile the set will be modified to contain one more element \"Pineapple\"");
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            while (iterator.hasNext()) {
                String fruit = iterator.next();
                System.out.println("Iterator1: " + fruit);
            }
        });
        executor.execute(() -> {
            set.add("Pineapple");
            System.out.println("Added Pineapple");
        });

        executor.execute(() -> {
            Iterator<String> iterator = set.iterator();
            System.out.println("Thread 2: Iterating over the set");
            while (iterator.hasNext()) {
                String fruit = iterator.next();
                System.out.println("Iterator2: " + fruit);
            }
        });

        executor.shutdown();
        // Wait for all tasks to finish
        try {
            if (!executor.awaitTermination(1, java.util.concurrent.TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        System.out.println("You can see though the set was modified to have \"Pineapple\", but it didn't appear in Iterator1 as a immutable copy was already created, Final set contents: " + set);
    }
}