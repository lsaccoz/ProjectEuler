public class Problem1 {

	public static void main(String[] args) {
		long n = 1000, sum = 0;
		for (int i = 1; i < n; i++) {
			if (i % 3 == 0 || i % 5 == 0)
				sum += i;
		}
		System.out.println(sum);
	}

}