import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PriorityBlockingQueueExercise {
    public static void main(String[] args) {

        // Create a PriorityBlockingQueue with an initial capacity of 100
        // Note: PriorityBlockingQueue does not have a fixed capacity like ArrayBlockingQueue
        // but can be initialized with a capacity hint.
        // This initial capacity is not a strict limit, as the queue can grow dynamically unlike LinkedBlockingQueue.
        PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue<>(100);

        // Fill the queue to its capacity using 2 threads in parallel, while consuming the elements from a separate thread
        ExecutorService executor = Executors.newFixedThreadPool(3);


        // consume elements from the queue using a single thread
        executor.submit(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    System.out.println("Trying to consume");
                    System.out.println("Queue before take: " + queue);
                    Integer value = queue.take(); // Blocks if the queue is empty on Condition variable notEmpty
                    System.out.println("Consumed: " + value);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        executor.submit(() -> {
            for (int i = 50; i > 0; i--) {
                System.out.println("Trying to produce: " + i);
                queue.put(i); // Blocks if the queue is full on Condition variable notFull
                System.out.println("Produced: " + i);
            }
        });

        executor.submit(() -> {
            for (int i = 100; i > 50; i--) {
                System.out.println("Trying to produce: " + i);
                queue.put(i); // Blocks if the queue is full
                System.out.println("Produced: " + i);
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
    }    
}
