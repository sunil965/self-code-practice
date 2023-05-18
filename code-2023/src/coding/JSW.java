package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JSW {

    public static void main(String[] args) {
        String[] names = {"Sam", "Pamela", "Dave", "Pascal", "Erik"};
        List<String> collect = Arrays.stream(names, 2, names.length).toList();
        System.out.println(collect);

        String str = "Hi Sunil I am from Bangalore";

        String[] strings = str.split(" ");
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        System.out.println(Arrays.toString(strings));
        System.out.println(strings[strings.length-2]);


    }
}

/*
interface Sum {
 int add( int a, int b);
}

class Test{

    psvm(String[] args){
	Sum sum = (a,b) -> a+b;
	sum.add(2,3);
    }
}

list.stream().filter(e -> e.getSalary()> 25000).sorted((o1, o2) -> o2.getName().compareTo(o1.getName())).mapToObj(e -> e.getName()).collect(Collectors.toList());

 */