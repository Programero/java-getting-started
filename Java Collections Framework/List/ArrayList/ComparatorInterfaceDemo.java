import java.util.*;

public class ComparatorInterfaceDemo {
    public static void main(String args[]) {
        ArrayList<Employees> list = new ArrayList<Employees>();
        list.add(new Employees("Kapil", 20));
        list.add(new Employees("Megha", 19));
        list.sort(new SortByAgeComparator());
        System.out.println(list);
        list.sort(new SortByNameComparator());
        System.out.println(list);

        // We can also use simple lambda functions as Comparators
        list.sort((e1, e2) -> (e1.age - e2.age));
        System.out.println(list);
        list.sort((e1, e2) -> e1.name.compareTo(e2.name));
        System.out.println(list);
    }
}

class Employees {
    String name;
    int age;

    Employees(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return this.name + " of age: " + this.age;
    }
}

class SortByAgeComparator implements Comparator<Employees> {
    public int compare(Employees e1, Employees e2) {
        return e1.age - e2.age;
    }
}

class SortByNameComparator implements Comparator<Employees> {
    public int compare(Employees e1, Employees e2) {
        return e1.name.compareTo(e2.name);
    }
}