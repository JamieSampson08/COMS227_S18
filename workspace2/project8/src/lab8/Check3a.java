package lab8;

import java.io.*;
import java.util.*;
import java.awt.Point;
import plotter.Plotter;
import plotter.Polyline;

public class Check3a {

	public static void main(String [] args) throws FileNotFoundException {
		readFile("hello.txt");
	}

	private static void readFile(String filename) throws FileNotFoundException {
		// open the file
		File file = new File(filename);    
		Scanner scanner = new Scanner(file);
		// while there are more lines...
		while (scanner.hasNextLine())
		{
			// get the next line
			String line = scanner.nextLine();
			newPolyline(line);
		}
	}
	
	private static Polyline newPolyline(String line) {
		Plotter plotter = new Plotter();
		Polyline pl = new Polyline("red");
		Scanner scan = new Scanner(line);
		ArrayList<Polyline> arrPol = new ArrayList<>();
		String color = "";
		int width = 0;
		int x = 0;
		int y = 0;
		int isX = 0;
		int count = 0;

		while(scan.hasNextLine()) {
		//while(scan.hasNext()) {
			count ++;
			String section = scan.nextLine();
			//String section = scan.next();
			section.trim();
			if(section.charAt(0) == '#' || section.length() == 0) {
				continue;
			}
			Scanner scan2 = new Scanner(section);
			color = "";
			width = 0;

			while(scan2.hasNext()) {
			//String words = section;
			String words = scan2.next();
			if(color.equals("")) {
				try{
					width = Integer.parseInt(words);
				}
				catch(NumberFormatException e) {
				}
			}
			else {
				if(isX == 0) {
					x = Integer.parseInt(words);
					isX = 1;
				}
				else if(isX == 1) {
					y = Integer.parseInt(words);
					isX = 2;
				}
				else {
					isX = 0;
				}
				if(x != 0 && y != 0) {
					pl.addPoint(new Point(x, y));
					System.out.println("X: " + x + " Y: " + y);
					isX = 0;
					x = 0;
					y = 0;
				}
			}

			switch(words) {
			case "red": 
				color = "red";
				break;
			case "green": 
				color = "green";
				break;
			case "blue": 
				color = "blue";
				break;
			case "yellow": 
				color = "yellow";
				break;
			case "orange":
				color = "orange";
				break;
			case "magenta":
				color = "magneta";
				break;
			case "cyan":
				color = "cyan";
				break;
			case "black":
				color = "black";
				break;	
			}
			if(width != 0) {
				pl = new Polyline(color, width);
				arrPol.add(pl);
				
			}
			else {
				pl = new Polyline(color);
				arrPol.add(pl);
			}
		}
	}
		for(int i = 0; i < arrPol.size(); i++) {
			System.out.println(arrPol.get(i));
			plotter.plot(arrPoly.get(i));
		}
		scan.close();
		return pl;
}}
