package lab8;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LineNumberer
{
  public static void main(String[] args) throws FileNotFoundException
  {
    //Scanner scanner = new Scanner(System.in);
	File file = new File("../../workspace2/project7/src/lab7/Deck.java");
	Scanner scanner = new Scanner(file);
    int lineCount = 1;

    while (scanner.hasNextLine())
    {
      String line = scanner.nextLine();
      System.out.print(lineCount + " ");
      System.out.println(line);
      lineCount += 1;
    }
    scanner.close();
    System.out.println("Done");
    
  }
}