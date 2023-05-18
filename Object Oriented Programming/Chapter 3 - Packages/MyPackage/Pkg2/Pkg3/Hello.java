package MyPackage.Pkg2.Pkg3;

import MyPackage.Pkg2.Cat;

public class Hello {
    public static void main(String args[]) {
        Cat cat = new Cat();
        System.out.println("Hello World from MyPackage --> Pkg2 --> Pkg3");
        cat.sayMeow();
        MyPackage.Pkg2.Dog dog = new MyPackage.Pkg2.Dog();
        dog.sayBhow();
    }
}
