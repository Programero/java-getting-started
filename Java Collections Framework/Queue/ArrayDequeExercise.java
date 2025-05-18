import java.util.ArrayDeque;

public class ArrayDequeExercise {
    public static void main(String[] args) {
        // Create an ArrayDeque
        ArrayDeque<String> deque = new ArrayDeque<>();
        
        System.out.println("ArrayDeque as queue (FIFO)");
        // Add elements to the deque
        deque.add("First");
        deque.add("Second");
        deque.add("Third");

        // Print the deque
        System.out.println("ArrayDeque: " + deque);

        while(!deque.isEmpty()) {
            System.out.println("Removed: " + deque.poll());
        }

        // ArrayDeque as stack (LIFO)
        System.out.println("ArrayDeque as stack (LIFO)");

        deque.push("First");
        deque.push("Second");
        deque.push("Third");
        
        while(!deque.isEmpty()) {
            System.out.println("Removed: " + deque.pop());
        }

        // ArrayDeque as a double-ended queue
        System.out.println("ArrayDeque as double-ended queue");
        deque.addFirst("First");
        deque.addLast("Second");
        deque.addFirst("Third");
        deque.addLast("Fourth");
        System.out.println("ArrayDeque: " + deque);

        while(!deque.isEmpty()) {
            System.out.println("Removed: " + deque.pollFirst());
            System.out.println("Removed: " + deque.pollLast());
        }
    }
}