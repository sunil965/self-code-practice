package design_pattern.creational.singleton;

public class SingletonEagerInitialize {

    private static final SingletonEagerInitialize instance = new SingletonEagerInitialize();

    private SingletonEagerInitialize(){
        // Private constructor to restrict instantiation outside of class.
    }

    public static SingletonEagerInitialize getInstance(){
        return instance;
    }

    public void simpleMethod(String msg) {
        System.out.println(msg);
    }

}
