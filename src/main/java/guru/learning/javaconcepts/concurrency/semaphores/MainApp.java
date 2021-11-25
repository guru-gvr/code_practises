package main.java.guru.learning.javaconcepts.concurrency.semaphores;

public class MainApp {

	public static void main(String[] args) {
		Data data = new Data();
		Thread sender = new Thread(new Sender(data));
		Thread receiver = new Thread(new Receiver(data));

		sender.start();
		receiver.start();
		System.out.println("hai");
	}

}
