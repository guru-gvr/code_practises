package main.java.guru.learning.strings.problems;

public class LookAndSay {
	public static void main(String[] args) {

		String a = "1";
		String output = "";
		String[] output_array = new String[9];
		output_array[0] = a;
		for (int i = 0; i < 8; i++) {
			System.out.println("Im the a" + a);
			a = calculate(a);
			output_array[i + 1] = a;
		}
		System.out.println("Last " + a);
	}

	public static String calculate(String input) {
		System.out.println("Received Input " + input);
		String output = "";
		if (input.length() == 1) {
			return "1" + input;
		}
		for (int i = input.length() - 1; i >= 0; i--) {
			String each_digit_count = "";
			int count = 1;
			int current_position = i;
			if (current_position == 0 && input.charAt(1) != input.charAt(0)) {
				each_digit_count = "" + count + "" + input.charAt(i);
				output = each_digit_count + output;
				break;
			}
			while (input.charAt(i - 1) == input.charAt(current_position)) {
				count++;
				i--;
				if (i == 0) {
					break;
				}
			}
			each_digit_count = "" + count + "" + input.charAt(i);
			output = each_digit_count + output;
		}
		return output;
	}
}
