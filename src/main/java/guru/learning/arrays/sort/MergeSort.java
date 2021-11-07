package main.java.guru.learning.arrays.sort;

public class MergeSort {

	public static void main(String[] args) {
		int[] a1 = new int[] { 32, 3338, 34, 40, 34, 33 };
		mergeSort(a1, 0, a1.length);
	}

	public static void mergeSort(int[] array, int start, int end) {
		System.out.println("Start and end" + start + " " + +end);
		if (end - start < 2) {
			return;
		} else {
			int middle = (start + end) / 2;
			System.out.println("Middle" + middle);
			mergeSort(array, start, middle);
			System.out.println("Right");
			mergeSort(array, middle, end);
			merge(array, start, middle, end);
		}
		for (int i : array) {
			System.out.print(i + " " + '\t');
		}
		System.out.println();
	}

	private static void merge(int[] array, int start, int middle, int end) {
		System.out.println("Start and middle end" + start + " " + middle + " " + end);
		int[] temp = new int[end - start];
		int tempIndex = 0;

		if (array[middle - 1] <= array[middle]) {
			System.out.println("Already sorted");
			return;
		}
		int i;
		int j;
		for (i = start, j = middle; i < middle && j < end;) {
			System.out.println("I and J index" + i + " " + j + " " + tempIndex);
			temp[tempIndex++] = array[i] <= array[j] ? array[i++] : array[j++];
		}

		// Consider a situation we need to merge these two arrays [ {32,36,38} {33,34} ]
		// If we compare and insert it in the temp array, We would have 32,33,34 alone
		// since the the Right partition is completed. Now we have to copy the 36,38
		// elements in Input to Input itself in a correct position [i.e] We need to
		// shift 36 by 2 elements and insert it.
		// Similarly 38
		// We too the following work by using System.arraycopy method

		// Let us assume the array is {32,36,38,33,34}
		// tmp is {32,33,34}
		// the following operation will create a temp array of length (middle-i)
		System.arraycopy(array, i, array, start + tempIndex, middle - i);

		/// input array will be {32, 36, 38, 36, 38}

		// this statement copies the entire temp and places to array from start
		System.arraycopy(temp, 0, array, start, tempIndex);
	}

}
