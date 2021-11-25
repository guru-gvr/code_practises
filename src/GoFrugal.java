import java.util.HashMap;
import java.util.Stack;

public class GoFrugal {

	public static void main(String[] args) {

		String input = "footfirstfoot";

//		Stack<Character> stackCharacter = new Stack<>();
//		for (int i = 0; i < ac.length(); i++) {
//			if (ac.charAt(i) == '(' || ac.charAt(i) == '[' || ac.charAt(i) == '{') {
//				stackCharacter.push(ac.charAt(i));
//				System.out.println("pushing in" + stackCharacter.get(stackCharacter.size() - 1));
//			} else if (ac.charAt(i) == ')' && stackCharacter.get(stackCharacter.size() - 1).equals('(')) {
//				System.out.println("poping out" + stackCharacter.get(stackCharacter.size() - 1));
//				stackCharacter.pop();
//			} else if (ac.charAt(i) == ']' && stackCharacter.get(stackCharacter.size() - 1).equals('[')) {
//				System.out.println("poping out" + stackCharacter.get(stackCharacter.size() - 1));
//				stackCharacter.pop();
//			} else if (ac.charAt(i) == '}' && stackCharacter.get(stackCharacter.size() - 1).equals('{')) {
//				System.out.println("poping out" + stackCharacter.get(stackCharacter.size() - 1));
//				stackCharacter.pop();
//			}
//
//		}
//
//		System.out.println(stackCharacter.size() == 0);

		HashMap<Character, Integer> charCountMap = new HashMap<>();

		for (int i = 0; i < input.length(); i++) {
			if (charCountMap.get(input.charAt(i)) != null) {
				System.out.println("Characters and count " + input.charAt(i) + " " + charCountMap.get(input.charAt(i)));
				charCountMap.put(input.charAt(i), charCountMap.get(input.charAt(i)) + 1);
			} else {
				System.out.println("Characters" + input.charAt(i));
				charCountMap.put(input.charAt(i), 1);
			}
		}

		int firstCharacterIndex = 0;

		System.out.println(charCountMap.size());
		for (Character ch : charCountMap.keySet()) {

			if (charCountMap.get(ch) == 1) {
				System.out.println("Non repeating characters" + ch);
				int index = input.indexOf(ch);

				if (firstCharacterIndex == 0) {
					firstCharacterIndex = index;
				}
				// checking minimum index
				if (firstCharacterIndex >= index) {
					firstCharacterIndex = index;
				}

			}
		}

		System.out.println("First repeating character" + input.charAt(firstCharacterIndex));

	}

}
