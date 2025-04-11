package Map;

import java.util.Comparator;
import java.util.TreeMap;

public class TreeMapImplementation {
    public static void main(String[] args) {

        Comparator<String> sortByKeyAsc = (o1, o2) -> {
            int n1 = Integer.parseInt(o1.replaceAll("[^0-9]", ""));
            int n2 = Integer.parseInt(o2.replaceAll("[^0-9]", ""));
            return Integer.compare(n1, n2);
        };

        Comparator<String> sortByKeyDesc = (o1, o2) -> {
            int n1 = Integer.parseInt(o1.replaceAll("[^0-9]", ""));
            int n2 = Integer.parseInt(o2.replaceAll("[^0-9]", ""));
            return Integer.compare(n2, n1);
        };

        Comparator<Integer> sortByAge = (o1, o2) -> {
            System.out.println(o1 + " , " + o2);
            System.out.println(o1 - o2);
            System.out.println(Integer.compare(o1, o2));
            return Integer.compare(o1, o2);
        };
        System.out.println("---------------WITHOUT COMPARATOR -NATURAL ORDER-----------------");
        TreeMap<String, Integer> withoutComparator = new TreeMap<>();
        withoutComparator.put("product2", 100);
        withoutComparator.put("product9", 200);
        withoutComparator.put("product1", 300);
        withoutComparator.put("product3", 400);
        withoutComparator.put("product6", 500);
        withoutComparator.put("product4", 600);
        withoutComparator.put("product5", 700);
        withoutComparator.put("product10", 800);
        withoutComparator.put("product8", 900);
        withoutComparator.put("product7", 999);
        withoutComparator.forEach((k, v) -> System.out.println(k + " , " + v));
        System.out.println("---------------SORT by Key asc-----------------");
        TreeMap<String, Integer> treeMap = new TreeMap<>(sortByKeyAsc);
        treeMap.put("product2", 100);
        treeMap.put("product9", 200);
        treeMap.put("product1", 300);
        treeMap.put("product3", 400);
        treeMap.put("product6", 500);
        treeMap.put("product4", 600);
        treeMap.put("product5", 700);
        treeMap.put("product10", 800);
        treeMap.put("product8", 900);
        treeMap.put("product7", 999);
        treeMap.forEach((k, v) -> System.out.println(k + " , " + v));
        System.out.println("---------------SORT by Key desc-----------------");
        TreeMap<String, Integer> treeMap1 = new TreeMap<>(sortByKeyDesc);
        treeMap1.put("product2", 100);
        treeMap1.put("product9", 200);
        treeMap1.put("product1", 300);
        treeMap1.put("product3", 400);
        treeMap1.put("product6", 500);
        treeMap1.put("product4", 600);
        treeMap1.put("product5", 700);
        treeMap1.put("product10", 800);
        treeMap1.put("product8", 900);
        treeMap1.put("product7", 999);
        treeMap1.forEach((k, v) -> System.out.println(k + " , " + v));
        System.out.println("---------------SORT by AGE asc-----------------");
        TreeMap<Integer, Integer> ageCheck = new TreeMap<>(sortByAge);
        ageCheck.put(45, 1000000);
        ageCheck.put(25, 100000);
        ageCheck.put(35, 500000);
        ageCheck.forEach((k, v) -> System.out.println(k + " , " + v));
    }
}
