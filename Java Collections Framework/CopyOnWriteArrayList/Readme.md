# CopyOnWriteArrayList

## Introduction

The ArrayList and LinkedList data structures are not thread-safe. This means that if we are working in an environment where multiple threads are simultaneously adding or removing elements from a list, it may not work as intended. If a thread is iterating over a list and, in the meantime, another thread tries to add an element to the list, then ConcurrentModificationException will be thrown.

To overcome these issues CopyOnWriteArrayList was introduced. This is a thread-safe list with high performance.

CopyOnWriteArrayList is a part of **Concurrent Collections** available in java.util.concurrent.CopyOnWriteArrayList .

## Creating a CopyOnWriteArrayList

- **List list = new CopyOnWriteArrayList();**
- Using an existing array: **List list = new CopyOnWriteArrayList(Array arr)**
- Using existing collection: **List list = new CopyOnWriteArrayList(Collection c)**

## Inserting elements into CopyOnWriteArrayList

- Insert element at the end: **add(E e)**
- Inserting element at a particular index: **add(int index, E e)**
- Inserting all elements from a collection at the end: **addAll(Collection c)**
- Insert an element if not present in the list: **addIfAbsent(E e)**
- Insert all the elements from a Collection that are not already present in the list: **addAllAbsent(Collection c)**

## Internal Working of CopyOnWriteArrayList

In this lesson, we will see how CopyOnWriteArrayList provides thread-safety.

```
CopyOnWriteArrayList stores the content in an array, so let’s call it originalArray.
```

There is a **ReentrantLock** defined in the CopyOnWriteArrayList as shown below:

```
/** The lock protecting all mutators */
final transient ReentrantLock lock = new ReentrantLock();
```

**NOTE**: Nice article on reentrant lock: https://www.geeksforgeeks.org/reentrant-lock-java/

---

### **Write Operation on a CopyOnWriteArrayList**

When a new element is to added/removed/updated in a CopyOnWriteArrayList then the following procedure takes place:

- The thread that is adding the element acquires a lock on the lock object using the lock.lock() method. If some other thread tries to add an element to the list, then it will not get access.

- The thread that has acquired the lock will then make the copy of the originalArray.

```
Object[] newElements = Arrays.copyOf(elements, len + 1);
```

- Now, the element that needs to be added will be added at the end of this newly copied array.

- Finally the originalArray will now be pointing to this new array and the lock will be released.

In this way, a new element is added/removed/updated in the CopyOnWriteArrayList in a **thread-safe manner**.

---

### **Read Operation on a CopyOnWriteArrayList**

```
When we're calling the iterator() method on the CopyOnWriteArrayList, we get back an Iterator backed up by the IMMUTABLE SNAPSOT of the content of the CopyOnWriteArrayList
```

- Whenever a thread wants to iterate over a CopyOnWriteArrayList / read elements from a CopyOnWriteArrayList, it need not acquire the re-entrant lock.

- CopyOnWriteArrayList.iterator() simply provides an iterator that iterates over an IMMUTABLE SNAPSHOT of the content of the CopyOnWriteArrayList.

- The iterator returned by CopyOnWriteArrayList.iterator/CopyOnWriteArrayList.listIterator cannot be used to remove/add/set elements, because they iterate on an IMMUTABLE SNAPSHOT of the content of the CopyOnWriteArrayList and not on the originalArray. But we can do list.add/list.remove/list.set and no ConcurrentModificationException would be thrown, as write will happen on a new copy of originalArray.

**NOTE:** A CopyOnWriteArrayList is preferrable incase when we want to do more Read operations and less Write operations, because concurrent Read Operations are possible on CopyOnWriteArrayList, but a write operation(add/remove/update) requires acquiring the lock, creating a new copy of the originalArrayList and then doing modifications on the same.

```
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDemo {

	public static void main(String args[]) {
		List<String> list = new CopyOnWriteArrayList<>();
		list.add("Apple");
		list.add("Banana");
		list.add("Orange");

		//Created an iterator
		Iterator<String> itr = list.iterator();

		while(itr.hasNext()) {
			System.out.println(itr.next());
			list.remove("Orange");
		}
		System.out.println("Again creating the iterator");
		//Created an iterator
		itr = list.iterator();

		while(itr.hasNext()) {
			System.out.println(itr.next());

		}

	}
}

Output:

Apple
Banana
Orange
Again creating the iterator
Apple
Banana

Note that "Orange" appears during first iteration,
Because Iterator<String> itr = list.iterator(), returns an iterator that iterates on an immutable snapshots of the contents of originalArray at the time when iterator was created.
```

---

Check code: **CopyOnWriteArrayListExamples.java**

---

Do read about [Collections.synchronizedList](https://docs.oracle.com/javase/8/docs/api/java/util/Collections.html#synchronizedList-java.util.List-) method, Returns a synchronized (thread-safe) list in which all the operations like add, get, insert, remove... are synchronized.

**NOTE:** Even though operations like add() or get() are synchronized, iteration is not automatically thread-safe. You must synchronize manually while iterating:

```java
List<String> al = new ArrayList<String>();

al.add("Geeks");
al.add("for");
al.add("Geeks");
al.add("Computer");
al.add("Science");
al.add("Portal");

List<String> sal = Collections.synchonizedList(al);


synchronized (sal) {
    for (String item : sal) {
        // Safe iteration
    }
}
```

The main difference between synchronized ArrayList and CopyOnWriteArrayList is that:

The whole ArrayList is locked by Synchronized Arraylist for thread safety during both read and write operations.

ArrayList is locked by CopyOnWriteArrayList for thread safety, only during the write operations.


