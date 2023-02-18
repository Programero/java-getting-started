Box b1; //an object reference that can point to an object of type Box

b1 = new Box(); //we created a new object of type Box and b1 holds the reference to it.

**Constructors have the same name as the class.**

## **this** keyword

- **this** can be used inside any method to refer to the current object (object that invoked the method)

## The **finalize()** method (destructor)

Sometimes an object needs to perform some actions before it is destroyed.

For example, if an object is holding some non-java resources such as file handle, open connections. Then you might want to make sure that these resources are freed up before that object is destroyed.

To handle such situations, you can add finalize() method in your class. Java runtime calls that method right before the memory allocated to that object is about to be freed up.

## Garbage collector

The garbage collector runs periodically, checking for objects that are no longer referenced and cleans up the memory allocated to them.

In languages like C++, dynamically allocated objects must be manually released.

Java handles deallocation automatically and when no references to an object exists, the memory occupied by that object is reclaimed.
