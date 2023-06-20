package org.example;

public class OverrideDemo {

    public void show(Object o){
        System.out.println("Object parameter");
    }
//    public void show(String  o){
//        System.out.println("String parameter");
//    }
//    public void show(Integer o){
//        System.out.println("Integer parameter");
//    }
//
//    public static void main(String[] args) {
//        OverrideDemo demo = new OverrideDemo();
//        demo.show(null);
//    }
}
class Two {
    public void show(Object o){
        System.out.println("Parent class");
    }
}
class Three extends Two{
    public void show(Object o){
        System.out.println("Child Class");
    }

    public static void main(String[] args) {
        Two objRef = new Three();
        objRef.show(null);

    }
}