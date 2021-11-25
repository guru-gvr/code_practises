package main.java.guru.learning.javaconcepts.concurrency;

public class WaitingState implements Runnable {
	public static Thread t1;

	public static void main(String[] args) {
		t1 = new Thread(new WaitingState());
		t1.start();
		System.out.println(WaitingState.t1.getState());
	}

	public void run() {
		System.out.println("Entering waiting state run");
		Thread t2 = new Thread(new DemoThreadWS());
		t2.start();
		System.out.println("t2 state " + WaitingState.t1.getState());
		try {
			System.out.println("Before " + WaitingState.t1.getState());
			t2.join(2100);
			System.out.println("After" + WaitingState.t1.getState());
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			// System.err("");
			System.out.println("Thread interrupted");
		}
		System.out.println("Leaving waiting state run");
	}
}

class DemoThreadWS implements Runnable {
	public void run() {
		System.out.println("Entering Demothread ");
		System.out.println(WaitingState.t1.getState());
		try {
			System.out.println("Before sleep" + WaitingState.t1.getState());
			Thread.sleep(2000);
			System.out.println(WaitingState.t1.getState());
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			System.out.println("Thread interrupted");
		}

		System.out.println(WaitingState.t1.getState());
		System.out.println("Leaving Demothread ");
	}
}
