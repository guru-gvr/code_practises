package main.java.guru.learning.arrays.problems;

public class DutchFlagPartition {

	static int[] array = { 0, 2, 1, 1, 2, 1, 0, 0, 2 };

	public static void main(String[] args) {

		int smaller = 0, equal = 0, larger = array.length - 1;

		while (equal < larger) {

			if (array[equal] < 1) {
				swap(smaller++, equal++);
			} else if (array[equal] == 1) {
				equal++;
			} else {
				swap(equal, larger--);
			}
		}
		for (int a : array)
			System.out.print(" " + a);
	}

	private static void swap(int i, int j) {
		// TODO Auto-generated method stub

		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;

	}
}
