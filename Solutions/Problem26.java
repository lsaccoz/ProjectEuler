public class Problem26 {

	public static void main(String[] args) {

		double startExecTime = System.nanoTime();
		// n is number itself, k is the reccurence
		int max_n = 1, max_k = 0, D = 1000;
		for (int n = D-1; n >= 1; n--) {
			if (max_k > n) break;
			if (n % 2 == 0 || n % 5 == 0) continue;
			int a_k = 10 % n;
			int mod10Num = 10 % n;
			for (int k = 2; k < n; k++) { // a = 10
				a_k = (a_k*(mod10Num)) % n;
				if (a_k == 1) {
					if (k > max_k) {
						max_k = k;
						max_n = n;
					}
					break;
				} 
			}
		}
		double time = (System.nanoTime()-startExecTime)/1000000; // milliseconds

		// display answer
		System.out.println("The fraction under 1/" + D + " which "+
			                "contains\nthe highest number of recurring"+
			                " decimals is:\n1/"+max_n+"  ->  " + max_k +
			                " recurring decimals.\nExec time: "+time+" ms.");

	}

}