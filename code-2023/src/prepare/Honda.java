package prepare;

public class Honda extends BikeClass implements Bike1, Bike2 {
//    int speedLimit = 150;

    public static void main(String[] args) {
        Honda bike = new Honda();
        System.out.println(BikeClass.add(12, 12));

        bike.start();

        bike.start1();

        System.out.println(bike.speedLimit);
    }

    public void start1() {
        System.out.println(" start() overridden.");
        Bike2.super.start();
        Bike1.super.start();
    }

    @Override
    public void start() {
        /*
            When 2 interface with same default method name is implemented by a class
            then we have to explicitly tell the compiler that default method of which
            interface is to be called in the overridden method otherwise it will show
            compile time error as:
            InterfaceName.super.methodName();
         */
        Bike1.super.start();
    }
}

class BikeClass {
    int speedLimit = 90;

    static int add(int a, int b) {
        return a + b;
    }

    static double add(double a, double b) {
        return a + b;
    }
}

interface Bike1 {

    //    int speedLimit = 30;
    default void start() {
        System.out.println(" start() in Bike1 interface.");
    }
}

interface Bike2 {
    //    int speedLimit = 40;
    default void start() {
        System.out.println(" start() in Bike2 interface.");
    }
}
