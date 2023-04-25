package prepare;

public class GuessOutput2 {
    public static void main(String[] args) {
        System.out.println("----- Parent Reference Child Object -----");

        Parent p = new Child();
        p.show();  // Answer - Inside Child show
        p.show1(); // Answer - Inside Parent show1
        //  p.display(); //Answer – Compile time error= "Cannot resolve method 'display' in 'Parent'". As reference is of Parent & display() is of child.
        System.out.println(p.x); //Answer – 10; Variables do not take part in inheritance

        System.out.println("----- Child Reference Child Object -----");

        Child c = new Child();
        c.show();  // Answer - Inside Child show
        c.show1(); // Answer - Inside Parent show1
        c.display(); // Answer – Inside child display
        System.out.println(c.x); //Answer – 20; Variables do not take part in inheritance
    }
}

class Parent {
    int x = 10;

    public void show() {
        System.out.println("Inside Parent show");
    }

    public void show1() {
        System.out.println("Inside Parent show1");
    }
}

class Child extends Parent {
    int x = 20;

    @Override
    public void show() {
        System.out.println("Inside Child show");
    }

    public void display() {
        System.out.println("Inside child display");
    }
}
