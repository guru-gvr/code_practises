package src.com.timbuchalka;

import java.util.Random;

public class Reader implements Runnable {
        private Message message;

        public Reader (Message message) {
            this.message = message;
        }
        @Override
        public void run() {
            Random random = new Random();
            for (String messageContent = message.read();
                 !messageContent.equalsIgnoreCase("Finished");
                 messageContent = message.read()) {
                System.out.println(messageContent+"From reader");
                try {
                    Thread.sleep(random.nextInt(2000));
                } catch (InterruptedException e) {
                    System.out.println("Exception occurs");
                }
            }
        }
}
