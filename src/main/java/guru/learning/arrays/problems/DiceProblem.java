package main.java.guru.learning.arrays.problems;

public class DiceProblem {
	public static void main(String[] args) {

		int[] dice = { 1, 0, 0, 0, 0, 0, 0 };

		int range = 0;

		for (int i = 0; i < dice.length;) {
			range = i;
			if (dice[i] > 0 && i < dice.length - 1) {

				int index = max_within_range(i, dice[i], dice);
				i = index;
				if ((i) == dice.length - 1) {
					System.out.println("Won");
					break;
				}
			}
			if (dice[i] == 0) {
				System.out.println("You lose");
				break;
			}
		}
	}

	private static int max_within_range(int i, int max_steps, int[] dice) {

		int index = i + 1;
		int max = dice[i + 1];
		for (int start = i + 1; start <= i + max_steps; start++) {
			if (max <= dice[start]) {
				index = start;
			}
		}
		return index;
	}
}
