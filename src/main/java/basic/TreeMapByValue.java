package basic;

import java.util.*;
import java.util.stream.Collectors;

public class TreeMapByValue {
    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(1, "Banana");
        map.put(3, "Apple");
        map.put(5, "Orange");
        map.put(2, "Grape");

        // Convert to a list of entries
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        entries.stream().sorted(Comparator.comparing(Map.Entry::getValue)).forEach(System.out::println);

//        map.entrySet()
//                .stream()
//                .sorted(Map.Entry.comparingByValue());
//        // Print sorted entries by value
//        for (Map.Entry<Integer, String> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + " = " + entry.getValue());
//        }
        Map<Integer,String> sorted =
                map.entrySet()
                        .stream()
                        .sorted(Comparator.comparing(Map.Entry::getValue))
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (a,b)->a,
                                LinkedHashMap::new
                        ));
        for (Map.Entry<Integer, String> entry : sorted.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
        System.out.println("*****");


        List<Map.Entry<Integer, String>> list = new ArrayList<>(entries);

        // Sort list by values
        list.sort(Map.Entry.comparingByValue());

        // Print sorted entries by value
        for (Map.Entry<Integer, String> entry : list) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}