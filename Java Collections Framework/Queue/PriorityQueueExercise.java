import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Collections;

public class MinHeapExample {
    public static void main(String[] args) {
        // PriorityQueue with default (natural) ordering — min-heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.offer(30);
        pq.offer(10);
        pq.offer(20);

        System.out.println("Head (min): " + pq.peek()); // 10

        while (!pq.isEmpty()) {
            System.out.println(pq.poll()); // 10, 20, 30
        }

        // Max Heap using a custom comparator
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        maxHeap.offer(30);
        maxHeap.offer(10);
        maxHeap.offer(20);
        System.out.println("Head (max): " + maxHeap.peek()); // 30
        while (!maxHeap.isEmpty()) {
            System.out.println(maxHeap.poll()); // 30, 20, 10
        }
    }
}
