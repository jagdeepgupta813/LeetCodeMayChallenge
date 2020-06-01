package practiceJava.leetcode.may.challenge;

/*
 *Given a circular array C of integers represented by A, find the maximum possible sum of a non-empty subarray of C.

Here, a circular array means the end of the array connects to the beginning of the array.  
(Formally, C[i] = A[i] when 0 <= i < A.length, and C[i+A.length] = C[i] when i >= 0.)
Also, a subarray may only include each element of the fixed buffer A at most once.  
(Formally, for a subarray C[i], C[i+1], ..., C[j], 
there does not exist i <= k1, k2 <= j with k1 % A.length = k2 % A.length.) 
 */


/*
 * Get maximum Sum to local element and also the minimum Sum
 * in the end, return the maximum of maxSum vs total-minSum , because that can be the maximum sum adding in a circle otherwise
 * but if the maximumSUm itself is <0, then return max sum because it will be 0 otherwise when we subtract minSum from total so the answer will not be justified
 */
public class MaximumSumCircularSubarray {

	public static void main(String[] args) {
		MaximumSumCircularSubarray m = new MaximumSumCircularSubarray();
		int A[]=new int[] {-2,-3,-1};
		System.out.println(m.maxSubarraySumCircular(A));

	}
	public int maxSubarraySumCircular(int[] A) {
		if(A.length<1)
			return Integer.MIN_VALUE ;
		
		int globalMax=A[0], localMax=A[0];
		int localMin=A[0], globalMin=A[0];
		int total=A[0];
		for(int i =1; i<A.length; i++) {
			total+=A[i];
			localMax=Math.max(A[i],localMax+A[i]);
			if(localMax>globalMax)
				globalMax=localMax;
			
			localMin=Math.min(A[i], localMin+A[i]);
			if(localMin<globalMin)
				globalMin=localMin;						
		}		
		int circularMax=total-globalMin;
		//System.out.println("Global Min " + globalMin + " global Max "+ globalMax + " circularMax" + circularMax);
		
		
		return globalMax>0? Math.max(globalMax,circularMax):globalMax;
	}

}
