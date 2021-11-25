package main.java.guru.learning.javaconcepts.concurrency.semaphores;

import java.util.concurrent.ThreadLocalRandom;

public class Receiver implements Runnable {
	private Data load;

	public Receiver(Data data) {
		this.load = data;
	}

	public void run() {
		for (String receivedMessage = load.receive(); !"End".equals(receivedMessage); receivedMessage = load
				.receive()) {

			System.out.println(receivedMessage);

			// ...
			try {
				Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				System.out.println("Thread interrupted");
			}
		}
	}
}
