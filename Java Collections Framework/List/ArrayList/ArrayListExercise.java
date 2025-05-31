import java.util.*;

//In this exercise, we perform three tasks:
//1. Find Employees aged over 50
//2. Remove all Employees from USA
//3. Sort Employees by country

public class ArrayListExercise {
    public static void main(String args[]) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Alex", 23, "USA"));
        list.add(new Employee("Dave", 34, "India"));
        list.add(new Employee("Carl", 21, "USA"));
        list.add(new Employee("Joe", 56, "Russia"));
        list.add(new Employee("Amit", 64, "China"));
        list.add(new Employee("Ryan", 19, "Brazil"));

        // Task1 Find all Employees aged over 50
        // Here we use for each loop to iterate
        for (Employee employee : list) {
            if (employee.age > 50) {
                System.out.println(employee.name);
            }
        }

        // Task2 Remove all employees from USA
        // Here, we use iterator to iterate all employees in the list
        Iterator<Employee> itr = list.iterator();
        while (itr.hasNext()) {
            if (itr.next().country.equals("USA")) {
                itr.remove();
            }
        }

        System.out.println("list after removing Employees from USA: " + list);

        // Task 3 Sort the list by country
        // Here we are using lambda function to define the Comparator Interface's
        // compare method
        list.sort((e1, e2) -> (e1.age - e2.age));
        System.out.println("list after sorting by age: " + list);

    }
}

class Employee {
    String name;
    int age;
    String country;

    public Employee(String name, int age, String country) {
        super();
        this.name = name;
        this.age = age;
        this.country = country;
    }

    @Override
    public String toString() {
        return this.name + " is of age: " + this.age + " from: " + this.country;
    }
}