package practiceJava.leetcode.may.challenge;

/*
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
 */

public class EditDistance {

	private static int[][]DP;
	public static void main(String[] args) {
		EditDistance e = new EditDistance();
		String word1="kitten";
		String word2="sitten";
		System.out.println(e.minDistance(word1, word2));
		e.printOperationsRequiredToEdit(word1, word2, e.DP);

	}


	public int minDistance(String word1, String word2) {
		int w1=word1.length();
		int w2=word2.length();
		int [][]dp=new int[w1+1][w2+1];

		for(int i=0; i<=w1; i++) {     // we are considering empty string as index 0 , so we will check till its full length
			for(int j=0; j<=w2; j++) {
				if(i==0)
					dp[i][j]=j;   // if length of word1 is 0 then we keep inserting characters of other string
				else if(j==0)
					dp[i][j]=i;
				else if(word1.charAt(i-1)==word2.charAt(j-1))
					dp[i][j]=dp[i-1][j-1];      // no operation required
				else                                          // all operations would be done on 1st string for making it easy
					dp[i][j]= 1+ minValue(dp[i][j-1],         // insert operation, if we insert a char at the end of i which is same as j then current i will be comparing with j-1 because char at j is already equal to i+1 now
							dp[i-1][j],                       // delete
							dp[i-1][j-1]);                    // replace
			}	
		}
		DP=dp;

		return dp[w1][w2];
	}
	
	private int minValue(int x, int y, int z) {
		if(x<=y && x<=z)
			return x;
		else if(y<=x && y<=z)
			return y;
		else
			return z;
	}
	private void printOperationsRequiredToEdit(String s1, String s2, int[][]dp) {
		int l=s1.length();
		int m=s2.length();
		while(l!=0 && m!=0) {
			if(s1.charAt(l-1)==s2.charAt(m-1)) {   // characters were same
				l--;
				m--;
			}
			else if(dp[l][m] == dp[l-1][m-1]+1) {   // means character in s1 were replaced with character in s2 at l-1
				System.out.println("Change the character at " +(l-1) + " "+ s1.charAt(l-1) + " to " + s2.charAt(m-1));    	
				l--;
				m--;
			}
			else if(dp[l][m] == dp[l-1][m]+1) {   
				System.out.println("Delete char at " + s1.charAt(l-1));
				l--;
			}
			else if(dp[l][m] == dp[l][m-1] + 1) {
				System.out.println("Add the character " + s2.charAt(m-1));
				m--;
			}
		}
		if(l>0)
			System.out.println("Delete characters " + s1.substring(0,l));

		if(m>0)
			System.out.println("Delete characters " + s2.substring(0,m));
	}
}
