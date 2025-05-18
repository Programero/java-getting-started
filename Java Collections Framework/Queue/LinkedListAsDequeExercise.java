import java.util.LinkedList;

public class LinkedListAsDequeExercise {
    public static void main(String[] args) {
        // Create a LinkedList
        LinkedList<String> list = new LinkedList<>();

        System.out.println("LinkedList as queue (FIFO)");
        // Add elements to the deque
        list.add("First");
        list.add("Second");
        list.add("Third");

        // Print the deque
        System.out.println("LinkedList: " + list);

        while (!list.isEmpty()) {
            System.out.println("Removed: " + list.poll());
        }

        // LinkedList as stack (LIFO)
        System.out.println("LinkedList as stack (LIFO)");

        list.push("First");
        list.push("Second");
        list.push("Third");

        while (!list.isEmpty()) {
            System.out.println("Removed: " + list.pop());
        }

        // LinkedList as a double-ended queue
        System.out.println("LinkedList as double-ended queue");
        list.addFirst("First");
        list.addLast("Second");
        list.addFirst("Third");
        list.addLast("Fourth");
        System.out.println("LinkedList: " + list);

        while (!list.isEmpty()) {
            System.out.println("Removed: " + list.pollFirst());
            System.out.println("Removed: " + list.pollLast());
        }
    }
}