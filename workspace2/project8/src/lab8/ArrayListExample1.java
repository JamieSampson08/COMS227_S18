package lab8; 
import java.util.ArrayList; 
import java.util.Arrays; 
import java.util.Scanner; 
public class ArrayListExample1 { 
	public static void main(String[] args) { 
		String s = "3 5 7 9 12"; 
		ArrayList result = readNumbers(s); 
		System.out.println(result); 
	} 
	public static ArrayList readNumbers(String text) { 
		Scanner scanner = new Scanner(text); 
		ArrayList nums = new ArrayList(); 
		scanner = new Scanner(text); 
		while (scanner.hasNextInt()) { 
			nums.add(scanner.nextInt()); 
		} 
		return nums; 
	} 
} 