package design_pattern.creational.singleton;

public class SingletonLazyDoubleCheckInitialize {

    private static SingletonLazyDoubleCheckInitialize instance;

    private SingletonLazyDoubleCheckInitialize() {
        // Private constructor to restrict instantiation outside of class.
    }

    public static SingletonLazyDoubleCheckInitialize getInstance() {
        if (instance == null) {
            synchronized (SingletonLazyDoubleCheckInitialize.class) {
                if (instance == null) {
                    instance = new SingletonLazyDoubleCheckInitialize();
                }
            }
        }
        return instance;
    }

    public void simpleMethod(String msg) {
        System.out.println(msg);
    }
}
