## Getting started with Java

The purpose of this file is to take notes of the learnings from the book: Java - The Complete Reference (Herbert Schildt)

## JVM

Code --> Java Compiler --> ByteCode --> JVM --> Low Level Executable Code

**JVM**: Interpreter of ByteCode.

- Provides Portability and Security
- Provides better exceution speed in comparison to other interpreted languages, mainly because JVM has JIT(Just In Time) compiler which helps by compileing a few pieces of bytecode.

**Portability**: JVM differs from platform to platform. Bytecode remains the same and can be executed on different machines with different operating systems and processors. (write once, run anywhere, any time, forever)

**Security**: JVM runs the Java code and prevents it from generating side effects outside of the JVM runtime env as JVM applies several runtime checks.

## Java features

- Strictly typed
- Garbage collection
- Multithreaded (Parallel Programming)
