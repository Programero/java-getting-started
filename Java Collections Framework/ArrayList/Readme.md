# ArrayList

**ArrayList** is the most widely used implementation of the **List interface**. Some of the salient features of an **ArrayList** are:

1. Elements are stored in the order of insertion.
2. It allows the storage of duplicate elements.
3. ArrayList also supports null elements.

(More or less like a dynamic array)

## Internal implementation of ArrayList

An **ArrayList** stores data in a resizable array.

**Initial Size:** Before Java 8, when an ArrayList was created, an array of default size ten was created internally. Now, when an ArrayList is created, an array of size zero is created. Only when the first element is inserted does the array size change to ten. This is called lazy initialization, and it saves a lot of memory.

**Resizing:** Before adding an element in ArrayList, its capacity is checked. If the internal array is full, then a new array of size (n+n/2+1) is created (e.g., if the capacity is ten, then a new array of size 16 will be created). The elements from the old array will be copied to the new array. This increases the capacity of an ArrayList, which is a time-consuming process.

## Time complexities:

- **Adding an Element**: Best Case O(1) , WorstCase O(n)
- **Removing an Element**: O(n)

  There are two ways to remove an element from ArrayList:

  1. remove(indexOfElement): The element is found in O(1) time using the index, but when the element is removed, the other elements needs to be moved to the left. **O(n)**

  2. remove(element): The ArrayList is scanned from the beginning to find the first occurence of that element and then it is removed. **O(n)**

- **Fetching an element using indexOfElement:** O(1)

## Creating an ArrayList

There are three ways to create an **ArrayList:**

1. List list = new ArrayList< type T>(); // this creates an ArrayList of size zero.

2. List list = new ArrayList< type T>(50); // this creates an ArrayList of size 50.

3. List list = new ArrayList< type T>(oldList); // this creates an ArrayList from an existing collection 'oldList'

**Note:** We are using an object reference of **List** interface type. In the introduction lesson, we saw that **ArrayList** extends **AbstractList** which in turn implements **List** interface.

## Inserting into an ArrayList

- Inserting an Element at the end: **add(E e)**
- Inserting an Element at given index: **add(int index, E e)** This method will shift the element currently at that position and any subsequent elements to the right.
- Inserting multiple elements at the end from another Collection: **addAll(Collection c)** this method will add all the elements of Collection c at the end of the ArrayList
- Inserting multiple elements from another Collection at a particular index: **addAll(int index, Collection c)** This method will shift the element currently at that position and any subsequent elements to the right.

## Fetching an Element at particular index

- get(int index)

## Removing Elements from an ArrayList

- Removing an Element at a particular index: **remove(int index)**
- Removing a particular element from the ArrayList: **remove(Object e)** Element e will be searched from the beginning and the first occurence will be removed.
- Removing all the elements within a range: **removeRange(int fromIndex, int toIndex)** remove all the elements whose index is between fromIndex, inclusive, and toIndex, exclusive.

  **Note:** removeRange has protected access inside ArrayList class, therefore we cannot use it directly. Kindly check Examples.java to see how we use removeRange method.

- Removing all the elements within a given Collection: **removeAll(Collection c)** remove, from the given list, all of the elements that are contained in the specified collection c.
- Empty an ArrayList: **clear()** remove all the elements from the ArrayList.

---

**_Important Note:_** We saw that remove(int index) removes a method at the given index and remove(Object o) removes the given object from the ArrayList. Suppose we have an ArrayList that contains five elements i.e [13, 21, 43, 2, 9]. Now, if we do list.remove(2), then which overloaded method will be called. Will remove(int index) be called or remove(Object o) be called? remove(int index) will be called because we are passing a primitive to remove method. If we want to delete element 2, we should call remove(new Integer(2)) because elements are stored in an ArrayList as objects and not primitives.

---

## Replacing all the elements of the ArrayList

Let's say we have a list of Strings, we want to convert all of them to uppercase.

list.replaceAll((str) -> str.toUpperCase());

## Updating an element in ArrayList

To update an element in ArrayList, the **_set(int index, E e)_** method can be used. This method takes the index, which needs to be updated and a new value.

## Checking if an element is present in ArrayList

To check if an element is present in the list, we can use the **_contains(Object o)_** method. This method returns true if the element is present in the list; otherwise, it returns false.

If we need the index of the first occurrence of the element, then the **_indexOf(Object o)_** method can be used. And if we need the last occurrence of the element, the **_lastIndexOf(Object o)_** can be used.

# ArrayList: Iteration

Let's discuss how an ArrayList can be iterated.

- Using for loop

  for (int i = 0; i < list.size(); i++) { //Simple for loop

        System.out.println(list.get(i));

  }

- Using forEach loop

  for (Integer i : list) { //using forEach loop

      System.out.println(i);

  }

- Using Iterator

  The iterator() method in ArrayList returns an **Iterator** type object.

  The **Iterator** interface declares the below methods that helps with iterating an ArrayList

  1. **_hasNext()_** - returns **true** if there are more elements in the list.

  2. **_next()_** - returns the next element in the list. Before calling next(), we should always call hasNext() to verify that there is an element; otherwise, NoSuchElementException will be thrown.

  3. **_remove()_** - This method removes the last element returned by the iterator using itr.next(). It can be called only once per call to the **_next()_**.

  4. **_forEachRemaining(Consumer<? super E> action)_** - This method was introduced in Java 8. It performs the given action for each remaining element until all elements have been processed or the action throws an exception.

**Note:** Once an Iterator has been created (List< type T> itr = list.iterator()) , then we should not add/update/remove any element from the list using list.add/list.remove/list.set , doing so will throw **ConcurrentModificationException**. Mind that we can still use itr.remove() on the iterator object.

Syntax: Check **Iteration.java**

---

## ArrayList: Iteration using ListIterator

**Why ListIterator?**

The Iterator provides very limited capabilities as we can iterate only in the forward direction and we can’t update or insert an element to the list while iterating, we can only remove an element from the list using iterator object while iterating. To overcome these problems, we can use **ListIterator**.

The **listIterator()** method returns an object of type **ListIterator** which can then be used to iterate the ArrayList.

Below are the methods that are available in the **ListIterator** Interface:

1. **hasNext()** - This method is used to check if there is a next Element in the List when the list is iterated in the forward direction.

2. **next()** - This method returns the next element in the list and advances the cursor position.

3. **hasPrevious()** - This method is used to check if there is a next element in the list when the list is iterated in the backward direction.

4. **previous()** - This method returns the previous element in the list and moves the cursor position backward.

5. **nextIndex()** - This method returns the index of the element that would be returned by a subsequent call to **_next()_**. It returns the list size if the list iterator is at the end of the list.

6. **previousIndex()** - This method returns the index of the element that would be returned by a subsequent call to previous(). It returns -1 if the list iterator is at the beginning of the list.

7. **remove()** - This method removes the last element that was returned by next() or previous() from the list. This call can only be made once per call to next() or previous(). It can be made only if add() has not been called after the last call to next() or previous().

8. **set(E e)** - This method removes the last element that was returned by next() or previous() from the list. This call can only be made once per call to next() or previous(). It can be made only if add() has not been called after the last call to next() or previous().

   **Note**: ListIterator obj allows to update an element in the list while iterating. Iterator object doesn't allows you to do so. Iterator obj only allows you to remove an element from the list while iterating.

9. **add(E e)** - This method inserts the specified element into the list. The element is inserted immediately before the element that would be returned by next(), if any, and after the element that would be returned by previous(), if any. The new element is inserted before the implicit cursor: a subsequent call to next would be unaffected, and a subsequent call to previous would return the new element. (This call increases by one the value that would be returned by a call to nextIndex or previousIndex.)

   **Note**: ListIterator obj allows to add an element to the list while iterating. Iterator object doesn't allows you to do so. Iterator obj only allows you to remove an element from the list while iterating.

Syntax and code: Please check **IterationUsingListIterator.java**

---

## ArrayList Sorting

There are two ways of sorting an ArrayList:

1. Using **Collections.sort(List<T> list)** method
2. Using the **sort(Comparator<? super E> c)** method in the **List** interface.

---

### 1. Using **Collections.sort(List<T> list)** method

Collections class in java.util package defines a public staic method for sorting:

```
public static void sort(List<T> myList)
```

This method can be used to sort a list in ascending order.

**Syntax/Code:** Check **SortingWithCollections.java**

**Note:** The **Collections.sort(List<T> t)** method takes an ArrayList of type T objects as the input. **It is must that T should implement the Comparable interface and override the compareTo(T obj2) method otherwise, the code will not compile.**

The Integer class used in **SortingWithCollections.java** by default implements the **Comparable** interface and overrides the **compareTo(Integer i2)** method.

To sort the List in descending order or in any custom order, we can use an overloaded method, **sort(List<T> list, Comparator<? super T> c)**, which takes a List and Comparator interface object reference as the input.

In the second argument we need to pass an Object reference and that Object's class should implement Comparator Interface and override **compare(T t1, T t2)** method.

Checkout **SortingWithCollections.java** file to findout how the comparator object reference is passed as the second parameter.

---

### 2. Using the **sort(Comparator<? super E> c)** method in the **List** interface.

In Java 8, the sort(Comparator<? super E> c) method was added to the List interface.

**Comparator Interface** has an abstract method **compare** which is used to compare two similar objects and returns an integer: either negative number or 0 or positive number which then decides the ordering of the elements in the List.

Because ArrayList implements List interface, therefore we can directly use list.sort

Syntax and Code: Check **Sorting.java**

---

## Understanding Comparable Interface

Collections.sort() method sorts the given List in ascending order. But the question is, how does the sort() method decide which element is smaller and which one is larger?

Each wrapper class(Integer, Double, or Long), String class, and Date class implements an interface called Comparable. This interface contains a compareTo(T obj) method which is used by Collections.sort method to sort the Collection. This method returns a negative integer, zero, or a positive integer if this object is less than, equal to, or greater than the object passed as an argument.

```
If we use the Collections.sort(List<T> list) method to sort an ArrayList, then the class whose objects are stored in the ArrayList must implement the Comparable interface. If the ArrayList stores an Integer, a Long, or a String, then we don’t need to worry as these classes already implement the Comparable interface. But if the ArrayList stores a custom class object, then that class must implement the Comparable interface and implement compareTo(T t2).

compareTo method is used in following manner, t1.compareTo(t2) that returns:

-1 if the t1 should come before t2
1 if the t2 should come before t1
0 if the t1 and t2 are equal
```

**Example:**

Let's say we have an Employee class objects with Name, Age.

Now if we want to sort the List of Employee class objects by Age using Collections.sort, then our Employee class should implement the Comparable interface and should override the compareTo(T t2) method.

Check **ComparableInterfaceDemo.java** file.

---

## Understanding Comparator Interface

One of the major drawbacks of using a Comparable interface is that the comparing logic gets fixed. For example, in the previous Employee class, we sorted using age, that depends only on the implementation of the compareTo() method and later we cannot sort using Name.

The Comparator interface has a method, compare(T o1, T o2), which takes two objects, o1 and o2 as parameters. It returns -1 if o1
< o2, 1 if o1 > o2 and 0 if o1 is equal to o2.

There are two ways in which Comparator Interface can be used to define sorting sequence:

- Using List.Sort(Comparator< T > obj)
- Using Collections.Sort(List< T > list, Comparator< T > obj)

Example: In CompratorInterfaceDemo, we again use the same Employee Class, but this time we define two different comparators, one to sort with age, other one to sort with name.

Syntax and Code: **ComparatorInterfaceDemo.java**

---

### Also check out the exercise code in **ArrayListExercise.java**
