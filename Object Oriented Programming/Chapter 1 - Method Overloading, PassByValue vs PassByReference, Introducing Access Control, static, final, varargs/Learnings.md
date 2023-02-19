## Method Overloading

Java uses the type and/or number of arguments to determine which version of the overloaded method to actually call.

While the overloaded methods may have different return types. The return type alone is insufficient to distinguish two versions of a method.

**Automatic type conversions is applied during overloaded methods match resolution.** When Java is looking for a match in deciding which version of the method to call, the match need not always be exact. In that case, Java applies automatic type conversion during overload resolution.

**Method overloading applies to Constructors as well**

## PassByValue vs PassByReference

When we pass a primitive type to a method, it is PassByValue(CallByValue). Thus a copy of the argument is made.

When we pass an Object to a method, it is CallByReference(PassByreference).

Keep in mind that when you create a variable of a class type, you are only storing the reference to that object in a variable of type class. Thus when you pass this reference to a method, the parameter that receives it will refer to the same object as that referred to by the argument.

## Introducing Access Control

Through Access Control, we can control what parts of a program can access the members of a class. By controlling access, we can prevent misuse.

Java access modifiers: **private**, **public**, **protected** and **default**

## static class members

When objects of a class are declared, no copy of a static variable is made. All instances of the class share the same static variable.

- Both methods and variables can be declared as static.

Static variables and methods are attached to class and not instances of the class.

Methods declared as **static** have several restrictions:

- They can only directly call other **static** methods
- They can only directly access **static** data
- They cannot refer to **this** or **super** in any way.

**Static block**

Static block gets executed exactly once, when the class is first loaded and not on every object initialization.

If you need to do computation in order to initialize your static variables, we can utilise static block.

class Sample{
static int a=0;
static int b;

    static{
        b = a*4;
    }

}

## final class members (constants)

**final** prevents its contents from being modified.

We can initialize **final** variables in just exactly two ways:

1. At the time of declaration
2. We can assign it a value within a constructor.

In addition to class variables, both method parameters and local variables can be declared **final**. Declaring a method parameter **final** prevents it from being changed within the method. Declaring a local variable **final** within method prevents it from being assigned a value more than once.

**Convention**: we declare **final** fields in all capital letters.

For example final int FILE_NEW = 1;

## Nested/Inner classes

The nested class has access to the members, including private members of the class in which it is nested.

However, the outer class does not have access to the members of the nested class.

Nested class instance can only be generated within outer class.

## String class

Every string that we create is actually an object of class **String**.

Even the string constants are **String** class objects.

String str = "This is Kapil";

**Objects of class String are immutable.**

For Example:

str = str + "Thukral";

will create a new object of class String and assign it to str (reference of type String);

String class contains several methods like equals(), charAt(), length().

## Varargs: variable length arguments

Allows methods to take a variable number of arguments.

A variable-arguments is specified by three periods (...)

For Example:
void test(int ...v){}

Here, **test** method can be called with zero or more arguments.

**int ...v** , here **v** implicitly is declared as an array of type int[].

Thus inside test method **v** is accessed using the normal array syntax.
