package concurrent;

import java.util.LinkedList;

public class ProducerConsumerDemo {

    public static void main(String[] args) throws InterruptedException {
        // Object of a class that has both produce() and consume() methods.
        Job job = new Job();

        Thread thread1 = new Thread(() -> {
            try {
                job.produces();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                job.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
    public static class Job {
        int capacity = 10;
        LinkedList<Integer> list = new LinkedList<>();

        public void produces() throws InterruptedException {
            int value = 0;

            while (true){
                synchronized (this){
                    // producer thread waits while list is full.
                    while (list.size() == capacity)
                        wait();

                    System.out.println("Producer produced: "+value);

                    // to insert the jobs in the list
                    list.add(value++);
                    // notifies the consumer thread that now it can start consuming
                    notify();
                    // makes the working of program easier to  understand
                    Thread.sleep(1000);
                }
            }
        }

        public void consume() throws InterruptedException{
            while (true){
                synchronized (this){
                    while (list.size()==0)
                        wait();
                    // to retrieve the first job in the list
                    System.out.println("Consumer consumed: "+list.removeFirst());
                    // Wake up producer thread
                    notify();

                    Thread.sleep(1000);
                }
            }
        }
    }
}
