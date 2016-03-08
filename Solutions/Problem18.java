import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem18 {

	/**
	 * Problem 18 - Project Euler - www.projecteuler.net
	 * Maximum Path Sum I.
	 * This program finds the sum of the path of greatest value of a pyramid of numbers.
	 * Answer = 1074
	 * @author: Luigi Sacco
	 * @date  : February 18, 2016  
	 */

	public static void main(String[] args) throws FileNotFoundException {
		
		// triangular array of elements
		int[][] nums = getConstArrayFromFile("num_pyramid_15.txt", 15);

		double startTime = System.nanoTime();

		//-------------------------------------------------------------------
		//                       Algorithm Start
		//-------------------------------------------------------------------

		int[][] sums = new int[nums.length][];
		
		sums[0] = new int[1];
		sums[0][0] = nums[0][0];
		for (int row = 1; row < nums.length; row++) {
			sums[row] = new int[row+1];
			for (int i = 0; i <= row; i++) {
				sums[row][i] = nums[row][i];
				if (i == 0)
					sums[row][i] += sums[row-1][i];
				else if (i == row)
					sums[row][i] += sums[row-1][i-1];
				else
					sums[row][i] += (sums[row-1][i-1] > sums[row-1][i]) ?
				                     sums[row-1][i-1] : sums[row-1][i];
			}
		}

		int max = maxFromArray(sums[sums.length-1]);

		//-------------------------------------------------------------------
		//                       Algorithm End
		//-------------------------------------------------------------------

		double elapsedTime = System.nanoTime() - startTime;

		System.out.println("max = " + max);

		System.out.println("Execution time = "+ elapsedTime/1000000+"ms");

	}

	/**
	 * Takes as an input an array of numbers and outputs
	 * the greatest element. Assumes length > 0
	 */
	public static int maxFromArray(int array[]) {
		int max = array[0];
		for (int i = 1; i < array.length; i++)
			if (array[i] > max)
				max = array[i];
		return max;
	}

	/**
	 * Returns a triangular array with the integers from a file.
	 * Assumes a perfect pyramid in the file and a fixed amount for its size.
	 */
	public static int[][] getConstArrayFromFile(String filename, int size) throws FileNotFoundException {
		Scanner scan = new Scanner(new File(filename));
		int[][] numArray = new int[size][];
		numArray[0] = new int[1]; numArray[0][0] = scan.nextInt();
		for (int i = 1; i < size; i++) {
			scan.nextLine();
			numArray[i] = new int[i+1];
			for (int j = 0; j <= i; j++)
				numArray[i][j] = scan.nextInt();
		}
		return numArray;
	}

} // class