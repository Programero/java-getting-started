Concurrent Programming Principles

## Benefits of Threads

1. Higher Throughput, although in some pathetic scenarios it is possible to have the overhead of context switching among threads steal away any throughput gains and result in worse performance than a single-threaded scenario. However such cases are unlikely.

2. Efficient utilization of resources. Note that thread creation is light-weight in comparison to spawning a brand new process. Web servers that use threads instead of creating new processes when fielding web requests, consume far fewer resources.

3. Responsive applications that give the illusion of multi-tasking: If you have a single processor machine. Whilst IO takes place, the idle CPU could work on something useful and here is where threads come in - the IO thread is switched out and the UI thread gets scheduled on the CPU so that if you click elsewhere on the screen, your IDE is still responsive and does not appear hung or frozen.

## Performance Gains with threading

As a concrete example, consider the example code below. The task is to compute the sum of all the integers from 0 to Integer.MAX_VALUE. In the first scenario, we have a single thread doing the summation while in the second scenario we split the range into two parts and have one thread sum for each range. In the end, we add the two half sums to get the combined sum. We measure the time taken for each scenario and print it.

Syntax and Code: **PerformanceGainWithMultithreading.java**

---

### About Thread object .join() method

java.lang.Thread class provides the join() method which allows one thread to wait until another thread completes its execution. If t is a Thread object whose thread is currently executing, then t.join() will make sure that t is terminated before the next instruction is executed by the program.

- **join():** It will put the current thread on wait until the thread on which it is called is dead. If thread is interrupted then it will throw InterruptedException.

---

## Problems with Threads

1. **Increased utilization of system resources**: Creation of each thread consumes additional memory, CPU cycles for book-keeping and waste of time in context switches.
2. **Programs may experience slowdown as coordination amongst threads comes at a price**. Acquiring and releasing locks adds to program execution time. Threads fighting over acquiring locks cause **lock contention**.

---

## Thread definition

Thread is the smallest unit of execution in a process. A thread simply executes instructions serially. A process can have multiple threads running as part of it. Usually, there would be some state associated with the process that is shared among all the threads and in turn each thread would have some state private to itself. The globally shared state amongst the threads of a process is visible and accessible to all the threads, and special attention needs to be paid when any thread tries to read or write to this global shared state. There are several constructs offered by various programming languages to guard and discipline the access to this global state, which we will discuss in detail.

---

### What is Multi-Processing System?

There's also the concept of "multiprocessing" systems, where multiple processes get scheduled on more than one CPU. Usually, this requires hardware support where a single system comes with multiple cores or the execution takes place in a cluster of machines. Processes don't share any resources amongst themselves whereas threads of a process can share the resources allocated to that particular process, including memory address space. However, languages do provide facilities to enable inter-process communication.

---

In **DemoThreadUnsafe.java**, we show an unsafe way of writing to a shared variable _counter_ by two Threads.

Here, we don't acquire any locks and just write to shared variable _counter_ in a thread unsafe manner.

**Why is this thread unsafe?**

The increment can be decompiled into the following steps on a computer:

1. Read the value of the variable counter from the register where it is stored
2. Add one to the value just read
3. Store the newly computed value back to the register

Now imagine if we have two threads trying to execute the same function incrementCounter then one of the ways the execution of the two threads can take place is as follows:

- Lets call one thread as T1 and the other as T2. Say the counter value is equal to 7.

- T1 is currently scheduled on the CPU and enters the function. It performs step A i.e. reads the value of the variable from the register, which is 7.

- The operating system decides to context switch T1 and bring in T2.

- T2 gets scheduled and luckily gets to complete all the three steps A, B and C before getting switched out for T1. It reads the value 7, adds one to it and stores 8 back.

- T1 comes back and since its state was saved by the operating system, it still has the stale value of 7 that it read before being context switched. It doesn't know that behind its back the value of the variable has been updated. It unfortunately thinks the value is still 7, adds one to it and overwrites the existing 8 with its own computed 8. If the threads executed serially the final value would have been 9.

Threfore, Without properly guarding access to mutable(shared) variables or data-structures, threads can cause hard to find to bugs.

Since the execution of the threads can't be predicted and is entirely up to the operating system, we can't make any assumptions about the order in which threads get scheduled and executed.

---

## Concurrency v/s Parallelism

### Concurrency

A concurrent program is one that can be decomposed into constituent parts and each part can be executed out of order or in partial order without affecting the final outcome.

A system capable of running several distinct programs or more than one independent unit of the same program in overlapping time intervals is called a concurrent system. **The execution of two programs or units of the same program may not happen simultaneously.**

A concurrent system can have two programs in progress at the same time where progress doesn't imply execution. One program can be suspended while the other executes. Both programs are able to make progress as their execution is interleaved.

For example:

- A browser running on a single core machine has to be responsive to user clicks but also be able to render HTML on screen as quickly as possible.

- The classic example of a concurrent system is that of an operating system running on a single core machine. Such an operating system is concurrent but not parallel. It can only process one task at any given point in time but all the tasks being managed by the operating system appear to make progress because the operating system is designed for concurrency. Each task gets a slice of the CPU time to execute and move forward.

### Parallelism

A parallel system is one which necessarily has the ability to execute multiple programs at the same time. Usually, this capability is aided by extra hardware in the form of multicore processors on individual machines or as computing clusters where several machines are hooked up to solve independent pieces of a problem simultaneously. Remember an individual problem has to be concurrent in nature(that is portions of it can be worked on independently without affecting the final outcome) before it can be executed in parallel.

### Concurrency vs Parallelism

From the above discussion it should be apparent that a concurrent system need not be parallel, whereas a parallel system is indeed concurrent. Additionally, a system can be both concurrent and parallel e.g. a multitasking operating system running on a multicore machine.

## Asynchronous Programming

Async execution can invoke a method and move onto the next line of code without waiting for the invoked function to complete or receive its result. Usually, such methods return an entity sometimes called a future or promise that is a representation of an in-progress computation. The program can query for the status of the computation via the returned future or promise and retrieve the result once completed. Another pattern is to pass a callback function to the asynchronous function call which is invoked with the results when the asynchronous function is done processing.

Asynchronous programming support in Java has become a lot more robust starting with Java 8, however, the topic is out of scope for this course so we only mention it in passing.

Different programming languages come with varying support for multithreading. For instance, Javascript is single-threaded, Java provides full-blown multithreading and Python is sort of multithreaded as it can only have a single thread in running state because of its global interpreter lock (GIL) limitation. However, all three languages support asynchronous programming models which is another way for programs to be concurrent (but not parallel).

---

## Critical Sections & Race Conditions

**This section exhibits how incorrect synchronization in a critical section can lead to race conditions and buggy code.**

### Critical Section

Critical section is any piece of code that has the possibility of being executed concurrently by more than one thread of the application and exposes any shared data or resources used by the application for access.

### Race Condition

Race conditions happen when threads run through critical sections without thread synchronization.

The threads "race" through the critical section to write or read shared resources and depending on the order in which threads finish the "race", the program output changes.

In a race condition, threads access shared resources or program variables that might be worked on by other threads at the same time causing the application data to be inconsistent.
