# ConcurrentHashMap

A hash table supporting full concurrency of retrievals and high expected concurrency for updates. This class obeys the same functional specification as Hashtable, and includes versions of methods corresponding to each method of Hashtable. However, even though all operations are thread-safe, retrieval operations do not entail locking.

Retrieval operations (including get) do not block, so may overlap with update operations (including put and remove).


- ThreadSafe variant of HashMap, allows concurent Get operations, but synchronized write at per bucket level.
- Bucket-level synchronization provides higher concurrency, compared to synchronizing the entire Map.
- Unlike HashMap, ConcurrentHashMap does not allow null keys or values
- Exposes atomic methods ``putIfAbsent``, ``remove(key, value)``, ``compute``, ``computeIfAbsent``, ``merge`` for manipulating the HashMap using compound actions in thread safe manner.



| Feature               | `ConcurrentHashMap`                                          | `Collections.synchronizedMap`                             |
| --------------------- | ------------------------------------------------------------ | --------------------------------------------------------- |
| **Thread Safety**     | Fine-grained synchronization (per-bucket level)                       | Coarse-grained (entire map locked)                        |
| **Performance**       | High concurrency; better for multithreaded apps              | Poor concurrency; single-thread access at a time          |
| **Nulls**             | Does **not** allow `null` keys or values                     | Allows **one null key** and **multiple null values**      |
| **Iteration**         | **Weakly consistent**, no exceptions                         | **Fail-fast**, throws `ConcurrentModificationException` all get and write operations need to acquire lock |
| **Atomic operations** | Yes (e.g., `putIfAbsent`, `compute`, `merge`)                | No; manual synchronization needed for compound actions    |
| **Best Use Case**     | High-concurrency applications (e.g., caches, real-time data) | Low-concurrency legacy code; simple synchronization needs |

