import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrentLinkedQueueExercise {
    public static void main(String[] args) {
        // Create a ConcurrentLinkedQueue
        ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();

        // Fill the queue to its capacity using 2 threads in parallel, while consuming the elements from a separate thread
        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.submit(() -> {
            for (int i = 0; i < 50; i++) {
                System.out.println("Trying to produce: " + i);
                queue.offer(i); // Non-blocking, returns true if successful
                System.out.println("Produced: " + i);
            }
        });

        executor.submit(() -> {
            for (int i = 50; i < 100; i++) {
                System.out.println("Trying to produce: " + i);
                queue.offer(i); // Non-blocking
                System.out.println("Produced: " + i);
            }
        });

        // poll elements from the queue using a single thread
        // The consumer will keep on polling till infimite
        // as there is no blocking mechanism in ConcurrentLinkedQueue

        // For Safety, we have addedd a logic that incase the Consumer sees that the queue is empty for 5 times, it will quit
        final int maxEmptyCount = 5; // Maximum times to check for empty queue before quitting
        executor.submit(() -> {
            int emptyCount = 0; // Counter for empty checks
            while(true) {
                Integer value = queue.poll(); // Non-blocking, returns null if the queue is empty
                if (value != null) {
                    System.out.println("Consumed: " + value);
                    emptyCount = 0; // Reset empty count on successful consumption
                } else {
                    System.out.println("Queue is empty, nothing to consume.");
                    emptyCount++;
                    if (emptyCount >= maxEmptyCount) {
                        System.out.println("No more items to consume, quitting.");
                        break; // Exit the loop after maxEmptyCount empty checks
                    }
                }
            }
        });

        executor.shutdown();

        try {
            // Wait for all tasks to finish
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow(); // Force shutdown if tasks are still running
            }
        } catch (InterruptedException e) {
            executor.shutdownNow(); // Force shutdown if interrupted
        }
    }
}
