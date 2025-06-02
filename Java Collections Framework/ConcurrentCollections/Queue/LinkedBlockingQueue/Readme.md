# LinkedBlockingQueue


***Code Ref***: https://github.com/openjdk/jdk/blob/master/src/java.base/share/classes/java/util/concurrent/LinkedBlockingQueue.java


LinkedBlockingQueue is a thread-safe, blocking, FIFO queue based on a linked-node structure.

Implements ``BlockingQueue`` interface.

| Feature           | Description                                                    |
| ----------------- | -------------------------------------------------------------- |
| Type              | Blocking Queue                             |
| Backing           | Linked Nodes                                                   |
| Thread Safety     | ✅ Yes (uses separate locks for put and take)                   |
| Null Elements     | ❌ Not allowed                                                  |
| Blocking Behavior | ✅ Waits when full/empty                                        |
| Ordering          | FIFO                                                           |
| Performance       | Scales better than `ArrayBlockingQueue` under high concurrency |
| Capacity          | Can be set or unbounded (`Integer.MAX_VALUE`)                  |

### Internal Sttructure

- Uses a counter (AtomicInteger) to track current size

- Two independent locks:

    ``putLock`` (with ``notFull`` condition)

    ``takeLock`` (with ``notEmpty`` condition)

- Two condition variables:

    ``notEmpty``: for consumers to wait when queue is empty

    ``notFull``: for producers to wait when queue is full

### Key Operations

#### ✅ `put(E e)`
- Waits if the queue is full. (wait notFull) (wait on notFull only if the LinkedBlockingQueue has specified the capacity using LinkedBlockingQueue(int capacity) else we have an unbounded queue, so no blocking)
- Acquires `putLock`.
- Adds new node at the tail.
- Increments size counter.
- Signals `notEmpty`.

#### ✅ `take()`
- Waits if the queue is empty. (wait notEmpty)
- Acquires `takeLock`.
- Removes node from head.
- Decrements size counter.
- Signals `notFull`.

#### ✅ `offer(E e)`
- Non-blocking version of `put()`.
- Returns false if queue is full, otherwise retunrs true if successful.

#### ✅ `poll()`
- Returns head element or `null` if empty.
- Non-blocking version of `take()`.

