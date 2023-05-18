# Packages

Packages in java are used to partition class name space to avoid name collisions and provide visibility control.

**Visibility Control:** You can define classes inside a package that are not accessible by the code outside that package.

## Defining a package

- Directory structure defines the package name (directory structure should match the package name exactly)
- To define a package, include a **package** command as the first statement in the .java file.
- If we omit the package statement at the beginning of the file. The classes are put into the default package that has no name.
- As a directory can have multiple .java files, similarly more than one file can include the same package name. So, the package consists of multiple files. But a file can have only one public class.
- A package hierarchy like pkg1.pkg2.pkg3.filename reflects the directory structure. You cannot rename a package without renaming the directory in which classes are stored.

## Finding Packages and CLASSPATH

Package names reflects the directory structure.

How do Java run-time system know where to look for packages that you create?

1. First, it uses the current working directory as it's starting point.
2. You can specify a directory path or paths by setting the **CLASSPATH** environment variable.
3. You can also specify the starting point of your package in **java** or **javac** command using **-classpath** option while running the command.

For Example: refer to MyPackage created in the current directory.

To compile Hello.class inside MyPackage --> Pkg2 --> Pkg3, if we are in current directory, then use Command: **javac MyPackage/Pkg2/Pkg3/Hello.java**

To run Hello.class, From current directory run command **java MyPackage.Pkg2.Pkg3.Hello**

In order for java-runtime system to find MyPackage, either one of the three things has to be true:

- You are executing the program from a directory just above MyPackage
- You have added the path to directory just above MyPackage in **CLASSPATH** environment variable
- You can specify the path to directory just above MyPackage using the **-classpath** option while running **java** command

## Importing Packages

Since classes within packages must be fully qualified with their package name or names, it could become tedious to type in the long dot-separated package path name for every class you want to use.

(For example the way we are using Dog class in the Hello.java )

For this reason, java includes the **import** statement to bring certain classes, or entire packages into visibility.

In .java file, **import** statements occur immediately following the **package** statement and before any class definitions.

Syntax: **import pkg1[.pkg2].(className|\*)**

Examples:

- import java.util.Date; //importing a class
- import java.io.\* //importing all the classes inside a package

**Note:** java.lang is such a common package that it is implicitly imported by the java compiler in all java programs. So we need not explicitly import it.
