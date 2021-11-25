package main.java.guru.learning.javaconcepts.concurrency.semaphores;

public class Data {
	private String packet;

	// True if receiver should wait
	// False if sender should wait
	private boolean transfer = true;

	public synchronized void send(String packet) {
		System.out.println("Entering Data send in data class");
		
		while (!transfer) {
			try {
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				System.out.println("Thread interrupted");
			}
		}
		transfer = false;

		this.packet = packet;
		System.out.println("Attached Data in data class");
		notifyAll();
	}

	public synchronized String receive() {
		System.out.println("Entering Data Receive in data class");
		while (transfer) {
			try {
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				System.out.println("Thread interrupted");
			}
		}
		transfer = true;
		System.out.println("Received Data in data class");
		notifyAll();
		return packet;
	}
}
