package lab6;

import java.util.Scanner;

public class InitialCreator {
	public static void main(String [] args) {
		String text = "Edna del Humboldt von der Schooch";
		Scanner userInput = new Scanner(text);
		String initals = "";
		String name = "";
		System.out.println("Enter you fullname: ");
		while(userInput.hasNext()) {
			name = userInput.next();
			initals += name.charAt(0);
		}
		System.out.println(initals);
	}
}
