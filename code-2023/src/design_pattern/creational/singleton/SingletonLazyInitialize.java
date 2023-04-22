package design_pattern.creational.singleton;

public class SingletonLazyInitialize {

    private static SingletonLazyInitialize instance;

    private SingletonLazyInitialize() {
        // Private constructor to restrict instantiation outside of class.
    }

    public static synchronized SingletonLazyInitialize getInstance() {
        if (instance == null)
            instance = new SingletonLazyInitialize();

        return instance;
    }

    public void simpleMethod(String msg) {
        System.out.println(msg);
    }
}
