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

        // Updating the elements while Iterating using ListIterator object and not using
        // the ArrayList object directly
        while (litr.hasNext()) {
            int ele = litr.next();
            System.out.println("Element is: " + ele);
            litr.set(ele + 10);
            if (ele == 50) {
                litr.add(40);
            }
        }
        // Note that when we added 40 after 50, but still during iteration we didn't
        // come across element 40 because in listIterator.add, the new element is
        // inserted before the implicit cursor: a subsequent call to next would be
        // unaffected, and a subsequent call to previous would return the new element.
        // (This call increases by one the value that would be returned by a call to
        // nextIndex or previousIndex.)

        System.out.println(list);
    }
}
