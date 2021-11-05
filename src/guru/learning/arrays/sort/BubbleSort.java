package guru.learning.arrays.sort;

public class BubbleSort {
	public static void main(String[] args) {

		int[] a1 = new int[] { 52, 41, 15, 76, 71, 86 };

		for (int i = 0; i < a1.length; i++) {
			for (int j =0; j < a1.length; j++) {

				if (a1[i] < a1[j]) {
					int temp = a1[i];
					a1[i] = a1[j];
					a1[j] = temp;
				}
			}
		}
		for (int a : a1) {
			System.out.println(a);
		}
	}

}
