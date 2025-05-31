import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class TreeSetExercise {
    public static void main(String args[]) {
        // Find all Numbers greater than 50
        Integer[] numbers = { 1, 4, 5, 2, 34, 66, 5, 4, 33, 45, 6, 8, 56, 76, 78, 98, 34, 37, 12, 12, 23, 43, 54, 56 };
        List<Integer> numbersList = new ArrayList<Integer>(Arrays.asList(numbers));
        TreeSet<Integer> tSet = new TreeSet<Integer>(numbersList); // Keep the elements in sorted order, as per the implementation of compareTo method of Integer class

        // tailSet can be used to get elements greater than a particular element
        System.out.println(tSet.tailSet(50));

        // Smallest and largest number in array
        System.out.println("Smallest number in numbers array: " + tSet.first());

        System.out.println("Largest number in numbers array: " + tSet.last());
    }
}
