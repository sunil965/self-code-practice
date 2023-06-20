package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Delta {

    public static void main(String[] args) {
        List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 8, 98, 2, 15);
        Map<Integer, List<Integer>> collect = myList.stream().collect(Collectors.groupingBy(o -> o));
        System.out.println(collect);
        System.out.println("********* Via Stream Find All **********");

        myList.stream().collect(Collectors.groupingBy(o -> o, Collectors.counting())).forEach((integer, aLong) -> {
            if (aLong > 1)
                System.out.println(integer);
        });

        /*myList.stream().collect(Collectors.groupingBy(o -> o, Collectors.counting()))
                .entrySet().stream().filter(integerLongEntry -> integerLongEntry.getValue() > 1)
                .map(Map.Entry::getKey).forEach(System.out::println);*/

        System.out.println("********* Via Map Find All **********");
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : myList) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        Set<Integer> set = map.keySet();
        for (int i : set) {
            if (map.get(i) > 1)
                System.out.println(i);
        }

        System.out.println("********* Via Stream Find first **********");

        Integer integer = myList.stream().collect(Collectors.groupingBy(o -> o, Collectors.counting()))
                .entrySet().stream().filter(integerLongEntry -> integerLongEntry.getValue() > 1)
                .map(Map.Entry::getKey).findFirst().get();

        System.out.println(integer);
    }
}
