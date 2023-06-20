package interview.morgan;

class myThread implements Runnable {

    @Override
    public void run() {
        Test.obj.notify();
    }
}

public class Test implements Runnable {

    public static Test obj;
    private int data;

    public Test() {
        data = 10;
    }

    @Override
    public void run() {
        obj = new Test();
//        obj.wait();
        obj.data += 20;
        System.out.println(obj.data);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Test());
        Thread thread2 = new Thread(new myThread());

        thread1.start();
        thread2.start();

        System.out.println(" DRM - ");
    }
}
