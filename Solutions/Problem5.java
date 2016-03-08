import java.util.*;

public class Problem5 {
    
    public static void main(String[] args) {
        int MIN = 1;
        int MAX = 20;
        System.out.println("Fast Answer = " + findSmallestMultiplePRIMES(MIN, MAX));
    }
    
    // MORE MATHEMATICAL (and faster) APPROACH USING PRIME FACTORIZATION
    public static int findSmallestMultiplePRIMES(int low, int high) {
        Map<Integer, ArrayList<Integer>> primeFactors = new TreeMap<Integer, ArrayList<Integer>>();
        int multiple = 1;
        
        for (int i = low; i <= high; i++)
            primeFactors.put(i, primeFactorization(i));
        
        Set<Integer> listOfFactors = new TreeSet<Integer>();
        for (ArrayList<Integer> l : primeFactors.values()) {
            for (Integer i : l) {
                if (!listOfFactors.contains(i)) {
                    listOfFactors.add(i);
                }
            }
        }
        
        for (Integer x : listOfFactors) {
            int maxCount = 0;
            for (int i = low; i <= high; i++) {
                int tempCount = 0;
                for (Integer y : primeFactors.get(i)) {
                    if (y.equals(x)) {
                        tempCount++;
                    }
                }
                if (tempCount > maxCount) {
                    maxCount = tempCount;
                }
            }
            
            multiple *= Math.pow(x,maxCount);
        }
        
        return multiple;
    }
    
    // HELPER METHOD FOR MATHEMATICAL APPROACH
    // precondition: n is more than 0
    public static ArrayList<Integer> primeFactorization(int n) {
        
        ArrayList<Integer> primeFactors = new ArrayList<Integer>();
        if (n == 1) { 
            primeFactors.add(1);
            return primeFactors;
        }
        for (int i = 2; i <= n; i++) {
            if (n % i == 0 && isPrime(i)) {
                primeFactors.add(i);
                n /= i;
                i--;
            }
        }
       
        return primeFactors;
    }
    
    // HELPER METHOD FOR MATHEMATICAL APPROACH
    // precondition: n is more than 1
    public static boolean isPrime(int n) {
        if (n == 2) { return true; }
        else if (n % 2 == 0) { return false; }
        else {
        for (int i = 3; i < n; i += 2) {
            if (n % i == 0) { return false; }
        }
        return true;
        }
    }
    
    
} // close Multiples class
