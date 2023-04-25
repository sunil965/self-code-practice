package design_pattern.creational.singleton;

public class SingletonViaStaticInitialization {

    private static final SingletonViaStaticInitialization INSTANCE;

    static {
        try {
            INSTANCE = new SingletonViaStaticInitialization();
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize");
        }
    }

    public static SingletonViaStaticInitialization getINSTANCE() {
        return INSTANCE;
    }

    public void simpleMethod(String msg) {
        System.out.println(msg);
    }
}
