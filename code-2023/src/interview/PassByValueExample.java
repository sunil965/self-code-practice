package interview;

public class PassByValueExample {
    public static void main(String[] args) {
        int x = 10;
        modifyPrimitive(x);
        System.out.println("Value of x after modifyPrimitive: " + x); // Output: 10

        StringBuilder sb = new StringBuilder("Hello");
        modifyObject(sb);
        System.out.println("Value of sb after modifyObject: " + sb); // Output: HelloWorld
    }

    public static void modifyPrimitive(int value) {
        value = 20;
    }

    public static void modifyObject(StringBuilder value) {
        value.append("World");
    }
}
