import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Iterator;

public class LinkedHashSetExercise {
    public static void main(String[] args) {
        // Create a LinkedHashSet
        Set<String> linkedHashSet = new LinkedHashSet<>();

        // Add elements to the LinkedHashSet
        linkedHashSet.add("Apple");
        linkedHashSet.add("Banana");
        linkedHashSet.add("Cherry");
        linkedHashSet.add("Date");
        linkedHashSet.add("Elderberry");

        // Display the elements in the LinkedHashSet
        System.out.println("LinkedHashSet: " + linkedHashSet);

        // Remove an element from the LinkedHashSet
        linkedHashSet.remove("Cherry");

        // Display the elements after removal
        System.out.println("After removing 'Cherry': " + linkedHashSet);

        // Check if an element exists in the LinkedHashSet
        boolean containsApple = linkedHashSet.contains("Apple");
        System.out.println("Contains 'Apple': " + containsApple);

        // Iterate through the elements in the LinkedHashSet
        System.out.print("Iterating through elements: ");
        Iterator<String> iterator = linkedHashSet.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}