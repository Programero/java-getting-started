## Queue Interface

Queue represents a First-In-First-Out (FIFO) collection, although some implementations may follow other orders (like PriorityQueue). 

Priority Queue represents min heap implementation.

### Common implementations of Queue

| Class                   | Ordering       | Thread Safe | Notes                                            |
| ----------------------- | -------------- | ----------- | ------------------------------------------------ |
| `LinkedList`            | FIFO           | ❌ No        | Implements `Queue` and `Deque`                   |
| `PriorityQueue`         | Priority-based | ❌ No        | Orders elements by natural order or a comparator |
| `ArrayDeque`            | FIFO / LIFO    | ❌ No        | Implements `Deque`, efficient for both ends      |

### Core Queue opertaions

| Method       | Description                        | Throws Exception   | Returns Special Value |
| ------------ | ---------------------------------- | ------------------ | --------------------- |
| `add(E e)`   | Inserts element into the queue     | ✅ If full or fails | ❌                     |
| `offer(E e)` | Attempts to insert element         | ❌                  | ✅ `false` if it fails |
| `remove()`   | Removes and returns head element   | ✅ If empty         | ❌                     |
| `poll()`     | Retrieves and removes head element | ❌                  | ✅ `null` if empty     |
| `element()`  | Retrieves but does not remove head | ✅ If empty         | ❌                     |
| `peek()`     | Retrieves but does not remove head | ❌                  | ✅ `null` if empty     |


    ✅ Best Practice: Use offer(), poll(), and peek() for non-exceptional handling.

### Comparison between ArrayDeque, LinkedList and PriorityQueue

| Feature           | `LinkedList`                      | `PriorityQueue`                               | `ArrayDeque`                             |
| ----------------- | --------------------------------- | --------------------------------------------- | ---------------------------------------- |
| **Implements**    | `List`, `Deque`, `Queue`          | `Queue`                                       | `Deque`, `Queue`                         |
| **Ordering**      | Insertion (FIFO / LIFO for Deque) | Priority-based (natural or custom comparator) | Insertion (FIFO / LIFO)                  |
| **Null elements** | ✅ Allowed                         | ❌ Not allowed                                 | ❌ Not allowed                            |
| **Performance**   | Slower than `ArrayDeque`          | Depends on comparator; heap-backed            | Faster than `LinkedList` for stack/queue |
| **Underlying Data Structure**    | Doubly-linked list              | Binary heap (min-heap)             | Resizable circular array    |
| **Access Order**                 | Maintains insertion order       | Based on priority (natural/custom) | Maintains insertion order   |
| **Insertion/Removal Complexity** | O(1) at ends, O(n) in middle    | O(log n) (heap insert/delete)      | O(1) amortized for ends     |
| **Element Access by Index**      | ✅ Yes (but O(n))                | ❌ No                               | ❌ No                        |
| **Use as Stack (LIFO)**          | ✅ Yes (`push()`, `pop()`)       | ❌ No                               | ✅ Yes (`push()`, `pop()`)   |
| **Use as Queue (FIFO)**          | ✅ Yes (`offer()`, `poll()`)     | ✅ Yes (`offer()`, `poll()`)        | ✅ Yes (`offer()`, `poll()`) |
| **Use as Deque (Double-ended)**  | ✅ Yes (`Deque` API)             | ❌ No                               | ✅ Yes (`Deque` API)         |

## Deque Interface

An extension of the Queue interface. It allows insertion and removal of elements at both ends — front (head) and rear (tail).

Common implementation: **LinkedList** **ArrayDeque**

### Key methods in Deque

| Operation            | Method            | Description                       | Throws Exception? | Returns Special Value |
| -------------------- | ----------------- | --------------------------------- | ----------------- | --------------------- |
| **Insert at Head**   | `addFirst(E e)`   | Adds to the front                 | ✅ Yes             | —                     |
|                      | `offerFirst(E e)` | Adds to the front                 | ❌ No              | ✅ `false` if fails    |
| **Insert at Tail**   | `addLast(E e)`    | Adds to the end                   | ✅ Yes             | —                     |
|                      | `offerLast(E e)`  | Adds to the end                   | ❌ No              | ✅ `false` if fails    |
| **Remove from Head** | `removeFirst()`   | Removes and returns first element | ✅ Yes             | —                     |
|                      | `pollFirst()`     | Removes and returns first element | ❌ No              | ✅ `null` if empty     |
| **Remove from Tail** | `removeLast()`    | Removes and returns last element  | ✅ Yes             | —                     |
|                      | `pollLast()`      | Removes and returns last element  | ❌ No              | ✅ `null` if empty     |
| **Peek Head**        | `getFirst()`      | Gets the first element            | ✅ Yes             | —                     |
|                      | `peekFirst()`     | Peeks the first element           | ❌ No              | ✅ `null` if empty     |
| **Peek Tail**        | `getLast()`       | Gets the last element             | ✅ Yes             | —                     |
|                      | `peekLast()`      | Peeks the last element            | ❌ No              | ✅ `null` if empty     |


To use ArrayDeque or LinkedList as stack(LIFO), we can use the following methods:

| Method (part of Deque)     | Equivalent To   | Description             |
| ----------- | --------------- | ----------------------- |
| `push(E e)` | `addFirst(E e)` | Pushes onto front       |
| `pop()`     | `removeFirst()` | Pops from front         |
| `peek()`    | `peekFirst()`   | Peeks front (stack top) |

