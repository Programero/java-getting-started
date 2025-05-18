import java.util.*;
import java.util.Map.Entry;

//We are given a HashMap which contains stock data.

//Problem 1: Find the company with the highest stock price.

//Problem 2: Find the average stock price of all the companies

//Problem 3: Remove companies with stock price below 50

public class HashMapExercise {
    public static void main(String args[]) {
        Map<String, Integer> stockPrice = new HashMap<>();

        stockPrice.put("Oracle", 56);
        stockPrice.put("Fiserv", 117);
        stockPrice.put("BMW", 73);
        stockPrice.put("Microsoft", 213);
        stockPrice.put("Google", 421);
        stockPrice.put("Ford", 456);
        stockPrice.put("Novartis", 43);
        stockPrice.put("TCS", 23);

        // Find the company with the highest stock price
        Entry<String, Integer> esWithMaxPrice = null;
        for (Entry<String, Integer> es : stockPrice.entrySet()) {
            if (!(esWithMaxPrice != null && esWithMaxPrice.getValue() > es.getValue())) {
                esWithMaxPrice = es;
            }
        }
        System.out.println("Company with max StockPrice: " + esWithMaxPrice.getKey());

        // Find the average of stock prices
        int sum = 0;
        for (Entry<String, Integer> es : stockPrice.entrySet()) {
            sum = sum + es.getValue();
        }

        System.out.println("Average of Stock Prices: " + sum / stockPrice.size());

        // Remove companies with stock price below 50
        for (Entry<String, Integer> es : stockPrice.entrySet()) {
            if (es.getValue() < 50) {
                // stockPrice.remove(es.getKey()); if we try to do this, we get
                // ConcurrentModificationException, as we cannot remove element directly from
                // hashmap while
                // iterating
            }
        }
        // Iterating using an Iterator over entrySet
        Iterator<Entry<String, Integer>> itr = stockPrice.entrySet().iterator();
        while (itr.hasNext()) {
            Entry<String, Integer> entry = itr.next();
            if (entry.getValue() < 50) {
                itr.remove(); // Removing an Entry from the EntrySet, removes the Entry from the HashMap as well.
            }
        }
        System.out.println("Stock Prices after removing all the companies with stock price < 50: " + stockPrice);

    }
}
