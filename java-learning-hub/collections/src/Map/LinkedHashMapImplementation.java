package Map;

import java.util.LinkedHashMap;

public class LinkedHashMapImplementation {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("product2", 100);
        linkedHashMap.put("product9", 200);
        linkedHashMap.put("product1", 300);
        linkedHashMap.put("product3", 400);
        linkedHashMap.put("product6", 500);
        linkedHashMap.put("product4", 600);
        linkedHashMap.put("product5", 700);
        linkedHashMap.put("product10", 800);
        linkedHashMap.put("product8", 900);
        linkedHashMap.put("product7", 999);
        System.out.println("GET or default: " + linkedHashMap.getOrDefault("product5", 0)); //The above is avoid null values.
        System.out.println(linkedHashMap.get("product55")); // this returns null
        System.out.println(linkedHashMap.put("product5", linkedHashMap.get("product5")));
        linkedHashMap.forEach((k, v) -> System.out.println(k + " , " + v));
    }
}
