import java.util.List;
import java.util.ArrayList;

public class Problem24 {
	//Problem 24

	public static void main(String[] args) {
		String nums = "0123456789";
		int PERMUTE = 1000000;

		double startTime = System.nanoTime();
		List<String> permutations = permuteString(nums);
		double elapsedTime = System.nanoTime() - startTime;
		System.out.println("exec time: " + elapsedTime/1000000000 + "s. ans: " + permutations.get(PERMUTE-1));
	}

	// size of permuation list is the factorial of the length of the string
	public static List<String> permuteString(String str) {
		List<String> list = new ArrayList<>();
		permuteString("", str, list);
		return list;
	}
	private static void permuteString(String pre, String str, List<String> list) {
		int n = str.length();
		if (n == 0) list.add(pre);
		else
			for (int i = 0; i < n; i++)
				permuteString(pre+str.charAt(i), str.substring(0,i)+str.substring(i+1, n), list);
	}

}
