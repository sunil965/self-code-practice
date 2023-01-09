package prepare;

import java.io.PrintStream;

public class PrintingTask implements Runnable {
    private final PrintStream stream;
    private final int first;
    private final int last;
    private final int thread;

    @Override
    public void run() {
        for (int i = this.first; i <= this.last; i += this.thread) {
            synchronized (this.stream) {
                this.stream.println(Thread.currentThread().getName() + " " + i);
            }
            try {
                Thread.sleep(100);
            } catch (final InterruptedException e) {
                return;
            }
        }
    }

    public PrintingTask(PrintStream stream, int first, int last, int thread) {
        this.stream = stream;
        this.first = first;
        this.last = last;
        this.thread = thread;
    }

    public static void main(String[] args) throws InterruptedException {
        final int nthreads = 3;
        final Thread[] workers = new Thread[nthreads];
        for (int i = 0; i < nthreads; ++i) {
            workers[i] = new Thread(new PrintingTask(System.out, i + 1, 10, nthreads));
            workers[i].setName("Thread-" + i);
        }
        for (final Thread t : workers) {
            t.start();
        }
        for (final Thread t : workers) {
            t.join();
        }
    }
}
