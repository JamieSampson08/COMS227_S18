package lab8;

import java.io.*;
import java.util.*;
import java.awt.Point;
import plotter.Plotter;
import plotter.Polyline;

public class Check3 {
	
	public static void main(String [] args) throws FileNotFoundException {
		Plotter plotter = new Plotter();
		ArrayList<Polyline> arrPoly = readFile("hello.txt");
		for(int i = 0; i < arrPoly.size(); i++) {
			plotter.plot(arrPoly.get(i));
		}
	}
	
	private static ArrayList<Polyline> readFile(String filename) throws FileNotFoundException {
		// open the file
	    File file = new File(filename);    
	    Scanner scanner = new Scanner(file);
	    ArrayList<Polyline> arrPol = new ArrayList<>();
	    
	    // while there are more lines...
	    while (scanner.hasNextLine())
	    {
	      // get the next line
	      String line = scanner.nextLine();
	      newPolyline(line);
	    }
		return arrPol; 
	}
	private static Polyline newPolyline(String line) {
		Polyline pol = new Polyline("red");
		Scanner scan = new Scanner(line);
		while(scan.hasNext()) {
			String section = scan.nextLine();
			section.trim();
			if(section.charAt(0) == '#' || section.length() == 0) {
				continue;
			}
			//Possible colors: "red", "green", "blue", "yellow", "orange", "magenta", "cyan", and "black"
			System.out.println(section);
		}
		scan.close();
		return pol;
	}
}
