public class Problem6 {

    public static void main(String[] args) {
        System.out.println("Answer = "+findSumSquareDifference(100));
    }
    
    public static int findSumSquareDifference(int N) {
        int sumOfSquares = 0;
        int squareOfTheSum = 0;
        
        for (int num = 1; num <= N; num++) {
            sumOfSquares += num*num;
            squareOfTheSum += num;
        }
	    squareOfTheSum *= squareOfTheSum;
        
        return squareOfTheSum-sumOfSquares;
    }
    
}
