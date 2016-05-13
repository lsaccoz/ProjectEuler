public class random {
	
	public static void main(String[] args) {

		if (args.length != 2) {
			System.out.println("Usage: random <lower> <upper>");
			return;
		}

		int x1 = strToInt(args[0]);
		int x2 = strToInt(args[1]);

		if (x1 <= -1 || x2 <= -1) {
			System.out.println("Use correct formats for arguments");
			return;
		}
		if (x1 > x2) {
			System.out.println("First argument must be less than the second");
			return;
		}
		if (x1 == x2) {
			System.out.println(x1);
			return;
		}

		int rand = (int) ( Math.random()*(x2-x1+1) + x1 );
		System.out.println(rand);

	}

	/* string must be formatted correctly, else returns -1 */
	public static int strToInt(String str) {
		int ten = 1;
		int num = 0;
		for (int i = str.length()-1; i >= 0; i--) {
			char cnum = str.charAt(i);
			switch (cnum) {
				case '0':               break;
				case '1': num += ten;   break;
				case '2': num += 2*ten; break;
				case '3': num += 3*ten; break;
				case '4': num += 4*ten; break;
				case '5': num += 5*ten; break;
				case '6': num += 6*ten; break;
				case '7': num += 7*ten; break;
				case '8': num += 8*ten; break;
				case '9': num += 9*ten; break;
				default: return -1;
			}
			ten *= 10;
		}
		return num;
	}

}