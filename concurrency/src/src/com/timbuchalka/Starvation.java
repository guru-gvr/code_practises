package src.com.timbuchalka;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class Starvation {
    private static ReentrantLock lock = new ReentrantLock(true);

    public static void main(String[] args) {
        Thread t1 = new Thread(new Worker(ThreadColor.ANSI_RED), "Priority 10");
        Thread t2 = new Thread(new Worker(ThreadColor.ANSI_BLUE), "Priority 8");
        Thread t3 = new Thread(new Worker(ThreadColor.ANSI_GREEN), "Priority 6");
        Thread t4 = new Thread(new Worker(ThreadColor.ANSI_CYAN), "Priority 4");
        Thread t5 = new Thread(new Worker(ThreadColor.ANSI_PURPLE), "Priority 2");

        t1.setPriority(10);
        t2.setPriority(8);
        t3.setPriority(6);
        t4.setPriority(4);
        t5.setPriority(2);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();


    }

    private static class Worker implements Runnable {
        private AtomicInteger runCount = new AtomicInteger();
        private int runCountInt;
        private String threadColor;

        public Worker(String threadColor) {
            this.threadColor = threadColor;
        }

        @Override
        public void run() {
            for(int i=0; i<5; i++) {
               lock.lock();
                try {
                    runCount.addAndGet(1);
                    runCountInt++;
                    System.out.format(threadColor + "%s: runCount = %d  runCOuntInt = %d \n", Thread.currentThread().getName(), (runCount.get()),runCountInt);
                    // execute critical section of code
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
