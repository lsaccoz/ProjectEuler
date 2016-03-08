import java.util.HashSet;

public class Problem21 {

    public static void main(String[] args) {
        double START_TIME = System.nanoTime();
        
        HashSet<Long> used = new HashSet<Long>();
        long N = 10000;
        long sum = 0;
        for (long n = 1; n < N; n++) {
        	if (used.contains(n)) continue;
        	long d_n = d(n);
        	long d_n_d_n = d(d_n);
        	if (n == d_n_d_n && n != d_n) {
        	   	if (n < N) {
        	   		used.add(n); sum += n; }
        	   	if (d_n < N) {
        	   		used.add(d_n); sum += d_n; }
        	}
        }
        
	    double ELAPSED_TIME = System.nanoTime() - START_TIME;
	           ELAPSED_TIME /= 1000000000; // seconds

	    System.out.println("Answer = " + sum);
	    System.out.println("Execution time: "+ELAPSED_TIME+"s");
    }

    public static long d(long n) {
        long d_n = 0;
        for (long i = 1; i <= n/2; i++)
            if (n % i == 0)
            	d_n += i;
        return d_n;
    }

}