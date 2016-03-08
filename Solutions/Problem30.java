public class Problem30 {

	public static void main(String[] args) {

		double time = System.nanoTime();
		long sum = 0;
		for (long n = 10; n <= 354294; n++) { // 354294 = 6*9^5, which is a maximum
			if (getFifthPowerSumDigitsStrings(n) == n)
				sum += n;
		}
		time = (System.nanoTime()-time)/1000000; // ms
		System.out.println("answer (using Strings) = "+sum+"\nExecTime = " + time+"\n");

		time = System.nanoTime();
		sum = 0;
		for (long n = 10; n <= 354294; n++) { // 354294 = 6*9^5, which is a maximum
			if (getFifthPowerSumDigitsModulo(n) == n)
				sum += n;
		}
		time = (System.nanoTime()-time)/1000000; // ms
		System.out.println("answer (using Modulo) = "+sum+"\nExecTime = " + time);

	}

	public static long getFifthPowerSumDigitsStrings(long n) {
		long ans = 0;
		String num = n+"";
		for (int i = 0; i < num.length(); i++) {
			ans += power(num.charAt(i)-48,5);
		}
		return ans;
	}

	public static long getFifthPowerSumDigitsModulo(long n) {
		long ans = 0;
		while (n != 0) {
			ans += power(n % 10,5); // Here, n % 10 is every digit itself!
			n /= 10;
		}
		return ans;
	}

	public static long power(long b, long exp) {
		if (exp == 0) return 1;
		long ans = b;
		while (--exp > 0) ans *= b;
		return ans;
	}

}