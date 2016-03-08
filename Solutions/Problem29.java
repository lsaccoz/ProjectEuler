import java.util.Set;
import java.util.HashSet;
import java.math.BigInteger;

public class Problem29 {

    public static void main(String[] args) {
        Set<BigInteger> set = new HashSet<BigInteger>();
        for (long a = 2; a <= 100; a++) {
	    BigInteger A = new BigInteger(a+"");
            for (int b = 2; b <= 100; b++) {
		BigInteger num = A.pow(b);
		if (!containsBigInteger(set, num))
		    set.add(num);
	    }
	}
	System.out.println(set.size());
    }

    private static boolean containsBigInteger(Set<BigInteger> set, BigInteger n) {
        for (BigInteger x : set )
	    if (x.equals(n))
	        return true;
	return false;
    }

}
