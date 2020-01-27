package lab3;

public class StringIntConverting {
	public static void main(String [] args) {
		int x = 42;
	    String r = "" + x;
	    System.out.println(r);
	    
	    String s = "79";
	    int y = Integer.parseInt(s);
	    System.out.println(y);
	    
	    String w = "23Skidoo";
	    int z = Integer.parseInt(w);
	    System.out.println(z);
	    //NumberFormatException
	}
}
