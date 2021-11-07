package main.java.guru.learning.arrays.sort;

public class ShellSort {
	public static void main(String[] args) {
		int[] a1 = new int[] { 52, 41, 15, 7, 71, 86, -22 };

		// Shell is all about gaps;

		for (int gap = a1.length / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < a1.length; i++) {
				int newElement = a1[i];
				int j;
				for (j = i; j >= gap && a1[j - gap] > newElement; j = j - gap) {
					a1[j] = a1[j - gap];
				}
				a1[j] = newElement;
			}
		}
		for (int a : a1) {
			System.out.println(a);
		}
	}
}
