import java.util.*;

public class IterationUsingListIterator {
    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(10);
        list.add(20);
        list.add(50);
        list.add(30);

        ListIterator<Integer> litr = list.listIterator();

        while (litr.hasNext()) {
            System.out.println("The element at index " + litr.nextIndex() + " is " + litr.next());
        }

        // Now the litr is at the end, therefore we can now iterate the list from the
        // back
        while (litr.hasPrevious()) {
            System.out.println("The element at index " + litr.previousIndex() + " is " + litr.previous());
        }

        // Updating the elements while Iterating
        while (litr.hasNext()) {
            int ele = litr.next();
            litr.set(ele + 10);
        }

        System.out.println(list);
    }
}
