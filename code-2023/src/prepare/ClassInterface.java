package prepare;
interface A {
    void show();
}
interface B extends A {
    void sqrt(int x);
}
public class ClassInterface implements B {
    @Override
    public void show() {
        System.out.print("Output : ");
    }

    public void sqrt(int x) {
        System.out.print(x * x);
    }
}
class Practice {
    public static void main(String[] args) {
        ClassInterface classObject = new ClassInterface();
        classObject.show();
        classObject.sqrt(2);
    }
}