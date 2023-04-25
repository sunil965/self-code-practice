package prepare;

public class GuessOutput1 {
    void print(double i, int j) {
        System.out.println("This is meth1");
    }

    void print(int i, double j) {
        System.out.println("This is meth2");
    }

    /**
     * If we call t.print(10, 10);
     * Then Compile time error, compiler fails to decide which to call.
     * This is also called ambiguity issue.
     * */
    public static void main(String[] args) {
        GuessOutput1 t = new GuessOutput1();
        t.print(10d, 10); // Invoke 1st print method.
        t.print(10, 10d); // Invoke 2nd print method.
    }
}
