package postage1;

import java.util.Scanner;
import postage1.PostageUtil;

public class Postage {
	public static void main(String [] args) {
		
		Scanner userInput = new Scanner(System.in);
		double weight = 0;
		
		System.out.print("Enter weight: ");
		weight = userInput.nextDouble();
		System.out.println(PostageUtil.computePostage(weight));
	}
}
