# ConcurrentLinkedQueue

ConcurrentLinkedQueue is a thread-safe, non-blocking, FIFO (First-In-First-Out) queue based on linked nodes.

| Feature           | Description                                          |
| ----------------- | ---------------------------------------------------- |
| Type              | Unbounded, non-blocking FIFO queue                   |
| Backing Structure | Linked nodes (singly linked list)                    |
| Concurrency       | Lock-free, based on **CAS (Compare-And-Swap)**       |
| Thread safety     | ✅ Fully thread-safe                                  |
| Blocking behavior | ❌ Non-blocking |
| Null elements     | ❌ Not allowed                                        |
| Iteration         | Weakly consistent                                    |

### Thread Safety

Operations use atomic CAS loops — no locks used.
Good Read: https://www.cs.rochester.edu/~scott/papers/1996_PODC_queues.pdf


Safe for multiple threads to offer and poll concurrently.

### Iteration

Iterators are weakly consistent:

Does not throw ConcurrentModificationException.

May or may not reflect updates after iterator creation.

Safe to use during concurrent modifications.

| Queue                   | Bounded? | Blocking? | Thread-safe? | Ordered?              | Lock-free?        |
| ----------------------- | -------- | --------- | ------------ | --------------------- | ----------------- |
| `ConcurrentLinkedQueue` | ❌ No     | ❌ No      | ✅ Yes        | ✅ FIFO                | ✅ Yes             |
| `LinkedBlockingQueue`   | ❌ No     | ✅ Yes     | ✅ Yes        | ✅ FIFO                | ❌ No (uses locks) |
| `ArrayBlockingQueue`    | ✅ Yes    | ✅ Yes     | ✅ Yes        | ✅ FIFO                | ❌ No (uses locks) |
| `PriorityBlockingQueue` | ❌ No     | ✅ Yes     | ✅ Yes        | ❌ No (priority-based) | ❌ No              |

### Main Operations:

1. **offer(E e)**

    Start at the current tail node.
    Traverse forward until you find the actual end (next == null).

    ```java
    if (tail.next == null) {
        if (CAS(tail.next, null, newNode)) { // update the lastNode next pointer to point to newNode
            // successfully linked
            break;
        }
    }

    //Update the tail pointer
    CAS(tail, currentTail, newNode); // make the tail pointer point to newNode
    ```
2. **poll()**
    ```java
    Node h = head;
    //1. Start traversing from h and Find out the first node with .item as not null
    
    //Get item from HEAD
    E item = first.item;

    //Set tne item to null and move head
    if (item != null && CAS(first.item, item, null)) {
        // successfully removed
        CAS(head, h, first); // move head forward
        return item;
    }
    ```
