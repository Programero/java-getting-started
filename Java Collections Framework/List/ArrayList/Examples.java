import java.util.*;

class Examples {
    public static void main(String args[]) {

        // Creating an ArrayList and inserting elements
        ArrayList<Integer> list = new ArrayList<Integer>(); // creating an ArrayList of 0 capacity
        list.add(10);
        list.add(30);
        list.add(20);
        System.out.println(list);

        list.add(2, 50);
        System.out.println(list);

        ArrayList<Integer> list2 = new ArrayList<Integer>();
        list2.add(100);
        list2.add(99);
        list2.add(110);

        list.addAll(list2);
        System.out.println(list);

        // Fetching element at a given index
        System.out.println("Element at index 3: " + list.get(3));

        // Removing Elements

        list.removeAll(list2);
        System.out.println(list);

        list.remove(2);
        System.out.println(list);

        // list.remove(20); this will throw an IndexOutOfBound exception as remove will
        // treat 20 as index
        list.remove(new Integer(20)); // Integer(int) has been deprecated, therefore better to use valueOf(int)
        System.out.println(list);

        list.add(45);
        list.add(15);
        System.out.println(list);

        // list.removeRange(2, 4); throws an error: removeRange(int,int) has protected
        // access in ArrayList class. Therefore, we cannot access it

        ListWithRemoveRange listWithRR = new ListWithRemoveRange();
        listWithRR.add(105);
        listWithRR.add(115);
        listWithRR.add(95);
        System.out.println(listWithRR);

        listWithRR.removeRange(1, 3);
        System.out.println(listWithRR);

        // using replaceAll to increment all the values by 10
        list.replaceAll((ele) -> ele + 10);
        System.out.println(list);

        // update the element at index 1
        list.set(1, 13);
        System.out.println(list);

        // Check if an element exists in list, if yes, find the index of it's first
        // occurence
        if (list.contains(new Integer(55))) {
            System.out.println("Index of Integer 55: " + list.indexOf(new Integer(55)));
        }

    }
}

class ListWithRemoveRange extends ArrayList<Integer> {
    // removeRange is having protected access in ArrayList class, therefore I will
    // override it with protected/public access. Remember that we cannot lower the
    // access while overriding, but we can improve the access.
    @Override
    public void removeRange(int fromIndex, int toIndex) {
        super.removeRange(fromIndex, toIndex);
    }
}
