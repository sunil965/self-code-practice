package P;
interface A {
    void show();
}
interface B extends A {
    void sqrt(int x);
}
public class P implements B {
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
        P pract = new P();
        pract.show();
        pract.sqrt(2);
    }
}