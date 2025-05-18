
import java.util.HashSet;

public class HashSetExercise {
    public static void main(String args[]) {
        int[] arr = { 12, 34, 1, 56, 43, 34, 65 };

        // Find the duplicate element
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i : arr) {
            if (set.contains(i)) {
                System.out.println("Duplicate ELement: " + i);
            }
            set.add(i);
        }

        System.out.println("Unique Elements in the set, with random order: " + set);
    }
}