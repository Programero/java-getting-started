Box b1; //an object reference that can point to an object of type Box

b1 = new Box(); //we created a new object of type Box and b1 holds the reference to it.

### Constructors

- Constructors have the same name as the class and donot have any return type
- We will usually have public constructors.
- A private constructor can only be accessed within the same class. Thus, we cannot extend a class with only private constructors and cannot even create an object outside of it.
- The main purpose of Private constructors is to restrict object creation.

## **this** keyword

- **this** can be used inside any method to refer to the current object (object that invoked the method)
- **this** can also be used to invoke another constructor within the same class.

For example:

class Date {

private int day;

private int month;

private int year;

private String event;

public Date(int day, int month, int year){

    this.day = day;
    this.month = month;
    this.year = year;

}

public Date(int day, int month, int year, String event){

    this(day, month, year); // calling the constructor
    this.event = event;

}

}

## The **finalize()** method (destructor)

Sometimes an object needs to perform some actions before it is destroyed.

For example, if an object is holding some non-java resources such as file handle, open connections. Then you might want to make sure that these resources are freed up before that object is destroyed.

To handle such situations, you can add finalize() method in your class. Java runtime calls that method right before the memory allocated to that object is about to be freed up.

## Garbage collector

The garbage collector runs periodically, checking for objects that are no longer referenced and cleans up the memory allocated to them.

In languages like C++, dynamically allocated objects must be manually released.

Java handles deallocation automatically and when no references to an object exists, the memory occupied by that object is reclaimed.

### OOPS Principles

- Data Hiding using **Encapsulation** and **Abstraction**
- Inheritance
- Polymorphism

### Important Concepts:

- Abstract Classes and Interfaces
- Aggregation and Composition
