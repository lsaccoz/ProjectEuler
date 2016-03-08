import java.math.BigInteger;

public class Problem25 {

	public static void main(String[] arguments) {

		BigInteger n1 = new BigInteger("1");
		BigInteger n2 = new BigInteger("1");
		int index = 2;
		while (true) {
			BigInteger temp = n2;
			n2 = n2.add(n1); index++;
			if (n2.toString().length() >= 1000) break;
			n1 = temp;
		}
		System.out.println("index: " + index);

	}

}