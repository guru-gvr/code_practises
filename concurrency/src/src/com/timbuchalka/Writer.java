package src.com.timbuchalka;

import java.util.Random;

public class Writer implements Runnable {
    private Message message;

    public Writer(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        String[] messages = {"Hai guru Learn fast the concurrency", "Learn Design Patterns fully", "Learn and Spring web Flux","Finished"};

        Random random = new Random();
        for (String messageContent : messages) {
            System.out.println(messageContent  +" from writer ");
            message.write(messageContent);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                System.out.println("Exception occurs");
            }
        }

    }
}