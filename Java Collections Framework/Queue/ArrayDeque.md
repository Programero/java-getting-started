# ArrayDeque

ArrayDeque is a resizable-array implementation of the Deque interface. It can be used as both a 
stack and a queue, offering faster performance than Stack and LinkedList in most cases.

### Queue-like Operations (FIFO)

| Method       | Description                                                           | Time Complexity |
| ------------ | --------------------------------------------------------------------- | --------------- |
| `offer(E e)` | Inserts at the **tail**                                               | O(1)            |
| `poll()`     | Retrieves and removes the **head**                                    | O(1)            |
| `peek()`     | Retrieves the **head** without removing                               | O(1)            |
| `add(E e)`   | Adds at the **tail**, throws if capacity full (never in `ArrayDeque`) | O(1)            |

### Double-Ended Queue (Deque) Operations

| Method            | Description                                   | Time Complexity |
| ----------------- | --------------------------------------------- | --------------- |
| `addFirst(E e)`   | Adds at the front                             | O(1)            |
| `addLast(E e)`    | Adds at the back                              | O(1)            |
| `removeFirst()`   | Removes and returns first element             | O(1)            |
| `removeLast()`    | Removes and returns last element              | O(1)            |
| `offerFirst(E e)` | Offers to the front (no exception on failure) | O(1)            |
| `offerLast(E e)`  | Offers to the back                            | O(1)            |
| `pollFirst()`     | Retrieves and removes first element           | O(1)            |
| `pollLast()`      | Retrieves and removes last element            | O(1)            |
| `peekFirst()`     | Peeks at the first element                    | O(1)            |
| `peekLast()`      | Peeks at the last element                     | O(1)            |

### Stack like Operations (part of Deque Interface)

| Method      | Description                         | Time Complexity |
| ----------- | ----------------------------------- | --------------- |
| `push(E e)` | Adds to the front (like stack push) | O(1)            |
| `pop()`     | Removes from front (like stack pop) | O(1)            |
| `peek()`    | Peeks at the front                  | O(1)            |


- No null elements – throws NullPointerException.

- Not thread-safe – use ConcurrentLinkedDeque or LinkedBlockingDeque if needed.
