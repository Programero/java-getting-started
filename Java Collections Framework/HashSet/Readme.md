# HashSet

## Introduction

HashSet is a class in the java.utils package which implements the Set interface

- HashSet does not allow duplicate elements.
- HashSet allows only one null element.
- The elements are inserted in random order in a HashSet.
- A HashSet is internally backed by a HashMap.

### Creating a HashSet

```
Set<E> set= new HashSet<E>();
```

This constructor creates a HashSet with an initial capacity of 16 and a load factor of 0.75 .

You can also specify the initial capacity and the load factor

```
HashSet<E> hs = new HashSet<E>(int initialCapacity, float loadFactor);
```

### Inserting an Element into a HashSet

There is an **add(E e)** method available that inserts an element into the HashSet. If the element is not already present, then this method puts the element and returns true. If the element is already present, then it returns false.

### Fetching an Element from a HashSet

In HashSet, we cannot get an element by index as the elements are stored in random order.

We cannot get a particular element. We can check whether a particular element is in the HashSet or not, for that we can use the contains() method.

### Removing an Element from a HashSet

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

### Sorting a HashSet

Since a HashSet stores the elements in random order, it is not possible to store the elements in a HashSet in sorted order. If we want to sort the elements of a HashSet, then we should convert it into some other Collection such as a List, TreeSet, or LinkedHashSet.

```
        // Creating an ArrayList from existing set.
		List<Integer> list = new ArrayList<>(set);
		// Sorting the list.
		Collections.sort(list);
```

Syntax and Code: **HashSetExercise.java**

---

## Note: The elements in HashSet are stored in Random order. HashSet allows one null element. HashSet is implemented using a HashMap.
