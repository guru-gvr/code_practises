package src.com.timbuchalka;
public class Message {
    private String message;
    private boolean empty = true;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public synchronized String read() {
        // If the Message is empty i will wait till the write has set the message.
        while (empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        // the flow of the process will be read() will send the message set by Write() method and update the object's
        // empty state as true and notify all the thread which are waiting for the thread.
        this.empty = true;
        notifyAll();
        return message;
    }
    public synchronized void write(String message) {
        // If the object's state is not empty I will wait til the read method has send the message.
        while (!empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.message = message;
        // i have set the message so the the object's empty state to false.
        this.empty = false;
        // Notifies all the threads which are waiting for Message object;s lock.
        notifyAll();

    }
    public static void main(String[] args) {
        Message message1 = new Message();
        Writer writer = new Writer(message1);
        Reader reader = new Reader(message1);
        new Thread(writer).start();
        new Thread(reader).start();
    }

}