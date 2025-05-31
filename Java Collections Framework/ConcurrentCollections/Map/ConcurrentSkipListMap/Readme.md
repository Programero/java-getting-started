# ConcurrentSkipListMap

ConcurrentSkipListMap is a concurrent, sorted, navigable map in Java.
The map is sorted according to the { Comparable natural ordering} of its keys, or by a Comparator provided at map creation time, depending on which constructor is used.

Internally uses Skip List.

Iteration is Weakly consistent, just like ConcurrentHashMap.

Uses lock-free algorithms with compareAndSwap operations. Insertion, removal, update, and access operations safely execute concurrently by multiple threads.

Reads are never blocked, and writes are minimally blocked.

## What is a Skip List?

A skip list is a probabilistic data structure composed of multiple layers of linked lists. Each level acts as an “express lane” to speed up searching.

Base level: regular linked list (Level 0).

Higher levels: nodes that “skip” multiple elements.

Insertions randomly assign a level to the node, balancing the structure probabilistically.

### Thread Safety and Concurrency Model
The implementation is lock-free and non-blocking.

compareAndSet used to update next pointers.

CAS retry loops ensure safety without blocking other threads.

Good Read: https://docs.rs/crate/crossbeam/0.2.4/source/hash-and-skip.pdf

Code Ref: https://github.com/openjdk/jdk/blob/master/src/java.base/share/classes/java/util/concurrent/ConcurrentSkipListMap.java


