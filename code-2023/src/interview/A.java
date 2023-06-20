package interview;

public class A {
    public final void m1(String b) {
        System.out.println("m1-A");
    }
}

class B extends A {
//    public void m1(String b) {
//        System.out.println("m1-B");
//    }

    public static void main(String[] args) {
        B b = new B();
        b.m1( "");
    }
}
