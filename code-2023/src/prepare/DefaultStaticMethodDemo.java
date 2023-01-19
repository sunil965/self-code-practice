package prepare;

import java.util.Arrays;
import java.util.List;

interface TestDefaultStaticMethodInterface {
    // default method, it can be overridden in Implementing class if needed not mandatory.
    default void show() {
        System.out.println("Default show() method from TestDefaultStaticMethodInterface");
        System.out.println();
    }

    // static method, it can't be overridden in Implementing class.
    static void hello() {
        System.out.println("Hello, New Static hello() Method Here");
        System.out.println();
    }

    // Public and abstract method of Interface
    void overrideMethod(String str);
}

interface TestInterface2 {
    // Default method
    default void show() {
        System.out.println("Default method from TestInterface2");
        System.out.println();
    }
}

public class DefaultStaticMethodDemo implements TestDefaultStaticMethodInterface/*, TestInterface2*/ {
    /*
     In case we have two interfaces and both the implemented interfaces contain default methods with same
     method signature, the implementing class should explicitly specify which default method is to be used,
     or it should override the default method.
     */

   /* @Override
        public void show() {
            System.out.println("Overriding default method of interface in implementing class to specify which default method is to be used.");
            // use super keyword to call the show method of TestDefaultStaticMethodInterface interface
            TestDefaultStaticMethodInterface.super.show();

            // use super keyword to call the show method of TestInterface2 interface
            TestInterface2.super.show();
            System.out.println();
        }
    */

    @Override
    public void overrideMethod(String str) {
        System.out.println(str);
        System.out.println();
    }

    /*
      The scope of the static method definition is within the interface only. If same name method is implemented
       in the implementation class then that method becomes a static member of that respective class.

        static void hello(){
            System.out.println("Called from Class");
        }
        And from main method we have to call it as:
        hello();
     */

    public static void main(String[] args) {

        DefaultStaticMethodDemo defaultStaticMethodDemo = new DefaultStaticMethodDemo();
        defaultStaticMethodDemo.show();
        defaultStaticMethodDemo.overrideMethod("Public and abstract method of Interface to be defined in implementing class");

        // Calling the static method of interface
        TestDefaultStaticMethodInterface.hello();

        List<String> lines = Arrays.asList("ab,12,bd", "df,23,df", "ef,98,dg");
        System.out.println(lines);

        List<String> integers = lines.stream().map(s -> String.valueOf(Integer.parseInt(s.substring(3, 5)) * 2)).toList();
        System.out.println(Arrays.toString(integers.toArray()));
    }
}
