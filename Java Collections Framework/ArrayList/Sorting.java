import java.util.*;

public class Sorting {

    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(10);
        list.add(50);
        list.add(20);
        list.add(40);

        // Sorting in ascending order
        list.sort(Comparator.naturalOrder()); // Comparator.naturalOrder() returns a comparator that uses compareTo
                                              // method of Comparable Interface to compare two Comparable objects.
        System.out.println(list);

        // Sorting in descending order
        // The reverseOrder() method of Comparator Interface in Java returns a
        // comparator object that compares Comparable objects in reverse of natural
        // order
        list.sort(Comparator.reverseOrder());
        System.out.println(list);

        list.sort(new SortInAsc()); // Passing an Object of the class implementing compare method of Comparator
                                    // Interface
        System.out.println(list);

        list.sort(new SortInDesc());
        System.out.println(list);

        list.sort((i1, i2) -> i1 - i2); // Using lamba function to sort in asc order
        System.out.println(list);
    }
}

class SortInAsc implements Comparator<Integer> {
    public int compare(Integer i1, Integer i2) {
        return i1 - i2;
    }
}

class SortInDesc implements Comparator<Integer> {
    public int compare(Integer i1, Integer i2) {
        return i2 - i1;
    }
}