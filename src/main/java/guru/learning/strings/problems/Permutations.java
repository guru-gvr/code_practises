package main.java.guru.learning.strings.problems;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Permutations {

//	public static void main(String args[]) throws Exception {
//		Scanner input = new Scanner(System.in);
//		System.out.print("Enter String:");
//		String chars = input.next();
//		System.out.println(chars.substring(3)); 
//		showPermutations("", chars);
//	}
//
//	public static void showPermutations(String str, String chars) {
//		if (chars.length() <= 1)
//			System.out.println(str + chars);
//		else
//			for (int i = 0; i < chars.length(); i++) {
//				try {
//					String newString = chars.substring(0, i) + chars.substring(i + 1);
//					System.out.println("New String" + newString);
//					showPermutations(str + chars.charAt(i), newString);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//	}

	public static void main(String[] args) throws IOException {
//		System.out.println(longestPalindromeString("1234"));
//		System.out.println(longestPalindromeString("12321"));
//		System.out.println(longestPalindromeString("9912321456"));
//		System.out.println(longestPalindromeString("9912333321456"));
//		System.out.println(longestPalindromeString("12145445499"));
//		System.out.println(longestPalindromeString("1223213"));
//		System.out.println(longestPalindromeString("abb"));
		
//		System.out.println(longestPalindromeString("121"));
//		
//		String a ="aaa"+"vv";
//		a.replace("aa","--");
//		System.out.println(a);
		
		
		 FileWriter fileWriter = new FileWriter("/guru.txt",true);

		    
		    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		    bufferedWriter.write("hasi");
		  
		    
		    PrintWriter printWriter = new PrintWriter(fileWriter);
		    printWriter.print("Some String");
		    printWriter.printf("Product name is %s and its price is %d $", "iPhone", 1000);
		    bufferedWriter.close();
		    printWriter.close();
		
	}

	static public String intermediatePalindrome(String s, int left, int right) {
		if (left > right)
			return null;
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		return s.substring(left + 1, right);
	}

	// O(n^2)
	public static String longestPalindromeString(String s) {
		if (s == null)
			return null;
		String longest = s.substring(0, 1);
		for (int i = 0; i < s.length() - 1; i++) {
			// odd cases like 121
			String palindrome = intermediatePalindrome(s, i, i);
			if (palindrome.length() > longest.length()) {
				longest = palindrome;
			}
			// even cases like 1221
			palindrome = intermediatePalindrome(s, i, i + 1);
			if (palindrome.length() > longest.length()) {
				longest = palindrome;
			}
		}
		return longest;
	}

}
