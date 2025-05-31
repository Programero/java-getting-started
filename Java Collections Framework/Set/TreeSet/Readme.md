# TreeSet

## Introduction

Java TreeSet class implements the Set interface that uses a Red-Black Tree for storage.

- TreeSet does not allow duplicate elements.
- TreeSet class doesn’t allow null elements.
- The elements are stored in ascending order in a TreeSet.

## Difference between HashSet and TreeSet

- The elements are stored in random order in a HashSet, whereas it is stored in sorted order in TreeSet.
- The HashSet allows one null element, whereas a TreeSet does not allow a null element.
- HashSet is faster than the TreeSet.

  HashSet provides constant-time performance for most operations like add(), remove() and contains(), versus the log(n) time offered by the TreeSet.

## Creating a TreeSet

**Note:** Since all the elements are stored in sorted order in a TreeSet, storing elements should either implement the Comparable interface or a custom Comparator should be passed to the constructor of TreeSet.

```
Set<Integer> set= new TreeSet<>();
```

Or

```
Set<Type> set= new TreeSet<Type>(Comparator C);
```

## Inserting an Element

- **add(E e)**: This method returns true if the element is inserted, and it returns false if the element is already present.

## Fetching an Element

Following methods can be used to fetch elements from TreeSet:

- **first()**: Fetching the first element. If the TreeSet is empty, then NoSuchElementException is thrown.
- **last()**: Fetching the last element. If the TreeSet is empty, then NoSuchElementException is thrown.
- **subSet(E fromElement, E toElement)**: **Fetching the subset of elements** Note that **fromElement** is inclusive and **toElement** is exclusive
- **headSet(E toElement)**: **Fetching elements that are smaller than the given element**. The toElement is not inclusive.
- **tailSet(E fromElement)**: **Fetching elements that are greater than the given element:** The fromElement is not inclusive.

## Removing an Element from a TreeSet

- **remove(Object o)**: This method returns true if the element is removed and returns false if the element is not present in the TreeSet.

## Other operations on TreeSet

- **isEmpty()**: Check if TreeSet is empty
- **size()**: Get the size of the TreeSet
- **contains(Object o)**: used to check if a particular element is present in the TreeSet or not.

Syntax and Code: **TreeSetExercise.java**
