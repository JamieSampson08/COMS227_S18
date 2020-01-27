package lab8;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
//#6
public class Check1
{
  public static void main(String[] args) throws FileNotFoundException
  {
    File file = new File("story.txt");
    Scanner scanner = new Scanner(file);

    int num = 0;
    
    while (scanner.hasNext())
    {
    	String line = scanner.nextLine();
        Scanner scan = new Scanner(line);
        while(scan.hasNext()) {
        	String word = scan.next();
        	num ++;
        }
        System.out.println(num);
        num = 0;
    }
    scanner.close();
  }
}