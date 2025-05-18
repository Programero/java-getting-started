# PriorityQueue

```PriorityQueue``` in Java is not a FIFO queue, but a special type of queue that orders its elements according to their natural ordering(using elements compareTo implementation) or by a custom comparator provided at construction time.

| Feature                  | Description                                          |
| ------------------------ | ---------------------------------------------------- |
| **Implements**           | `Queue<E>` interface                                 |
| **Ordering**             | **Priority-based**, *not* FIFO                       |
| **Underlying Structure** | Internally it impelements Binary **min-heap** by maintaining an array of elements and implementing siftUp and siftDown private operations                                  |
| **Thread-safe**          | ❌ No (use `PriorityBlockingQueue` for thread safety) |
| **Null Elements**        | ❌ Not allowed                                        |
| **Duplicates**           | ✅ Allowed                                            |

[Openjdk Github code ref](https://github.com/openjdk/jdk/blob/c59debb3844d009ac501a48c31822a07f00521e9/src/java.base/share/classes/java/util/PriorityQueue.java#L87)

### Key methods in PriorityQueue

| Operation           | Method                    | Description                                                | Time Complexity |
| ------------------- | ------------------------- | ---------------------------------------------------------- | --------------- |
| **Insert**          | `offer(E e)` / `add(E e)` | Adds element into queue                                    | **O(log n)**    |
| **Remove head**     | `poll()` / `remove()`     | Removes the element with highest priority (i.e., the head) | **O(log n)**    |
| **Access head**     | `peek()` / `element()`    | Retrieves the head element without removing it             | **O(1)**        |
| **Remove specific** | `remove(Object o)`        | Removes a specific element                                 | **O(n)**        |
| **Search**          | `contains(Object o)`      | Checks if an element exists                                | **O(n)**        |
| **Size**            | `size()`                  | Returns number of elements                                 | **O(1)**        |
| **Check empty**     | `isEmpty()`               | Checks if the queue is empty                               | **O(1)**        |
| **Clear**           | `clear()`                 | Removes all elements                                       | **O(n)**        |

