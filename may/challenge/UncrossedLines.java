package practiceJava.leetcode.may.challenge;

/*
 * We write the integers of A and B (in the order they are given) on two separate horizontal lines.

Now, we may draw connecting lines: a straight line connecting two numbers A[i] and B[j] such that:

A[i] == B[j];
The line we draw does not intersect any other connecting (non-horizontal) line.
Note that a connecting lines cannot intersect even at the endpoints: each number can only belong to one connecting line.

Return the maximum number of connecting lines we can draw in this way.
 */

public class UncrossedLines {

	public static void main(String[] args) {
		UncrossedLines u = new UncrossedLines();
		int[]A=new int[] {1,4,2};
		int[]B= new int[] {1,2,4};
		System.out.println(u.maxUncrossedLines(A, B));
		System.out.println("mera " + u.maxUncrossedLine(A, B));

	}
	
	/*logic is to see if the two points are equal, then we just add 1 to the previous count 
	 * otherwise, we will try to find out if the point next in A side or B side are matching	 * 
	 */
	
	public int maxUncrossedLines(int[] a, int[] b) {
        int m = a.length, n = b.length;
        int[][] dp = new int[m+1][n+1];
        for(int i=1; i <= m; i++){
            for(int j=1; j <= n; j++){
                if(a[i-1] == b[j-1])
                    dp[i][j] = 1+dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[m][n];
    }
	
	public int maxUncrossedLine(int[] A, int[] B) {
		
		int[][]dp=new int[A.length+1][B.length+1];
		
		for(int i=1; i<A.length; i++) {
			for(int j=1; j<B.length; j++) {
				if(A[i]==B[j]) {
					dp[i][j]=dp[i-1][j-1]+1;
				}
				else
					dp[i][j]=Math.max(dp[i][j-1], dp[i-1][j]);
			}
		}
		return dp[A.length-1][B.length-1];
	}
}
