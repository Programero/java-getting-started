Open JDK code for reference: https://github.com/openjdk/jdk/blob/master/src/java.base/share/classes/java/util/concurrent/AbstractExecutorService.java

## Executors Service

Read about ExecutorsService interface which manages threads pool and managing the execution of the asynchronous tasks submiited to ExecutorsService:

- https://www.baeldung.com/java-executor-service-tutorial
- Java docs: https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ExecutorService.html

Implementation classes of ExecutorService ``ForkJoinPool``, ``ThreadPoolExecutor`` both these classes extends AbstractExecutorService which implements ExecutorService.

Whenever we use factory methods under ``Executors`` class: 
- ``Executors.newFixedThreadPool`` leads to creation of ThreadPoolExecutor class instance.
- ``Executors.newSingleThreadScheduledExecutor`` leads to creation of ScheduledThreadPoolExecutor instance. ScheduledThreadPoolExecutor extends ThreadPoolExecutor class.



We can assign tasks to the ExecutorService using several methods: 
- ``execute(Runnable task)``
- ``submit(Callable<T> task)``
- ``invokeAny(callableTasks)`` i.e ``invokeAny(Collection<? extends Callable<T>> tasks)``
- ``invokeAll(callableTasks)`` i.e ``invokeAll(Collection<? extends Callable<T>> tasks)``

The ``execute()`` method returns void and doesn’t give any possibility to get the result of an asynchronous task’s execution or to check the task’s status (if it's running).

The ``submit()`` submits a Callable or a Runnable task to an ExecutorService and returns a result of type Future.

Incase of Runnable Tasks submitted using ``.submit()``, if we do ``Future.get()``, we get ``null`` in return, since Runnable tasks retrun type is void.

#### ``<T> T	invokeAny(Collection<? extends Callable<T>> tasks)``

``invokeAny()`` assigns a collection of tasks to an ExecutorService, causing each to run parallely, and returns the result of the first successful execution of one task (if there was a successful execution).

#### ``<T> List<Future<T>>	invokeAll(Collection<? extends Callable<T>> tasks)``

Executes the given tasks, returning a list of Futures holding their status and results when all complete.

## Future interface

Read about Future interface from here: https://www.baeldung.com/java-future
Java doc: https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/Future.html

Future represents a future result of an asynchronous computation.

Known implementations of Future interface:

CompletableFuture, CountedCompleter, ForkJoinTask, FutureTask, RecursiveAction, RecursiveTask, SwingWorker

Whenever we do ExecutorService.submit(Runnable/Callable task), then an instance of ``FutureTask`` is returned.

#### ``V get()``

Waits if necessary for the computation to complete, and then retrieves its result.

#### ``boolean isDone()``
Returns true if this task completed. Completion may be due to normal termination, an exception, or cancellation -- in all of these cases, this method will return true.

#### ``boolean	cancel(boolean mayInterruptIfRunning)``

If the task has already started, then the mayInterruptIfRunning parameter determines whether the thread executing this task should be interrupted in an attempt to stop the task.
After this method returns, subsequent calls to isDone() will always return true. Subsequent calls to isCancelled() will always return true if this method returned true.

#### ``boolean isCancelled()``

Returns true if this task was cancelled before it completed normally.

## CompletableFuture Class

CompletableFuture class implements Future interface and CompletionStage interface.

To run an asynchronousTask which returns CompletableFuture class, we have the following methods in CompletableFuture class:

- ``public static <U> CompletableFuture<U> supplyAsync(Supplier<U> supplier)``: It executes the task in one of the threads in the ForkJoinPool.commonPool() and returns CompletableFuture which completes with the value obtained by calling the given Supplier.
- ``public static <U> CompletableFuture<U> supplyAsync(Supplier<U> supplier, Executor executor)``: It executes the task in one of the threads in the Executor passed as argument and returns CompletableFuture with the value obtained by calling the given Supplier.
- ``public static CompletableFuture<Void> runAsync(Runnable runnable):`` Returns a new CompletableFuture that is asynchronously completed by the task running in the ForkJoinPool.commonPool(), after it completes the execution.
- ``public static CompletableFuture<Void> runAsync(Runnable runnable, Executor executor):`` Returns a new CompletableFuture that is asynchronously completed by the task running in the given executor after it completes the execution.

CompletableFuture also implements CompletionStage interface, which has methods allowing asynchronous tasks to be executed in an orderly manner.

CompletionStage interface represents a CompletionStage that is a point-in-time indicating which particular asynchronousTask has completed.
It allows fluent chaining of async logic.

### Util Methods of CompletionStage interface implemented in CompletableFuture class which allows chaining of async logic:

- ``CompletableFuture<Void>	acceptEither(CompletionStage<? extends T> other, Consumer<? super T> action)`` 

    The method acceptEither() in Java's CompletableFuture (part of the CompletionStage interface) is used to run a consumer when either of two futures completes first, with the result of the one that completed first.
    ```java
    CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
        sleep(100); // Simulate delay
        return "From future1";
    });

    CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
        sleep(50); // Simulate shorter delay
        return "From future2";
    });

    future1.acceptEither(future2, result -> {
        System.out.println("Result: " + result);
    });

    //Result: From future2
    //OR
    //Result: From future1
    ```

    | Method           | What It Does                                |
    | ---------------- | ------------------------------------------- |
    | `acceptEither`   | Runs a `Consumer` when **either** completes |
    | `applyToEither`  | Runs a `Function` to transform the result of either   |
    | `runAfterEither` | Runs a `Runnable` after either completes    |


- ``<T> CompletionStage<T> handle(BiFunction<? super T, Throwable, ? extends T> handler)``
    
    Process the result of the computation if it completes normally, OR

    Handle the exception if one was thrown.

    ***✅ It's like combining thenApply() and exceptionally() into one unified step.***

    ```java
    CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
        if (true) throw new RuntimeException("Oops!");
        return "Success!";
    });

    future.handle((result, ex) -> {
        if (ex != null) {
            return "Recovered from error: " + ex.getMessage();
        } else {
            return "Result: " + result;
        }
    }).thenAccept(System.out::println);

    //Output: 
    //Recovered from error: Oops!
    ```
- ``CompletableFuture<Void>	runAfterBoth(CompletionStage<?> other, Runnable action)``
    
    ``runAfterBoth()`` is used to execute a task after two CompletableFutures complete, regardless of their result values.

    ```java
    CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
        sleep(100);
        System.out.println("Task 1 done");
    });

    CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
        sleep(150);
        System.out.println("Task 2 done");
    });

    future1.runAfterBoth(future2, () -> {
        System.out.println("Both tasks completed. Final action executed.");
    });

    //Output
    //Task 1 done
    //Task 2 done
    //Both tasks completed. Final action executed.
    ```

    Related methods:

    | Method             | Description                                |
    | ------------------ | ------------------------------------------ |
    | `runAfterBoth()`   | Run after both complete (no result access) |
    | `thenCombine()`    | Combine results of both                    |
    | `thenAcceptBoth()` | Consume both results (with a `BiConsumer`) |
    | `runAfterEither()` | Run after **either** one completes         |

- ``<U,V> CompletableFuture<V>	thenCombine(CompletionStage<? extends U> other, BiFunction<? super T,? super U,? extends V> fn)``
    
    ``thenCombine()`` waits for the two independent tasks to complete and a Bifunction is executed on the same thread (whichever finishes last) with the result of two independent tasks. thenCombine returns a CompletableFuture which completes when the BiFunction returns the value.

    Both the tasks can run in parallel, unlike thenCompose() which chains them.

    ```java
    CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");
    CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "World");

    CompletableFuture<String> combined = future1.thenCombine(future2, (s1, s2) -> s1 + " " + s2);

    combined.thenAccept(System.out::println);
    ```

    | Method             | Purpose                                | Depends on previous result? |
    | ------------------ | -------------------------------------- | --------------------------- |
    | `thenCombine()`    | Combine results of two futures         | ❌ No                       |
    | `thenCompose()`    | Chain dependent futures                | ✅ Yes                      |


- ``<T, U> CompletionStage<U> thenCompose(Function<? super T, ? extends CompletionStage<U>> fn)``

    thenCompose() is used to chain two dependent asynchronous operations — where the second operation depends on the result of the first.

    1. Takes a function that returns a new CompletableFuture based on the result of the previous stage.

    2. It flattens the nested futures (i.e., avoids ``CompletableFuture<CompletableFuture<T>>`` instead returns ``CompletableFuture<T>`` by flattening ``CompletableFuture<CompletableFuture<T>>``)

    ```java
    CompletableFuture<String> getUserId() {
        return CompletableFuture.supplyAsync(() -> "user123");
    }

    CompletableFuture<String> getUserProfile(String userId) {
        return CompletableFuture.supplyAsync(() -> "Profile of " + userId);
    }

    // Chain the two async calls
    getUserId()
        .thenCompose(getUserProfile)
        .thenAccept(System.out::println);
    ```

    **🧠 Why Not Use thenApply()?**

    Using thenApply() here would return a nested future:
    ```java
    CompletableFuture<CompletableFuture<String>> nested = getUserId().thenApply(this::getUserProfile);
    ```
    To avoid this, use thenCompose() which flattens the result into a single ``CompletableFuture<String>``.

    | Use Case                                             | Use               |
    | ---------------------------------------------------- | ----------------- |
    | Async API call A → then API call B (with A's result) | ✅ `thenCompose()` |
    | Fetch user → then fetch orders for that user         | ✅ `thenCompose()` |
    | Sequential async operations with dependencies        | ✅ `thenCompose()` |

-   ``public <U> CompletableFuture<U> thenApply(Function<? super T,? extends U> fn)``
    Executes the function fn, with the result of the CompletableFuture on which it is called completes and returns the ``CompletableFuture<U>`` which completes once the function fn resolves.

    | Feature          | `thenApply()`                                           | `thenCompose()`                         |
    | ---------------- | ------------------------------------------------------- | --------------------------------------- |
    | Purpose          | Transforms a result                                     | Chains dependent async calls            |
    | Input Function   | `T → U` (regular value)                                 | `T → CompletableFuture<U>` (async call) |
    | Output           | `CompletableFuture<U>`                                  | `CompletableFuture<U>`                  |
    | Nesting Behavior | Creates **nested futures** if used with async functions | Flattens nested futures                 |

- ``static CompletableFuture<Void>	allOf(CompletableFuture<?>... cfs)``

    CompletableFuture.allOf() is used to wait for multiple CompletableFutures to complete. It returns a single CompletableFuture<Void> that completes when all of the given futures complete, regardless of their results.

    Does not return their results directly — you have to retrieve them manually.

    ```java
    CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Task 1");
    CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "Task 2");
    CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> "Task 3");

    CompletableFuture<Void> all = CompletableFuture.allOf(future1, future2, future3);

    all.thenRun(() -> {
        // All tasks completed
        try {
            System.out.println(future1.get());  // "Task 1"
            System.out.println(future2.get());  // "Task 2"
            System.out.println(future3.get());  // "Task 3"
        } catch (Exception e) {
            e.printStackTrace();
        }
    });
    ```
- ``static CompletableFuture<Object> anyOf(CompletableFuture<?>... cfs)``

    - Takes an array of CompletableFutures.

    - Returns a CompletableFuture<Object> that:

        - Completes as soon as one of them completes

        - Carries the result of the first-completed future

        - If the first to complete throws an exception, anyOf completes exceptionally

- ``CompletableFuture<Void>	thenAcceptAsync(Consumer<? super T> action)``

    OR

    ``CompletableFuture<Void> thenAcceptAsync(Consumer<? super T> action, Executor executor)``

    In ``.thenAccept``, The Consumer runs in the same thread that completed the future.

    In ``.thenAcceptAsync()``, The Consumer runs asynchronously in a separate thread, typically in the ForkJoinPool.commonPool or a custom executor if provided.

    - Use thenAccept() when:

        - You’re fine running continuation in the same thread.

        - You want low overhead and don't need async offloading.

    - Use thenAcceptAsync() when:

        - You want to offload result processing.

        - You’re doing I/O, heavy computation, or UI updates (in frameworks that require specific threads).

        - You want explicit control over threading (via executor).
