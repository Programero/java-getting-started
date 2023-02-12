## Data Types

Java defines 8 primitive types:

- byte (8 bits)
- short (16 bits)
- int (32 bits)
- long (64 bits)
- char (16 bits) (Java uses unicode to represent characters)
- float (32 bits)
- double (64 bits)
- boolean (1 bit) (true or false)

**Integers**: byte, short, int, long

**Characters**: char

**Boolean**: boolean

**Floating-point numbers**: float, double

Although Java otherwise is completely object oriented, primitive types are not.

---

## Variables

### Scope and Lifetime of Variables

**Variables are block-scoped.**

Variables are created when their scope is entered and destroyed when their scope is left. Thus the lifetime of a variable is confined to the block-scope in which it is defined.

### Type Conversions

**Implicit Type Conversions**

Implicit type conversions take place if the following two conditions are met:

- The two types are compatible.
- The destination type is larger than the source type

For example: byte, int can be promoted to long. char cannot be promoted to int

int i=99;
long l=i; // Implicit type conversion,

char c='a';
int i = c; // throws error as implicit type conversion is not possible between two incompatible types.

**Explicit type casting**

int a;

byte b;

b = (byte) a; // Explicit type conversion is required as the destination type(byte) is smaller than the source type(int). "truncation" will happen

**Automatic type promotion in expressions**

Type Promotion Rules:

- **byte**, **short**, **char** are promoted to **int** incase the expression contains an **int**
- If one operand is long, the entire expression is promoted to long.
- If one operand is float, the entire expression is promoted to float.
- If one operand is double, the entire expression is promoted to double.

---

## Arrays

**Java supports dynamic memory allocation to arrays.**

### One dimensional Arrays

int arr[]; // Array declaration, no memory allocated till now

arr = new int[5]; //Initlialization

OR

arr = {20,21,34,55,12}; // initializing with values

**Java supports dynamic memory allocation to arrays.**

int size = 10;

int arr[] = new int[size];

## Two dimensional arrays

int i=5,j=4;

int twoD[][] = new int[i][j];

OR

int[][] twoD = new int[i][j];

---

## For-Each loop

for(type itr-var : collection){}

**type** specifies the datatype of the elements in the collection.

**itr-var** will one-by-one receive the elements of the collection.

int arr[]={1,2,3,4,5};

for(int num:arr){
System.out.print(num);
}

Output: 12345

**Note**: In the for-each loop, the itr-var is read-only and assignment to itr-var will have no effect to the underlying collection.
