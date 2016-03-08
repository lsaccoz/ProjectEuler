public class Problem28 {

	public static void main(String[] args) {

		long num = 1, sum = 1;
		for (long k = 2; k <= 1000; k += 2)
			for (long n = 0; n < 4; n++)
				{ num += k; sum += num; }
		System.out.println(sum);

	}

}