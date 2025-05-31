# CopyOnWriteArraySet

## Introduction

A Set that uses an internal CopyOnWriteArrayList for all of its operations.  Thus, it shares the same basic properties:
 - It is best suited for applications in which set sizes generally stay small, read-only operations vastly outnumber mutative operations, and you need to prevent interference among threads during traversal.
- It is thread-safe.
- Mutative operations (<tt>add</tt>, <tt>set</tt>, <tt>remove</tt>, etc.) are expensive since they usually entail copying the entire underlying array.
- Iterators do not support the mutative <tt>remove</tt> operation.
- Traversal via iterators is fast and cannot encounter interference from other threads. Iterators rely on unchanging snapshots of the array at the time the iterators were constructed.

**Note:** To better comprehend CopyOnWriteArraySet, first read about CopyOnWriteArrayList

Code ref: [OpenJDK Github repo](https://github.com/openjdk/jdk/blob/master/src/java.base/share/classes/java/util/concurrent/CopyOnWriteArraySet.java)
