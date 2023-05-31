import java.util.LinkedList;
import java.util.Comparator;
import java.util.Iterator;

public class LinkedListUsage {
    public static void main(String args[]) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(20);
        list.add(30);
        list.add(10);
        list.add(50);

        for (int i : list) {
            System.out.println(i);
        }

        // Sorting the LinkedList using list.Sort
        list.sort(Comparator.naturalOrder());

        // Using iterator for iterating
        Iterator<Integer> itr = list.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        // Iterating LinkedList using next and prev Node references
        // Answer: We cannot do so: You do not have access to the "Node" that the
        // java.util.LinkedList class uses in its implementation. So, we cannot get the
        // reference to the head Node element

    }
}
