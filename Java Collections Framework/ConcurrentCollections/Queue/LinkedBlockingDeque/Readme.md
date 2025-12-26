# LinkedBlockingDeque

***Code Ref***: https://github.com/openjdk/jdk/blob/master/src/java.base/share/classes/java/util/concurrent/LinkedBlockingDeque.java

``LinkedBlockingDeque`` is a thread-safe, optionally bounded, double-ended queue (deque).

Implements ``BlockingDeque`` interface.

### Insertion methods

| Method                                           | Behavior                 |
| ------------------------------------------------ | ------------------------ |
| `addFirst(e)`                                    | Throws exception if full |
| `offerFirst(e)`                                  | Returns false if full    |
| `putFirst(e)`                                    | Blocks on notFull Condition variable if the queue is full           |
| *(same applies to `addLast`, `offerLast`, `putLast` etc.)* |                          |

### Removal Methods

| Method                                             | Behavior                  |
| -------------------------------------------------- | ------------------------- |
| `removeFirst()`                                    | Throws exception if empty |
| `pollFirst()`                                      | Returns `null` if empty   |
| `takeFirst()`                                      | Blocks on notEmpty if the queue is empty |
| *(same applies to `removeLast`, `pollLast`, `takeLast` etc.)* |                           |

### Peek methods

| Method                                        | Behavior                |
| --------------------------------------------- | ----------------------- |
| `getFirst()`                                  | Exception if empty      |
| `peekFirst()`                                 | Returns `null` if empty |
| *(also available: `getLast()`, `peekLast()`)* |                         |


