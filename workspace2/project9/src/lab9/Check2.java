package lab9;

import java.io.File;
import java.util.ArrayList;

public class Check2 {
	public static void main(String [] args) {
		//File rootDirectory = new File("U:/cs227/workspace2/project9/src");
		//System.out.println(countFiles(rootDirectory));
		
		//System.out.println(countPatterns(9));

		File rootDirectory = new File(".");
		ArrayList<String> result = findFiles(rootDirectory);
		System.out.println(result); //harder to code
	}
	public static int countFiles(File f) {
		if (!f.isDirectory())
		{
			return 1;
		}
		else
		{
			int num = 0;
			File[] files = f.listFiles();
			for (int i = 0; i < files.length; ++i)
			{
				num += countFiles(files[i]);
			}
			return num;
		}
	}
	
	public static ArrayList<String> findFiles(File file)
	{
		// create an empty array list...
		ArrayList<String> arr = new ArrayList<String>();

		if (!file.isDirectory())
		{
			// base case
			arr.add(file.getName());
		}
		// pass it into the recursive method
		else
		{	
		      // recursively search the subdirectory
		      for (File f : file.listFiles())
		      {
		        arr.addAll(findFiles(f));
		      }
		}
		return arr;
	}
	
		public static int countPatterns(int n){
			if(n <= 2){
				return 1;
			}
			else if(n == 3){
				return 2;
			}
			else{
				int total = 0;
				return total + countPatterns(n-1) + countPatterns(n-3);
			}
		}
		/*
		 * if n = 1 : (1) 
	return 1
if n = 2 : (1, 1)
	return 1
if n = 3: --> (3) (1, 1, 1 )
	return 2
if n = 4: --> (3, 1) (1, 1, 1, 1) (1, 3) 
	return 3
if n = 5: --> (3, 1, 1) (1, 3, 1) (1, 1, 3) (1,1,1,1,1)
	return 4
if n = 6: --> (3, 3) (3, 1, 1, 1) (1, 3, 1, 1) (1, 1, 3, 1) (1, 1, 1, 3)(1, 1, 1, 1, 1, 1)
return 6
		 */
	}
