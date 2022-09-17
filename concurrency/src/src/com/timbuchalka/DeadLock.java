package src.com.timbuchalka;

public class DeadLock {
    public static Object lock1 = new Object();
    public static Object lock2 = new Object();

    public static void main(String[] args) {
    Thread1 thread1 = new Thread1();
    thread1.start();
        Thread2 thread2 = new Thread2();
        thread2.start();
    }

    private static class Thread1 extends Thread {
        public void run() {
            synchronized (lock1) {
                try {
                    System.out.println("Thread 1 has lock1 ");
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println("exception " + e);
                }
                System.out.println("Thread 1 waiting for  lock 2");
                synchronized (lock2) {
                    System.out.println("Thread 1 has both lock 1 and lock 2");
                }
                System.out.println("Thread 1 released lock 2");
            }
            System.out.println("Thread 1 released lock 1");
        }

    }

    private static class Thread2 extends Thread {
        public void run() {
            synchronized (lock2) {
                try {
                    System.out.println("Thread 2 has lock2 ");
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println("exception " + e);
                }
                System.out.println("Thread 2 waiting for  lock 1");
                synchronized (lock1) {
                    System.out.println("Thread 2 has both lock 2 and lock 1");
                }
                System.out.println("Thread 2 released lock 1");
            }
            System.out.println("Thread 2 released lock 2");
        }

    }


}
