import java.util.List;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListExamples {
    public static void main(String args[]) {
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        // Created an iterator
        Iterator<String> itr = list.iterator();

        while (itr.hasNext()) {
            System.out.println(itr.next());
            list.remove("Orange");
        }
        System.out.println("Again creating the iterator");
        // Created an iterator
        itr = list.iterator();

        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

    }
}
