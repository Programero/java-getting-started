import java.util.LinkedHashMap;

public class LinkedHashMapExample {
    public static void main(String args[]) {

        LinkedHashMap<String, Integer> stocks = new LinkedHashMap<>();

        stocks.put("Apple", 123);
        stocks.put("BMW", 54);
        stocks.put("Google", 87);
        stocks.put("Microsoft", 232);
        stocks.put("Oracle", 76);

        stocks.get("Google");
        stocks.get("BMW");
        System.out.println("With access order: false: " + stocks); // with access order: false

        LinkedHashMap<String, Integer> stocksWithAccessOrder = new LinkedHashMap<>(16, 0.75f, true);

        stocksWithAccessOrder.put("Apple", 123);
        stocksWithAccessOrder.put("BMW", 54);
        stocksWithAccessOrder.put("Google", 87);
        stocksWithAccessOrder.put("Microsoft", 232);
        stocksWithAccessOrder.put("Oracle", 76);

        System.out.println("Before fetching any element: " + stocksWithAccessOrder);
        stocksWithAccessOrder.get("Google");
        stocksWithAccessOrder.get("BMW");

        System.out.println("With access order: true: " + stocksWithAccessOrder);
    }
}
