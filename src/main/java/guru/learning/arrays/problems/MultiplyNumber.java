package main.java.guru.learning.arrays.problems;

public class MultiplyNumber {
	public static void main(String[] args) {
		int[] aa = { 1, 2, 3, 6, 5, 5, 3, 2, 1 };
		int[] bb = { 2, 4, 4, 3, 2, 1, 1, 1, 1 };

		long result = 0;
		long sum1 = 0;
		long sum2 = 0;
		int j = 0;
		for (int i = aa.length - 1; i >= 0; i--) {
			sum1 += aa[i] * Math.pow(10, j);
			sum2 += bb[i] * Math.pow(10, j);
			j++;
		}
		System.out.println("Sum1 " + sum1 + " sum2 " + sum2 + " result " + sum1 * sum2);
	}
}
