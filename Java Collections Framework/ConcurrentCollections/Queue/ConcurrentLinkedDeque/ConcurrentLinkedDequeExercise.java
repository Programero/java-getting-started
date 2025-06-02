import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrentLinkedDequeExercise {
    public static void main(String[] args) {
        // Create a ConcurrentLinkedDeque
        ConcurrentLinkedDeque<Integer> deque = new ConcurrentLinkedDeque<>();

        // Fill the deque to its capacity using 2 threads in parallel, while consuming the elements from two separate threads
        ExecutorService executor = Executors.newFixedThreadPool(4);

        // Inserts elements into the deque from start
        executor.submit(() -> {
            for (int i = 0; i < 50; i++) {
                System.out.println("Trying to produce: " + i);
                deque.offerFirst(i); // Non-blocking
                System.out.println("Produced: " + i);
            }
        });

        // Inserts elements into the deque from end
        executor.submit(() -> {
            for (int i = 50; i < 100; i++) {
                System.out.println("Trying to produce: " + i);
                deque.offerLast(i); // Non-blocking
                System.out.println("Produced: " + i);
            }
        });

        // Poll elements from the deque using two separate threads
        // The consumers will keep on polling till infinite
        // as there is no blocking mechanism in ConcurrentLinkedDeque
        // For Safety, we have added a logic that in case the Consumer sees that the deque is empty for 5 times, it will quit
        final int maxEmptyCount = 5; // Maximum times to check for empty deque before quitting
        executor.submit(() -> {
            int emptyCount = 0; // Counter for empty checks
            while (true) {
                Integer value = deque.pollFirst(); // Non-blocking, returns null if the deque is empty
                if (value != null) {
                    System.out.println("Consumed from front: " + value);
                    emptyCount = 0; // Reset empty count on successful consumption
                } else {
                    System.out.println("Deque is empty, nothing to consume from front.");
                    emptyCount++;
                    if (emptyCount >= maxEmptyCount) {
                        System.out.println("No more items to consume from front, quitting.");
                        break; // Exit the loop after maxEmptyCount empty checks
                    }
                }
            }
        });

        executor.submit(() -> {
            int emptyCount = 0; // Counter for empty checks
            while (true) {
                Integer value = deque.pollLast(); // Non-blocking, returns null if the deque is empty
                if (value != null) {
                    System.out.println("Consumed from back: " + value);
                    emptyCount = 0; // Reset empty count on successful consumption
                } else {
                    System.out.println("Deque is empty, nothing to consume from back.");
                    emptyCount++;
                    if (emptyCount >= maxEmptyCount) {
                        System.out.println("No more items to consume from back, quitting.");
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
