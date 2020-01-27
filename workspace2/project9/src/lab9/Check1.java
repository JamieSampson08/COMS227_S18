package lab9;

public class Check1 {
	public static void main(String [] args) {
		int[] test = {13, 43, 5, 11, 29, 32, 20};
		int result = maxNum(test);
		System.out.println(result);
		int levels = 3;
		int totalBalls = numBalls(levels);
		System.out.println(totalBalls);
	}
	public static int numBalls(int level) {
		if(level == 1) {
			return 1;
		}
		else {
			return (level*level) + numBalls(level-1);
		}
		
	}
	public static int maxNum(int[] arr) {

		return maxNumRec(arr, 0, arr.length - 1);
	}
	public static int maxNumRec(int[] arr, int start, int end){
	    if (start == end)
	    {
	      return arr[start];
	    }
	    else {
	    	int mid = (start + end) / 2;
	    	int leftMax = maxNumRec(arr, start, mid);
	    	int rightMax = maxNumRec(arr, mid + 1, end);
	    	return Math.max(leftMax, rightMax);
	    }
	}
}
