import java.util.*;
import java.util.Map.Entry;

public class SortTreeMapByValue {
    public static void main(String args[]) {
        TreeMap<String, Integer> stockPrice = new TreeMap<String, Integer>();
        stockPrice.put("Oracle", 56);
        stockPrice.put("Fiserv", 117);
        stockPrice.put("BMW", 73);
        stockPrice.put("Microsoft", 28);
        stockPrice.put("Google", 421);
        stockPrice.put("Ford", 456);
        stockPrice.put("Novartis", 43);
        stockPrice.put("TCS", 23);

        // Print the original TreeMap
        System.out.println("Original stockPrices, sorted by key: " + stockPrice);

        // Get the EntrySet and store it in a TreeSet with custom comparator on Values
        TreeSet<Entry<String, Integer>> sortedStockPrices = new TreeSet<Entry<String, Integer>>(
                (es1, es2) -> es1.getValue() - es2.getValue());
        for (Entry<String, Integer> e : stockPrice.entrySet()) {
            sortedStockPrices.add(e);
        }
        System.out.println("Sorted stockPrices by Values: " + sortedStockPrices);

        // Note: We could also have stored all the keys in an ArrayList, and sorted the
        // list using a custom comparator.
    }
}
