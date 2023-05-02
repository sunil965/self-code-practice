package interview;

import java.util.*;

public class EYTech {

    public static void main(String[] args) {

        // Question 1
        printSecondHeistNumberInArray();


        // Question 2
        groupAnagramStringsOfAnArray();


        // Question 3
        List<Employee> list = List.of(new Employee("Sunil", 150000), new Employee("Anil", 25000), new Employee("Sachin", 25000));
        System.out.println(list);

        List<Employee> list1 = list.stream().filter(e-> "s".equalsIgnoreCase(e.getName().substring(0,1)) && e.getSalary() >25000).toList();
        System.out.println(list1);

    }

    private static void groupAnagramStringsOfAnArray() {
        String[] strings = {"cat", "dog", "tac", "god", "act"};
        //OP: [dog, god][cat, tac, act]

        HashMap<String, List<String>> map = getStringListHashMap(strings);

        usingHashMapAsKey(strings);

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            System.out.print(entry.getValue());
        }
        System.out.println();
    }

    private static void usingHashMapAsKey(String[] strings) {
        Map<HashMap<Character, Integer>, List<String>> map = new HashMap<>();
        for (String st : strings) {
            HashMap<Character, Integer> temp = new HashMap<>();
            for (char c : st.toCharArray()) {
                temp.put(c, temp.getOrDefault(c, 0) + 1);
            }

            if (map.containsKey(temp))
                map.get(temp).add(st);
            else {
                List<String> list = new ArrayList<>();
                list.add(st);
                map.put(temp, list);
            }
        }

        for (Map.Entry<HashMap<Character, Integer>, List<String>> entry : map.entrySet()) {
            System.out.print(entry.getValue());
        }
        System.out.println();
    }

    private static HashMap<String, List<String>> getStringListHashMap(String[] strings) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strings) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String temp = new String(c);

            if (map.containsKey(temp))
                map.get(temp).add(str);
            else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(temp, list);
            }
        }
        return map;
    }

    private static void printSecondHeistNumberInArray() {
        int[] arr = {3, 5, 7, 8, 2, 9, 5, 4, 10};
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;

        for (int i : arr) {
            if (i > first) {
                second = first;
                first = i;
            } else if (i > second && i != first) {
                second = i;
            }
        }

        System.out.println("second max in array: " + second);
    }

}

class Employee {
    String name;
    int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" + name + ", " + salary + '}';
    }
}
