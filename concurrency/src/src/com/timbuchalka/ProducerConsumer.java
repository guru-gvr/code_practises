package src.com.timbuchalka;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;


public class ProducerConsumer {
    public static final String EOF = "EOF";

    public static void main(String[] args) {
        List<String> buffer = new ArrayList<>();
        ReentrantLock reentrantLock = new ReentrantLock();
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        MyProducer producer = new MyProducer(buffer, ThreadColor.ANSI_YELLOW,reentrantLock);
        MyConsumer consumer1 = new MyConsumer(buffer, ThreadColor.ANSI_PURPLE,reentrantLock);
        MyConsumer consumer2 = new MyConsumer(buffer, ThreadColor.ANSI_CYAN,reentrantLock);

        executorService.execute(producer);
        executorService.execute(consumer1);
        executorService.execute(consumer2);

        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(ThreadColor.ANSI_YELLOW+" You can crack the interview");
                return "This is the callable statement";
            }
        });

        try{
            future.get();
        } catch (ExecutionException e) {
            System.out.println("Execution exception");
        } catch (InterruptedException e) {
            System.out.println("Interrupted Exception");
        }

        executorService.shutdown();

//        new Thread(producer).start();
//        new Thread(consumer1).start();
//        new Thread(consumer2).start();
    }
}

class MyProducer implements  Runnable {
    private List<String> buffer;
    private String color;
    private ReentrantLock reentrantLock;

    public MyProducer(List<String> buffer, String color,ReentrantLock reentrantLock) {
        this.buffer = buffer;
        this.color = color;
        this.reentrantLock = reentrantLock;
    }

    public void run() {
        Random random = new Random();
        String[] nums = { "1", "2", "3", "4", "5"};

        for(String num: nums) {
            try {
                System.out.println(color + "Adding..." + num);
                reentrantLock.lock();
                    buffer.add(num);
                reentrantLock.unlock();
                Thread.sleep(random.nextInt(1000));
            } catch(InterruptedException e) {
                System.out.println("Producer was interrupted");
            }
        }

        System.out.println(color + "Adding EOF and exiting....");
        reentrantLock.lock();
            buffer.add("EOF");
        reentrantLock.unlock();
    }
}

class MyConsumer implements Runnable {
    private List<String> buffer;
    private String color;
    private ReentrantLock reentrantLock;

    public MyConsumer(List<String> buffer, String color,ReentrantLock reentrantLock) {
        this.buffer = buffer;
        this.color = color;
        this.reentrantLock = reentrantLock;
    }

    public void run() {
        while (true) {
            reentrantLock.lock();
                if (buffer.isEmpty()) {
                    reentrantLock.unlock();
                    continue;
                }
                if (buffer.get(0).equals(ProducerConsumer.EOF)) {
                    System.out.println(color + "Exiting");
                    break;
                } else {
                    System.out.println(color + "Removed " + buffer.remove(0));
                    reentrantLock.unlock();
                }
            }
        reentrantLock.unlock();

    }
}
