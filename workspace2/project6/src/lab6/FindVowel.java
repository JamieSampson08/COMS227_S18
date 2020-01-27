package lab6;

import java.util.Scanner;

public class FindVowel {
	public static void main(String [] args) {
		Scanner userInput = new Scanner(System.in);
		int vowelIndex = -1;
		String word = "";
		
		System.out.println("Enter a word: ");
		word = userInput.next();
		for(int i = 0; i < word.length(); i++) {
			if("aeiouAEIOU".indexOf(word.charAt(i)) >= 0) {
				vowelIndex = i;
				break;
			}	
		}
		System.out.println(vowelIndex);
	}
}
