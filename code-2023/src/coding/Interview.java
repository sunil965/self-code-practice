package org.example;


import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Interview {

    public static void main(String[] args) {

        String str = "Helloe";

        Optional<String> first = Arrays.stream(str.split("")).collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() > 1).map(Map.Entry::getKey).findFirst();
        System.out.println(first.isPresent() ? first.get() : Optional.empty());


        String str2 = "Sunil Kumar";
        Map<String, Integer> collect = Arrays.stream(str2.split(" ")).collect(Collectors.toMap(o -> o, String::length));
        System.out.println(collect);


    }
}




/*
class A{
  private static A a;

  private A(){

  }

  public synchronized A getInstance(){
	if(a == null){
	  a = new A();
        }
	return a;
   }

}
 */


/*
 List<String> list = List.of("A", "B", "A", "C");

        list.stream().collect(Collectors.groupingBy(s -> s, Collectors.counting())).forEach((s, aLong) -> {
            if (aLong > 1)
                System.out.println(s);
        });

        int[] arr = {1,3,2,7, 2, 2 ,2}; // 1,2,2,2,2,3,7

        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE, third = Integer.MIN_VALUE;
        for (int i = 0; i < ; i++) {

        }

        System.out.println(arr[2]);
 */