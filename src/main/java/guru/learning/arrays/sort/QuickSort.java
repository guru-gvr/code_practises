package main.java.guru.learning.arrays.sort;

public class QuickSort {
	public static void main(String[] args) {
		int[] array = new int[] { -12, -11, -1, -9, -8, 0, -22, 2, 222 };
		long startTime = System.currentTimeMillis();
		quickSort(array, 0, array.length);
		long endTime = System.currentTimeMillis();
		System.out.println("Time taken is " + (endTime - startTime) + "millisec");
		for (int i : array) {
			System.out.print(i + " " + '\t');
		}
		System.out.println();
	}

	private static void quickSort(int[] array, int start, int end) {

		if (end - start < 2) {
			return;
		} else {
			int pivotIndex = partition(array, start, end);
			quickSort(array, start, pivotIndex);
			quickSort(array, pivotIndex + 1, end);

		}

	}

	private static int partition(int[] array, int start, int end) {
		System.out.println("Start and End" + start + " " + end);
		// this is using first element as PIVOT
		int pivot = array[start];
		int i = start, j = end;

		while (i < j) {

			// we are iterating till we find the first lesser number than a pivot
			while (i < j && array[--j] >= pivot)
				;

			if (i < j) {
				System.out.println("Assiging j value");
				System.out.println("I and J" + i + " " + j);
				array[i] = array[j];
			}
			// we are iterating till we find a greater number oe equal number than a pivot
			while (i < j && array[++i] <= pivot)
				;

			if (i < j) {
				System.out.println("Assiging i value");
				System.out.println("I and J" + i + " " + j);
				array[j] = array[i];
			}

			array[j] = pivot;
			System.out.println("Final I and J" + i + " " + j);
			return j;
		}
		return 0;
	}

}
