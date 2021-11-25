package main.java.guru.learning.javaconcepts.concurrency.semaphores;

import java.util.concurrent.ThreadLocalRandom;

public class Sender implements Runnable {
	private Data data;

	public Sender(Data data) {
		this.data = data;
	}

	public void run() {
		String packets[] = { "First packet", "Second packet", "Third packet", "Fourth packet", "End" };

		for (String packet : packets) {
			System.out.println("Entering send stage");
			data.send(packet);
			System.out.println("Sended ");
			// Thread.sleep() to mimic heavy server-side processing
			try {
				Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				System.out.println("Thread interrupted");
			}
		}
	}
}
