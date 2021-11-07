package main.java.guru.learning.arrays.sort;

public class InsertionSort {

	public static void main(String[] args) {
		int[] a1 = new int[] { 52, 41, 15, 76, 71, 86 };

		for (int unSortedIndex = 1; unSortedIndex < a1.length; unSortedIndex++) {

			int newElement = a1[unSortedIndex];
			int i;
			for (i = unSortedIndex; i > 0 && a1[i - 1] > newElement; i--) {
				a1[i] = a1[i - 1];
			}
			a1[i] = newElement;
		}
		for (int a : a1) {
			System.out.println(a);
		}
	}
}
