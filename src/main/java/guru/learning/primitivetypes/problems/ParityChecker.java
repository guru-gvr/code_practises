package main.java.guru.learning.primitivetypes.problems;

public class ParityChecker {
	public static void main(String[] args) {

		long x = 9999999;
		short result = 0;
		int a = 2 ^ 5;
		int left_shift = 1 << 10;
		int right_shift = 24 >> 1;
		System.out.println("a " + a + "left_shift " + left_shift + "right_shift " + right_shift);
		while (x != 0) {
			System.out.println("start x " + x);
			result ^= (x & 1);
			System.out.println("result " + result);
			x >>= 1;
			System.out.println("end x " + x);

		}
		System.out.println("Result " + result);
	}
}
