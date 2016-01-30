import java.util.*;

public class Problem3 {
    
    public static final double EPSILON = 0.0000001;

    public static void main(String[] args) {
        double N = 600851475143.0;
        System.out.println("Largest prime factor of "+N+" is "+(int)findLargestPrime(N));
    }
    
    public static double findLargestPrime(double n) {
        List<Double> primeFactors = new ArrayList<Double>();
        if (Math.abs(n-1.0) < EPSILON) { 
            return 1.0;
        }
        for (double i = 2.0; i <= n+EPSILON; i += 1.0) {
            if (Math.floorMod((long)n,(long)i) < EPSILON && isPrime(i)) {
                primeFactors.add(i);
                n /= i;
                i += -1.0;;
            }
        }
        System.out.println(primeFactors);
        return primeFactors.get(primeFactors.size()-1);
    }
    
    public static boolean isPrime(double n) {
        if (Math.abs(n-2.0) < EPSILON) { return true; }
        else if (Math.floorMod((long)n, (long)2) < EPSILON) { return false; }
        else {
        for (double i = 3.0; i < n; i += 2.0) {
            if (Math.floorMod((long)n, (long)i) < EPSILON) { return false; }
        }
        return true;
        }
    }
    
    
}
