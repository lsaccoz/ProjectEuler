import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Problem22 {

	public static final int ALPHABET_TO_NUM = 64; // based on ASCII values
	private static class StringArrayList extends ArrayList<String>{}

	public static void main(String[] args) throws FileNotFoundException {
		
		String[] names = getStringArrayFile("p22_names.txt");
		int sizeOfNames = names.length;

		double startTime = System.nanoTime();
		// ===========================================================================
		int namesScore = 0;	

		String[] sortedNames = alphabeticalSort(names, sizeOfNames);
		for (int i = 0; i < sizeOfNames; i++)
			namesScore += (i+1) * nameWorth(sortedNames[i]);

		// ===========================================================================
		double elapsedTime = (System.nanoTime()-startTime)/1000000000; // milliseconds
		System.out.println("total names score = " + namesScore);
		System.out.println("exec time = " + elapsedTime + " seconds");

	}

	public static String[] getStringArrayFile(String filename) throws FileNotFoundException {
		Scanner scan = new Scanner(new File(filename));
		String[] names = scan.nextLine().split("\",\"");
		names[0] = names[0].substring(1, names[0].length());
		names[names.length-1] = names[names.length-1].substring(0,names[names.length-1].length()-1);
		scan.close();
		return names;
	} 

	// assumes capitalized names (could be changed easily)
	public static int nameWorth(String name) {
		int worth = 0;
		for (int i = 0; i < name.length(); i++)
			worth += name.charAt(i) - ALPHABET_TO_NUM;
		return worth;
	}

	// assumes capitalized strings (could be changed easily)
	public static String[] alphabeticalSort(String[] strArray, int sizeArray) {
		List<String>[] list = new StringArrayList[26];
		for(int i = 0; i < 26; i++) list[i] = new StringArrayList();
		for (int i = 0; i < sizeArray; i++) {
			// names have at least one letter
			list[strArray[i].charAt(0)-ALPHABET_TO_NUM-1].add(strArray[i]);
		}

		// now build completely sorted array with reduced bubble sorts
		for (int i = 0, j = 0; i < 26; i++) {
			for (String str : list[i]) {
				strArray[j] = str;
				j++;
			}
		}
		//list.clear();

		bubbleSortAlpha(strArray, sizeArray);
		return strArray;
	}

	public static void bubbleSortAlpha(String[] array, int sizeArray) {
		boolean done = false;
		while (!done) {
			done = true;
			for (int i = 0; i < sizeArray-1; i++) {
				if (array[i].compareTo(array[i+1]) > 0) {
					String s = array[i];
					array[i] = array[i+1];
					array[i+1] = s;
					done = false;
				}
			}
		}
	}

}