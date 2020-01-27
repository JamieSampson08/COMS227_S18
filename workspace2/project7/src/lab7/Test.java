package lab7;

public class Test {
	public static void main(String [] args) {
		int d = 2;
		int c = 175;
		double totalDollars = (double) d + (c/100)+ ((c%100)/100.0);
		System.out.println(totalDollars);
	}
}
