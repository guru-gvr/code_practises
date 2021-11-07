package main.java.guru.learning.arrays.sort;

public class SelectionSort {
	public static void main(String[] args) {

		int[] a1 = new int[] { 52, 41, 15, 76, 71, 86 };
		for (int i = 0; i < a1.length; i++) {
			int min = i;
			for (int j = i+1; j < a1.length; j++) {
				if(a1[j]<a1[min]) {
					min=j;
				}
			}
			int temp = a1[i];
			a1[i] = a1[min];
			a1[min] = temp;
		}
		for (int a : a1) {
			System.out.println(a);
		}
		
	}

}
