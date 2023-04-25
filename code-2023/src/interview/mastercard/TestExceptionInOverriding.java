package interview.mastercard;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TestExceptionInOverriding {
    public int id;
    public String name;

    public void shareScreen() throws IOException {
        System.out.println("Parent class's shareScreen()");
    }

    public void writeLogic() {
        System.out.println("Parent class's writeLogic()");
    }
}

class TestExceptionInOverridingExt extends TestExceptionInOverriding {

    /*
        Inheritance is an IS-A relationship where a class inherit property of another class.

        Example of HAS-A relation also known as Composition in Java.
        When we create instance of Laptop inside Child1 with new keyword as below it is said to
        be HAS-A relation also known as Composition in Java.
        Laptop laptop = new Laptop();
     */

    public static void main(String[] args) throws FileNotFoundException, DisplayInterruptException {
        TestExceptionInOverridingExt child1 = new TestExceptionInOverridingExt();
        child1.shareScreen();
        child1.writeLogic();
    }

    /*
        If a method of Parent class is overridden in Child class and both the method are throwing Exception
        then the overridden method in Child class can only throw those Exceptions which comes under the hierarchy of
        Exception thrown by Parent class method.
     */
    public void shareScreen() throws FileNotFoundException {
        System.out.println("Child class's shareScreen()");
    }

    public void writeLogic() {
        System.out.println("Child class's writeLogic()");
        super.writeLogic();
    }

}

// Defining custom Checked Exception
class DisplayInterruptException extends Exception {
    public DisplayInterruptException(String s) {
        super(s);
    }
}
