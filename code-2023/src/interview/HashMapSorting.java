package interview;

import java.util.*;
import java.util.stream.Collectors;

public class HashMapSorting {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();

        map.put("one", 1);
        map.put("two", 2);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);

        // Sort by key
        LinkedHashMap<String, Integer> collected = map.entrySet().stream().sorted((o1, o2) -> o1.getKey().compareTo(o2.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (integer, integer2) -> integer, LinkedHashMap::new));

        System.out.println(collected);

        // Question 1: Sort Hashmap based on its value.
        HashMap<String, Integer> hm = new HashMap<>();

        // enter data into hashmap
        hm.put("Math", 98);
        hm.put("Data Structure", 85);
        hm.put("Database", 91);
        hm.put("Java", 95);
        hm.put("Operating System", 79);
        hm.put("Networking", 80);
        sortByValue(hm);


        // Question 2
        int[] array = {3, 4, 1, 2, 5};

        Set<Integer> set = new HashSet<>();
        for (int i : array) {
            set.add(i);
        }
        System.out.println("Sorted set with elements of array: " + set);

        System.out.println(set.toArray()[set.size() - 2]);

    }

    private static void sortByValue(HashMap<String, Integer> map) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        // Sorting by Comparator
        list.sort(new Comparator<>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        // Sorting via Lambda.
        // list.sort((o1, o2) -> o1.getValue().compareTo(o2.getValue()));

        // put data from sorted list to hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            temp.put(entry.getKey(), entry.getValue());
        }

        // print the sorted hashmap
        System.out.println("Sorted HashMap Using comparator:" + temp);


        // Via Stream API
        LinkedHashMap<String, Integer> linkedHashMap = map.entrySet().stream().sorted((o1, o2) -> o1.getValue().compareTo(o2.getValue())).collect(Collectors.toMap(
                Map.Entry::getKey, Map.Entry::getValue, (integer, integer2) -> integer, LinkedHashMap::new
        ));
        System.out.println("Sorted HashMap Using Stream API:" + linkedHashMap);
    }

}
