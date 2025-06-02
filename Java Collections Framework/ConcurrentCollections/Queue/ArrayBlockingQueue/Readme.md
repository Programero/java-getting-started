### ArrayBlockingQueue

ArrayBlockingQueue is a bounded, blocking, FIFO queue backed by an array. 

Implements BlockingQueue interface which provides extra methods put and take, which are blocking versions of offer and put, waits on Condition variables notEmpty or notFull incase of take() and put(E e) respectively.

### Summary of BlockingQueue methods

|               | Throws exception | Special value | Blocks     | Times out                 |
|---------------|------------------|----------------|------------|---------------------------|
| **Insert**    | `add(e)`         | `offer(e)`     | `put(e)`   | `offer(e, time, unit)`    |
| **Remove**    | `remove()`       | `poll()`       | `take()`   | `poll(time, unit)`        |
| **Examine**   | `element()`      | `peek()`       | *not applicable* | *not applicable*  |


Similarly LinkedBlockingQueue, PriorityBlockingQueue implements BlockingQueue interface.

Similarly LinkedBlockingDeque implements BlockingDeque interface.

| Feature         | Description                       |
| --------------- | --------------------------------- |
| Type            | Bounded, Blocking Queue           |
| Package         | `java.util.concurrent`            |
| Backing         | Circular array                    |
| Ordering        | FIFO (First-In-First-Out)         |
| Thread Safety   | ✅ Yes (uses **explicit locks**)   |
| Nulls Allowed   | ❌ No                              |
| Blocking?       | ✅ Yes                             |
| Fairness Option | ✅ Optional (FIFO thread ordering) |

Uses a single ReentrantLock for both put and take. 

And Two condition variables:

``notEmpty``: for consumers to wait when queue is empty

``notFull``: for producers to wait when queue is full

### Queue Operations

**put(E e)**

1. Waits if the queue is full. (wait notFull)
2. Acquires lock.
3. Adds element at putIndex, increments putIndex (circular).
4. Signals notEmpty.

**take()**

1. Waits if the queue is empty. (wait notEmpty)
2. Acquires lock.
3. Removes element at takeIndex, increments takeIndex (circular).
4. Signals notFull.

**offer(E e)**
1. Tries to insert element.
2. Returns false if full (non-blocking version of put()).

**poll()**
1. Removes and returns head.
2. Returns null if empty (non-blocking version of take()).  


| Queue                   | Bounded? | Blocking? | Thread-safe? | Lock-free? | Backed by   |
| ----------------------- | -------- | --------- | ------------ | ---------- | ----------- |
| `ArrayBlockingQueue`    | ✅ Yes    | ✅ Yes     | ✅ Yes        | ❌ No       | Array       |
| `LinkedBlockingQueue`   | ❌ No     | ✅ Yes     | ✅ Yes        | ❌ No       | Linked List |
| `ConcurrentLinkedQueue` | ❌ No     | ❌ No      | ✅ Yes        | ✅ Yes      | Linked List |
| `PriorityBlockingQueue` | ❌ No     | ✅ Yes     | ✅ Yes        | ❌ No       | Heap        |

### Limitations

- Bounded size — you must define capacity upfront.
- Uses locks, so not as scalable as lock-free queues under high contention.
- Cannot resize dynamically like LinkedBlockingQueue.
