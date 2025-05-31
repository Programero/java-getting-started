import java.util.ArrayList;
import java.util.Iterator;

public class Iteration {
    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(10);
        list.add(20);
        list.add(50);
        list.add(40);

        Iterator<Integer> itr = list.iterator();

        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        // Iteration using forEachRemaining
        itr = list.iterator();
        itr.forEachRemaining((ele) -> System.out.println(ele));

        // Removing an element while Iterating
        itr = list.iterator();

        while (itr.hasNext()) {
            if (itr.next() == 20) {
                itr.remove();
            }

            // list.add(60);
            // Note that while iterating using iterator we cannot do list.add(E e) or
            // list.set(int index, E e), that will throw a
            // java.util.ConcurrentModificationException exception
        }

        System.out.println(list);
    }
}
