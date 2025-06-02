import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ArrayBlockingQueueExercise {
    public static void main(String[] args) {
        // Create an ArrayBlockingQueue with a capacity of 5
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(100);

        // Fill the queue to its capacity using three threads in parallel
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // take elements from the queue using a single thread
        executor.submit(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    Integer value = queue.take(); // Blocks if the queue is empty on Condition variable notEmpty
                    System.out.println("Consumed: " + value);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        executor.submit(() -> {
            for (int i = 0; i < 50; i++) {
                try {
                    queue.put(i); // Blocks if the queue is full on Condition variable notFull
                    System.out.println("Produced: " + i);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        executor.submit(() -> {
            for (int i = 50; i < 100; i++) {
                try {
                    queue.put(i); // Blocks if the queue is full
                    System.out.println("Produced: " + i);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        executor.shutdown();

        try {
            // Wait for all tasks to finish
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow(); // Force shutdown if tasks are still running
            }
        } catch (InterruptedException e) {
            executor.shutdownNow(); // Force shutdown if interrupted
        }

        System.out.println("All tasks completed. Queue after all the elements produced have been consumed: " + queue);

    }
}