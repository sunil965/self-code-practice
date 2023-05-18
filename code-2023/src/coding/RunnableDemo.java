package org.example;

public class RunnableDemo implements Runnable{
    @Override
    public void run() {
        System.out.println("Inside Run Method");
    }

    public static void main(String[] args) {
        RunnableDemo demo = new RunnableDemo();

        Thread t = new Thread(demo);
        t.start();

        try {
            int n = 1/0;
        }catch (ArithmeticException ae){
            System.out.println("Arithmetic Exception");
        }catch (Exception e){
            System.out.println("Exception Exception");
        }
    }
}
