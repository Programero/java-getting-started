# ConcurrentLinkedDeque

ConcurrentLinkedDeque is a thread-safe, non-blocking, unbounded double-ended queue (deque) from the java.util.concurrent package.
Uses CAS (Compare-And-Swap) instead of locks for atomic pointer updates.

### Internal Structure
Based on a doubly-linked list of nodes.

Each node has:
```java
static final class Node<E> {
    volatile E item;
    volatile Node<E> prev;
    volatile Node<E> next;
}
```

Operations are performed using CAS (Compare-And-Swap).

head and tail pointers are used for efficient addition/removal from both ends.

### Supported Operations

| Method          | Description                                                 |
| --------------- | ----------------------------------------------------------- |
| `addFirst(e)`   | Inserts at the front                                        |
| `addLast(e)`    | Inserts at the end                                          |
| `offerFirst(e)` | Like `addFirst` but returns false on failure (non-throwing) |
| `offerLast(e)`  | Like `addLast` but non-throwing                             |

| Method          | Description                             |
| --------------- | --------------------------------------- |
| `pollFirst()`   | Retrieves and removes first element     |
| `pollLast()`    | Retrieves and removes last element      |
| `removeFirst()` | Same as `pollFirst` but throws if empty |
| `removeLast()`  | Same as `pollLast` but throws if empty  |

| Method        | Description                     |
| ------------- | ------------------------------- |
| `peekFirst()` | Views but does not remove first |
| `peekLast()`  | Views but does not remove last  |

### Core Operations:

#### addFirst(E e)
- Creates a new node with item = e
- Use CAS to atomically insert it before the current head and update head pointer

#### addLast(E  e)
- Creates a new node with item = e
- Use CAS to atomically insert it after the current tail and update tail pointer

#### pollFirst()
##### Find the first live node:

- Traverse from head forward (skip logically deleted nodes).

- Look for a node p with p.item != null.

##### Attempt logical deletion:

- Use CAS(p.item, p.item, null) to logically delete the item.

- If successful, the item is ready to be returned.

##### Unlink the node physically (lazy):

- Update pointers (head, prev, next) to remove the empty node from the list.

This step may be done partially, or delayed by future operations.
