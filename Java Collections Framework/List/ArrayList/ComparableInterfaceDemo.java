import java.util.*;

class Employee implements Comparable<Employee> {
    String name;
    int age;

    Employee(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Employee e2) {
        return this.age - e2.age;
    }

    @Override
    public String toString() {
        return this.name + " of age: " + this.age;
    }
}

public class ComparableInterfaceDemo {
    public static void main(String args[]) {
        ArrayList<Employee> list = new ArrayList<Employee>();
        list.add(new Employee("Kapil", 20));
        list.add(new Employee("Megha", 19));
        Collections.sort(list);
        System.out.println(list);
    }
}
