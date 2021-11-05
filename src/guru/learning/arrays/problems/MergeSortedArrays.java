package guru.learning.arrays.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeSortedArrays {

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter first size");
		int length1 = Integer.parseInt(bufferedReader.readLine());
		System.out.println("Enter Second size");
		int length2 = Integer.parseInt(bufferedReader.readLine());

		int[] array1 = new int[length1];
		int[] array2 = new int[length2];

		int[] array3 = new int[length1 + length2];
		

		for (int i = 0; i < length1; i++) {
			System.out.println("Enter first array elements");
			array1[i] = Integer.parseInt(bufferedReader.readLine());
		}

		for (int j = 0; j < length2; j++) {
			System.out.println("Enter Second array elements");
			array2[j] = Integer.parseInt(bufferedReader.readLine());
		}
		System.out.println("Processing......");
		int index = 0;
		for (int k = 0, l = 0;index <(length1+length2); ) {
			System.out.println("K and L " + k + "  " + l);
			if ((k < length1 && l<length2) && array1[k] < array2[l]) {
				array3[index] = array1[k];
				System.out.println("K and Index " + k + "  " + index);
				index++;
				k++;
				
			} else if(k==length1 && l<length2 ) {
				array3[index] = array2[l];
				System.out.println("Exited k ");
				index++;
				l++;
			}else if( l<length2) {
				array3[index] = array2[l];
				System.out.println("L and Index " + l + "  " + index);
				index++;
				l++;
			}else if(k<length1 && l==length2 ) {
				array3[index] = array1[k];
				System.out.println("Exited l ");
				index++;
				k++;
			}
			
		}

		for(int a:array3) {
			System.out.println(a);
		}

	}
}
