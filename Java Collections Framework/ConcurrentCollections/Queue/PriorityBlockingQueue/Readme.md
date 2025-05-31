# PriorityBlockingQueue

PriorityBlockingQueue is a concurrent, unbounded, blocking queue that orders elements based on their priority rather than insertion order (unlike FIFO queues).

| Feature           | Description                          |
| ----------------- | ------------------------------------ |
| Type              | Unbounded, Blocking, Priority Queue  |
| Ordering          | Natural or via a custom `Comparator` |
| Thread Safety     | ✅ Yes                                |
| Null Elements     | ❌ Not allowed                        |
| Backing Structure | Binary heap (array-based)            |
| Blocking Behavior | ✅ put() is not blocking, take is blocking operation                                  |

### Internal details

- Internally uses a binary heap stored in an array. Each insertion may trigger a ``heapify-up`` operation. Each removal may trigger a ``heapify-down`` operation.

- Elements are ordered according to:

    Their natural ordering (must implement Comparable)

    Or a custom Comparator provided at construction.

- Implements blocking behavior for consumers (take()) only, but not for producers (put()) since the PriorityBlockingQueue is unbounded and there's no need of notFull.
- Single ReentrantLock is used for both put and take operations.

### Key Operations

#### ✅ `offer(E e)` / `put(E e)`
- Inserts the element based on priority.
- Non-blocking because the queue is unbounded.
- Acquires the reentrant lock

#### ✅ `take()`
- Blocks if the queue is empty.
- Removes and returns the element with highest priority (smallest according to `compareTo()`).
- Acquires the reentrant lock

#### ✅ `peek()`
- Returns the head of the queue without removing it.

### Thread Safety
- Uses a ReentrantLock internally for synchronization.

- A Condition object is used to block/wake threads on take(). (notEmpty Condition variable)


