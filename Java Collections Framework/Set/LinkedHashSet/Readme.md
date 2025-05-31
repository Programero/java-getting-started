# HashSet

## Introduction

- LinkedHashSet doesnot allow duplicate elements.
- LinkedHashSet allows exactly one null value to be stored in the set
- LinkedHashSet maintains the insertion order
- Uses LinkedHashMap internally, with set values stored in LinkedHashMap keys. (refer to HashSet for better implementation details)
- Best Case time complexity for insertion, deletion, update is O(1) and worstcase is O(n) (incase when there are many collisions in HashMap)

### Creating a LinkedHashSet

```java
Set<E> set = new LinkedHashSet<E>();
```

This constructor creates a HashSet with an initial capacity of 16 and a load factor of 0.75 .

You can also specify the initial capacity and the load factor in the constructor.

### Inserting an Element into LinkedHashSet

There is an **add(E e)** method available that inserts an element into the HashSet. If the element is not already present, then this method puts the element and returns true. If the element is already present, then it returns false.

BestCase complexity: O(1), WorstCase complexity: O(n)

### fetching an Element from LinkedHashSet

There's no way to fetch any particular element at a given index. But you can use ```.contains(Object o)``` to check if a particular element is part of the LinkedHashSet or not.

### Removing an Element from a LinkedHashSet

**remove(Object o)** method:

If the element is present, it is removed and the method returns true. If the element is not present, then method returns false.

**clear()** method:

We can use the clear() method to remove all the elements from a HashSet.

### Iterating a HashSet

- Using For each loop:

```
    for(int i : set) {
		System.out.println(i);
	}

Set definition: HashSet<Integer> set = new HashSet<Integer>();
```

- Using Iterator:

```
        Iterator<Integer> itr = set.iterator();

		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
```

- Using forEach() method:

We can use the **forEach(Consumer<? super T> action)** method defined in the Iterable class. This method was introduced in Java 8. It accepts an action that needs to be performed for each element as a parameter.

```
    set.forEach(System.out::println);
```

### Sorting a LinkedHashSet

LinkedHashSet maintains insertion order, not sorted order. If you want to sort its elements, you need to convert it to a list or a sorted set(TreeSet).

```java
List<String> sortedList = new ArrayList<>(set);
Collections.sort(sortedList);  // Sort in natural order
```

OR

```java
Set<String> sortedSet = new TreeSet<>(set);
System.out.println(sortedSet); 
```

Comparison between HashSet, LinkedHashSet and TreeSet

| Operation            | `HashSet`                      | `LinkedHashSet`                | `TreeSet`                          |
| -------------------- | ------------------------------ | ------------------------------ | ---------------------------------- |
| `add(E e)`           | **O(1)** avg<br>**O(n)** worst | **O(1)** avg<br>**O(n)** worst | **O(log n)** (uses Red-Black Tree) |
| `remove(Object o)`   | **O(1)** avg<br>**O(n)** worst | **O(1)** avg<br>**O(n)** worst | **O(log n)**                       |
| `contains(Object o)` | **O(1)** avg<br>**O(n)** worst | **O(1)** avg<br>**O(n)** worst | **O(log n)**                       |
| `iterator()`         | O(n)                           | O(n) (in insertion order)      | O(n) (in sorted order)             |
| `clear()`            | O(n)                           | O(n)                           | O(n)                               |
| `size()`             | O(1)                           | O(1)                           | O(1)                               |

| Feature                | `HashSet`      | `LinkedHashSet`           | `TreeSet`                                                   |
| ---------------------- | -------------- | ------------------------- | ----------------------------------------------------------- |
| **Ordering**           | No guarantee   | Maintains insertion order | Sorted (natural or custom `Comparator`)                     |
| **Duplicates Allowed** | ❌ No           | ❌ No                      | ❌ No                                                        |
| **Allows `null`**      | ✅ Yes (1 null) | ✅ Yes (1 null)            | ⚠️ Yes (but only if not using comparator that disallows it) |
| **Thread-Safe**        | ❌ No           | ❌ No                      | ❌ No                                                        |
| **Backed By**          | Hash table     | Hash table + linked list  | Red-Black Tree                                              |


None of the operations of above Set collections are Thread safe.
Use ```Collections.synchronizedSet(new LinkedHashSet<>())``` if you need thread safety or use ```ConcurrentSkipListSet```.

