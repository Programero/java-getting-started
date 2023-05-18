abstract class Figure { // abstract class
    double dim1; // an abstract class can have instance variables
    double dim2;

    Figure(double a, double b) { // an abstract class can have constructors
        dim1 = a;
        dim2 = b;
    }

    abstract double getArea(); // abstract method
}

class Triangle extends Figure {
    Triangle(double base, double height) {
        super(base, height); // calling abstract class constructor
    }

    double getArea() {
        return dim1 * dim2 / 2;
    }
}

class Rectangle extends Figure {
    Rectangle(double length, double width) {
        super(length, width); // calling abstract class constructor
    }

    double getArea() {
        return dim1 * dim2;
    }
}

class Abstract {
    public static void main(String args[]) {
        Figure f1 = new Rectangle(10, 20);
        Figure f2 = new Triangle(10, 20);

        System.out.println(f1.getArea());
        System.out.println(f2.getArea());
    }
}