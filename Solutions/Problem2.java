public class Problem2 {

	public static void main(String[] args) {
		// does't use mod operator (%)
		int n = 4000000;
		int x = 1, y = 2;
		int sum = 0;
		while (x < n) {
			int temp = x & 1;
			if (temp == 0) sum += x;
			temp = y;
			y += x;
			x = temp;
		}
		System.out.println(sum);
	}

}