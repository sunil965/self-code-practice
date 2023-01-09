package prepare;

public class PrintingTask2 implements Runnable{
    static Integer num = 1;
    public void run(){
        while(num < 11){
            synchronized(num){
                System.out.println(Thread.currentThread().getName() + "->" +num);
                num++;
            }
            try{
                Thread.sleep(100);
            }catch(InterruptedException e){
                return;
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        PrintingTask2 a1 = new PrintingTask2();
        PrintingTask2 a2 = new PrintingTask2();
        PrintingTask2 a3 = new PrintingTask2();
        Thread t1 = new Thread(a1);
        Thread t2 = new Thread(a2);
        Thread t3 = new Thread(a3);
        t1.start();
        t2.start();
        t3.start();
        t1.join();
    }
}
