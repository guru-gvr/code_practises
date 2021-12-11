package main.java.guru.learning.arrays.problems;

import java.util.Arrays;

public class NextNumber {
	public static void main(String[] args) {

		int[] array = { 9, 9, 9, 9, 9 };
		int[] nextArray = findNext(array);
		for (int a : nextArray)
			System.out.println(a);
		// recur(array);
	}

	private static int[] findNext(int[] array) {
		int[] nArray;
		nArray = new int[array.length + 1];
		int l = nArray.length - 1;
		for (int i = array.length - 1; i >= 0; i--) {
			if (array[i] < 9) {
				nArray[l--] = array[i] + 1;
				copyRemaining(nArray, array, i);
				break;
			} else {
				nArray[l--] = 0;
			}

			if (i == 0 && array[i] == 9) {
				nArray[0] = 1;
			}

		}
		return nArray;
	}
	private static void copyRemaining(int[] nArray, int[] array, int index) {

		for (int i = 0; i < index; i++) {
			nArray[i] = array[i];
		}
	}
}
