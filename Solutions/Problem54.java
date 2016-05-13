import java.io.File;
import java.util.Scanner;

public class Problem54 {

	private class PokerHand {
		
		// first column of ith row is number
		// second column of ith row is suit
		public int hand[][];
		public int rank = 0;

		public PokerHand(String string_hand) {
			hand = new int[5][2];
			for (int i = 0, j = 0; i < 5; i++, j++) {
				int value = string_hand.charAt(j++);
				switch (value) {
					case 'T': hand[i][0] = 10; break;
					case 'J': hand[i][0] = 11; break;
					case 'Q': hand[i][0] = 12; break;
					case 'K': hand[i][0] = 13; break;
					case 'A': hand[i][0] = 14; break;
					default:  hand[i][0] = value -48;
				}
				hand[i][1] = string_hand.charAt(j++);
				// making sure it is sorted for easier comparisons later
				for (int index = i; index > 0; index--) {
					if (hand[index][0] < hand[index-1][0]) {
						int temp_value = hand[index-1][0];
						int temp_suit  = hand[index-1][1];
						hand[index-1][0] = hand[index][0];
						hand[index-1][1] = hand[index][1];
						hand[index][0] = temp_value;
						hand[index][1] = temp_suit;
					}
				}
			}
			
		}

		public void printHand() {
			System.out.print("( ");
			for (int i = 0; i < 5; i++)
				System.out.print(hand[i][0] +""+ (char) hand[i][1] + " ");
			System.out.println(")");
		}

		/* Returns true if 'this' is a winning hand
		 * and false if 'that' is a better hand
		 */
		public boolean compareHands(PokerHand that) {
			if (this.hasRoyalFlush()) return true;
			if (that.hasRoyalFlush()) return false;
			int thisSFLUSH = this.hasStraightFlush();
			int thatSFLUSH = that.hasStraightFlush();
			if (thisSFLUSH != 0 || thatSFLUSH != 0)
				return (thisSFLUSH > thatSFLUSH) ? true : false;
			int thisFOUR = this.hasFourOfAKind();
			int thatFOUR = that.hasFourOfAKind();
			if (thisFour != 0 || thatFOUR != 0)
				return (thisFOUR > thatFOUR) ? true : false;
			int[] thisFHOUSE = this.hasFullHouse();
			int[] thatFHOUSE = that.hasFullHouse();
			if (thisFHOUSE[0] != )

		}

		// returns an array describing the pairs of the hands
		// the first (0th) element of that array indicates how many pairs
		// the possilbe next two values indicates which cards they are.
		// if no pairs exist, the array will be of form {0, -1 ,-1}
		// if one pairs exists, it will be of the form {1, a, -1}
		// if two pairs exists, it will be of the form {2, a, b}
		public int[] howManyPairs() {
			int[] ret = {0,-1,-1};
			for (int i = 4, j = 1; i >= 1; i--)
				if (hand[i-1][0] == hand[i][0])
					{ ret[0]++; ret[j++] = hand[i][0]; i--; }
			return ret;
		}

		// returns the value of the three cards that are of a kind
		// returns 0 if it has none.
		public int hasThreeOfAKind() {
			for (int i = 4; i >= 2; i--)
				if (hand[i][0] == hand[i-1][0] && hand[i][0] == hand[i-2][0])
					return hand[i][0];
			return 0;
		}

		// returns an array of size 2.
		// the first element has the value of the pair
		// the second element has the value of the triple.
		// if no full house, returns {-1, -1}
		public int[] hasFullHouse() {
			int[] pairs = howManyPairs();
			if (pairs[0] != 1) return {-1. -1};
			int three = hasThreeOfAKind();
			if (three == 0) return {-1, -1};
			return {pairs[1], three};
		}

		// similar to three of a kind
		public int hasFourOfAKind() {
			for (int i = 4; i >= 3; i--)
				if (   hand[i][0] == hand[i-1][0]
			    	&& hand[i][0] == hand[i-2][0]
			    	&& hand[i][0] == hand[i-3][0]   )
					return hand[i][0];
			return 0;
		}

		public boolean hasFlush() {
			for (int i = 0; i < 4; i++)
				if (hand[i][1] != hand[i+1][1])
					return false;
			return true;
		}

		// returns highest number in the straight.
		// returns 0 if no straight
		public int hasStraight() {
			if (hand[4][0] == 14 && hand[0][0] == 2) { // 2, .. , .. , .. , A
				for (int i = 1; i < 4; i++)
					if (hand[i][0] != i+2)
						return 0;
				return hand[3][0];
			} else {
				for (int i = 0; i < 4; i++)
					if (hand[i][0] != hand[i+1][0]-1)
						return 0;
			}
			return hand[4][0];
		}

		// retursn whether or not it has a straight flush
		public boolean hasRoyalFlush() {
			return hand[0][0] == 10 && hasStraightFlush() == 14 
		}

		// returns the highest number in the straight flush
		// if no straight flush, then returns 0.
		public boolean hasStraightFlush() {
			if (!hasFlush()) return 0;
			return hasStraight();
		}

	}

	/* read poker.txt and calculate how many times player 1 wins.
	 * prints answer and returns the execution time.
	 */
	public double printAnswer() throws Exception {
		Scanner scanFile = new Scanner(new File("poker.txt"));
		// first column of ith row is player 1's hand
		// second column of ith row is player 2's hand
		PokerHand pokerhands[][] = new PokerHand[1000][2];
		for (int i = 0; i < 1000; i++) {
			String handFile = scanFile.nextLine();
			pokerhands[i][0] = new PokerHand(handFile.substring(0, 14));
			pokerhands[i][1] = new PokerHand(handFile.substring(15, 29));
		} scanFile.close();

		double time = System.nanoTime();
		
		int ans = 0;
		for (int i = 0; i < 1000; i++)
			if ( pokerhands[i][0].compareHands(pokerhands[i][1]) )
				ans++;

		// for(int i = 0; i < 1000; i++) {
		// 	pokerhands[i][0].printHand();
		// 	pokerhands[i][1].printHand();
		// 	System.out.println();
		// }

// ============== testing space! ==================

			// System.out.println( (new PokerHand("TH JH QH AH 3H")).hasRoyalFlush() );
			// System.out.println( (new PokerHand("4H 3H 6H QS 7H")).hasFlush() );
			// System.out.println( (new PokerHand("2C 3H 5H 4S AH")).hasStraight() );
			// System.out.println( (new PokerHand("2C AH 4H 4S AH")).howManyPairs()[0] );
			System.out.println( (new PokerHand("AC 2H 2H 2S TH")).hasFourOfAKind() );

// ================================================

		time = (System.nanoTime() - time)/1000000; // ms

		System.out.println("Player 1 wins " + ans + " times");
		
		return time;
	}

	public static void main(String[] args) throws Exception {
		double answerTime = (new Problem54()).printAnswer();
		System.out.println("Execution time: " + answerTime + " ms.");
	}

}