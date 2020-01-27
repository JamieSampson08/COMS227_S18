package lab8;
import java.util.ArrayList;
import java.util.Arrays; 
//#8
public class Check2 {
	public static void main(String [] args) {
		ArrayList<String> arrString = new ArrayList<String>();
		arrString.add("dog");
		arrString.add("cat");
		arrString.add("horse");
		arrString.add("dog");
		arrString.add("cat");
		arrString.add("dog");
		removeDuplicates(arrString);
		
	}
	public static void removeDuplicates(ArrayList words) {
		ArrayList<String> newArr = new ArrayList<String>();
		int count = 0;
		String word = "";
		
		for(int i = 0; i < words.size(); i++) {
			if(words.contains(words.get(i))) {
				newArr.add((String) words.get(i));
				words.remove(i);
			}
		}
		System.out.println(newArr.toString());
	}
}
