package interview.Cars24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

interface Sound {
    void say();
}

interface Sayable {
    void say();
}


public class Cars24Round1 {

//    String inverter,spring order.

    public void saySomething() {
        System.out.println("Hello, this is a non-static method.");
    }


    public static void main(String[] args) {
        // Implement Interface via Lambda
        Sound say = () -> System.out.println("Say method of Sound interface");
        say.say();

        // Method Reference to an Instance Method
        Cars24Round1 cars24Round1 = new Cars24Round1();
        Sayable sayable = cars24Round1::saySomething;
        sayable.say(); // If we don't run this line then cars24Round1::saySomething will not get executed.

        System.out.println();

        var a = "ab";
        var b = "ab";
        System.out.println(a == b);
        System.out.println(a.equals(b));

        var c = new String("cd");
        var d = new String("cd");
        System.out.println(c == d);
        System.out.println(c.equals(d));

        List<String> stringList = new ArrayList<>();
        stringList.add("abc");
        stringList.add("abc");
        stringList.add("abcdef");
        stringList.add("abc-ghi");
        stringList.add("abc12");

        String str = "Hi press 'ctrl+alt+v' shortcut to assign a variable to hold value returned from method";
        String changedString = Arrays.stream(str.split("\\s+")).map(s -> s.substring(0, 1).toUpperCase() + s.substring(1)).collect(Collectors.joining(" "));
        System.out.println(changedString);

        List<String> toListInStream = stringList.stream().filter(u -> u.length() > 5).toList();
        System.out.println(toListInStream);

        List<Integer> mapInStream = stringList.stream().map(String::length).filter(length -> length <= 5).collect(Collectors.toList());
        System.out.println(mapInStream);

        System.out.println("Main thread started");

       /* Runnable runnable = () -> {
            System.out.println("Using Lambda to define runnable interface's run().");
        };*/
        Runnable runnable = () ->
            System.out.println("Using Lambda to define runnable interface's run().");
        Thread thread = new Thread(runnable);
        thread.start();

        System.out.println("Main thread ended.");

    }
}
