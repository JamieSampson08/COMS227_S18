package lab7;

import java.util.Arrays; 
import java.util.Scanner; 
import java.util.Random;

public class Exercise {
	public static void main(String [] args) {
		int[] arr = {-3, 34, -23, 4, 6};
		int [] result = getPositiveNumbers(arr);
		System.out.println(Arrays.toString(result));
		
		result = randomExperiment(10, 1000);
		System.out.println(Arrays.toString(result));
	}
	
	public static int[] getPositiveNumbers(int[] numbers) {
		int count = 0;
		int index = 0;
		for(int i = 0; i < numbers.length; i++) {
			if(numbers[i] > 0) {
				count ++;
			}
		}
		int [] posArray = new int[count];
		for(int j = 0; j < numbers.length; j++) {
			if(numbers[j] > 0) {
				posArray[index] = numbers[j];
				index++;
			}
		}
		return posArray;
	}
	/*
	 * Write a static method that generates iters random numbers in the range 0 
	 * through max - 1 and returns an array counts in which the the element 
	 * counts[i] is the number of times that value i was generated. Write a main 
	 * method that does this with max = 10 and iters = 1000 and prints the result. 
	 */
	public static int[] randomExperiment(int max, int iters) {
		int[] ranArray = new int[iters];
		int[] counts = new int[max];
		Random rand = new Random();
		int num = 0;
		int times = 0;
		for(int i = 0; i < iters; i++) {
			num = rand.nextInt(max);
			ranArray[i] = num;
		}
		for(int k = 0; k < max; k++) {
			for(int j = 0; j < ranArray.length; j++) {
				if(ranArray[j] == k) {
					times ++;
				}
			}
			counts[k] = times;
			times = 0;
		}
		return counts;
	}
}
