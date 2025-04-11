package Map;

import java.util.HashMap;

public class HashMapImplementation {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("product2", 100);
        hashMap.put("product9", 200);
        hashMap.put("product1", 300);
        hashMap.put("product3", 400);
        hashMap.put("product6", 500);
        hashMap.put("product4", 600);
        hashMap.put("product5", 700);
        hashMap.put("product10", 800);
        hashMap.put("product8", 900);
        hashMap.put("product7", 999);
        System.out.println("GET or default: " + hashMap.getOrDefault("product5", 0)); //The above is avoid null values.
        System.out.println(hashMap.get("product55")); // this returns null
        System.out.println(hashMap.put("product5", hashMap.get("product5")));
        hashMap.forEach((k, v) -> System.out.println(k + " , " + v));

    }
}
