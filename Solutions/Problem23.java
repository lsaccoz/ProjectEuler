//import java.util.Set;
import java.util.ArrayList;

public class Problem23 {

	public static void main(String[] args) {

		ArrayList<Integer> abundantNums = new ArrayList<Integer>();
		for (int i = 1; i <= 28123; i++)
			if (isAbundant(i))
				abundantNums.add(i);

		int sumAbundant = 276; // 1+2+3+...+22+23

		for (int i = 24; i <= 28123; i++) {
			if (cantBeSumOf2Abundants(i, abundantNums)) {
				sumAbundant += i;
			}
		}

		System.out.println("sum = " + sumAbundant);

	}

	public static boolean isAbundant(int x) {
		int sum = x & 1;
		if (sum == 1) { // odd
			for (int i = 3; i <= x/2; i += 2) {
				if (x % i == 0) {
					sum += i;
					if (sum > x) return true;
				}
			}
		}
		else {
			sum = 1;
			for (int i = 2; i <= x/2; i++) {
				if (x % i == 0) {
					sum += i;
					if (sum > x) return true;
				}
			}
		}
		return false;
	}

	public static boolean cantBeSumOf2Abundants(int n, ArrayList<Integer> nums) {
		int sum;
		for (int i = 0; i < nums.size(); i++) {
			sum = nums.get(i);
			if (sum > n) return true;
			for (int j = 0; j < nums.size(); j++) {
				int temp = nums.get(j);
				// if (temp > n) break;
				sum += temp;
				if (sum > n) break;
				else if (sum == n) return false;
				else sum -= temp;
			}
		}
		return true;

	}

}
