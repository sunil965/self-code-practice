package design_pattern.creational.singleton;

public class MainMethod {

    public static void main(String[] args) {
        SingletonLazyInitialize instance1 = SingletonLazyInitialize.getInstance();
        SingletonLazyInitialize instance2 = SingletonLazyInitialize.getInstance();
        System.out.println(instance1 == instance2);
        instance1.simpleMethod("Singleton with lazy initialization.");

        SingletonEagerInitialize eagerInitialize = SingletonEagerInitialize.getInstance();
        eagerInitialize.simpleMethod("Singleton with eager initialization.");

        SingletonLazyDoubleCheckInitialize lazyDoubleCheckInitialize = SingletonLazyDoubleCheckInitialize.getInstance();
        lazyDoubleCheckInitialize.simpleMethod("Singleton with double check initialization.");

        SingletonViaStaticInitialization staticInitialization = SingletonViaStaticInitialization.getINSTANCE();
        staticInitialization.simpleMethod("Singleton with Static initialization.");
    }
}
