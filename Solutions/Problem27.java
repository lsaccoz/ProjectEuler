public class Problem27 {

	public static void main(String[] arguments) {

		double time = System.nanoTime();

		long max_numPrimes = 0;
		long good_a = 0, good_b = 0;

		for (long a = -999; a <= 999; a++)
			for (long b = -999; b <= 999; b++) {
				long numPrimes = numPrimesEq(a,b);
				if (numPrimes > max_numPrimes) {
					max_numPrimes = numPrimes;
					good_a = a; good_b = b;
				}
			}

		time = (System.nanoTime() - time)/1000000; // ms

		System.out.println("Polynomial is n^2 + (" + good_a + ")n + ("+  good_b +")");
		System.out.println("Product of coefficients (answer) is: " + good_a*good_b);
		System.out.println(max_numPrimes + " consecutive primes");
		System.out.println("Exec Time: " + time + " milliseconds");

	}

	public static long solvePoly(long coeff_a, long coeff_b, long n){
		return n*n + coeff_a*n + coeff_b;
	}

	public static long numPrimesEq(long a, long b) {
		long numPrimes = 0;
		for (long n = 0; true; n++) {
			if (isPrime(solvePoly(a,b,n))) numPrimes++;
			else break;
		}
		return numPrimes;
	}

	public static boolean isPrime(long n) {
		if (n <= 1) return false;
		if (n == 2) return true;
		if (n % 2 == 0) return false;
		long up = (int) Math.sqrt(n);
		for (long i = 3; i < up; i += 2)
			if (n % i == 0)
				return false;
		return true;
	}

}