import java.util.*;

public class SortingWithCollections {
    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(10);
        list.add(60);
        list.add(40);
        list.add(50);

        // To sort the list in asc order using Collections class
        Collections.sort(list);
        System.out.println("Sorted the list in ascending order: " + list);

        // To sort the list in desc order, we need to use the overloaded sort method
        // that also accepts a Comparator Object
        Collections.sort(list, new SortInDesc());
        System.out.println("Sorted the list in descending order: " + list);

        // Instead of defining a separate class implementing Comparator, We can also use
        // Comparator.reverseOrder(): returns a comparator that imposes the reverse of
        // the natural ordering on a collection of objects that implements the
        // Comparable interface.
        Collections.sort(list, Comparator.reverseOrder()); // This will sort the list in descending order
        System.out.println("Sorted the list in descending order: " + list);

        // Instead of defining a class that implements Comparator interface we could
        // also have used an Anonymous Class
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return i2 - i1;
            }
        });
        System.out.println("Sorted the list in descending order: " + list);

        // The above code can be further simplified if we use lambda expressions instead
        // of anonymous classes.
        Collections.sort(list, (Integer i1, Integer i2) -> i2 - i1);
        System.out.println("Sorted the list in descending order: " + list);
    }
}

class SortInDesc implements Comparator<Integer> {
    public int compare(Integer i1, Integer i2) {
        return i2 - i1;
    }
}
