package lab8;
//#11
import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.Point;
import plotter.Plotter;
import plotter.Polyline;

public class Check3b {

	public static void main(String [] args) throws FileNotFoundException {
		ArrayList<Polyline> polArr = new ArrayList<>();
		Plotter plotter = new Plotter();
		polArr = readFile("hello.txt");
		//plotter.plot(polArr.get(0));
		//System.out.println(polArr.size());
		for(int i =0; i < polArr.size();i++) {
			//System.out.println(polArr.get(i));
			plotter.plot(polArr.get(i));
		}
	}

	private static ArrayList<Polyline> readFile(String filename) throws FileNotFoundException {
		// open the file
		File file = new File(filename);    
		Scanner scanner = new Scanner(file);
		ArrayList<Polyline> polArr = new ArrayList<Polyline>();
		// while there are more lines...
		while (scanner.hasNextLine())
		{
			// get the next line
			String line = scanner.nextLine();
			Polyline temp = newPolyline(line);
			if(temp != null){
				polArr.add(temp);
			}
			//System.out.println(newPolyline(line));
			//System.out.println("New Line");
		}
		scanner.close();
		return polArr;
	}

	private static Polyline newPolyline(String line) {
		Scanner scan = new Scanner(line);
		Polyline poly = null;
		String color = "";
		int width = -1;
		int x = 0;
		int y = 0;
		int isX = 0;
		boolean created = false;
		while(scan.hasNext()) {
			String words = scan.next();
			if(words.charAt(0) == '#') {
				break;
			}
			words.trim();
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
			}
			if(!Character.isDigit(words.charAt(0))){
				color = words;
				//System.out.println(color);
			}
			/*switch(words) {
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
			default:
				break;
			}
			*/
			if((width != 0 && width != -1) && !created && !color.equals("")) {
				poly = new Polyline(color, width);
				System.out.println(poly.getColor());
				//System.out.println(poly.getWidth());
				created = true;
				
			}
			else if(width == -1 && !created) {
				poly = new Polyline(color);
				//System.out.println(poly.getColor());
				created = true;
			}
			if(x != 0 && y != 0) {
				//System.out.println("X: " + x + " Y: " + y);
				poly.addPoint(new Point(x,y));
				//System.out.println(poly.getPoints());
				isX = 0;
				x = 0;
				y = 0;
				//System.out.println(color);
				//System.out.println(width);
			}
			//System.out.println(poly);

		}
		scan.close();
		return poly;
	}
}