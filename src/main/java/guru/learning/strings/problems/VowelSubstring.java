package main.java.guru.learning.strings.problems;

public class VowelSubstring {
	public static void main(String[] args) {

		String s = "aeiouu";
		int count = 0;
		String sa = "";
		for (int i = 0; i < s.length(); i++) {

			if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o'
					|| s.charAt(i) == 'u') {
				// for (int j = i; j < s.length(); j++) {
//					if (s.charAt(j) == 'a' || s.charAt(j) == 'e' || s.charAt(j) == 'i' || s.charAt(j) == 'o'
//							|| s.charAt(j) == 'u') {
				sa = sa + "" + s.charAt(i);
				System.out.println(" " + sa);
				if (sa.length() >= 5) {
					if (checkContains(sa)) {
						count++;
					}
				}
			} else {
				sa = "";
			}
			// }
			// }
			System.out.println(" ");
		}
		System.out.println("Count " + count);
	}

	private static boolean checkContains(String sa) {
		return sa.indexOf('a') >= 0 && sa.indexOf('e') >= 0 && sa.indexOf('i') >= 0 && sa.indexOf('o') >= 0
				&& sa.indexOf('u') >= 0;
	}
}

//	String s = "aeoibsddaeiouudb";
//	int count = 0;
//	System.out.println("Index of z  " + s.indexOf('z'));
//
//	int start = 0;
//	HashSet<Character> sa = new HashSet<>();
//	for (int i = 0; i < s.length(); i++) {
//		if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o'
//				|| s.charAt(i) == 'u') {
//			sa.add(s.charAt(i));
//			if (sa.size() == 5) {
//				System.out.println("vowels" + s.substring(start, i + 1));
//				count++;
//			}
//		} else {
//			start = i + 1;
//		}
//	}

//}
//	
//}
//	
//}
