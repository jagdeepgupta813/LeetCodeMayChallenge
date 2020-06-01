package practiceJava.leetcode.may.challenge;

import java.util.ArrayList;
import java.util.List;

/*
 * Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.

(Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.  
The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval. 
 For example, the intersection of [1, 3] and [2, 4] is [2, 3].)
 */

/*Logic : 
 * if there is no overlap then the max of one would be less than min of other 
 * else the common interval would be max of minimum of both and min of maximum of both 
 */
public class IntervalListSections {

	public static void main(String[] args) {

		int[][]A = {{0,2}};
		int[][]B = {{8,12}};
		IntervalListSections s = new IntervalListSections();
		int [][] result=s.intervalIntersection1(A, B);
		
		  for(int i=0; i<result.length; i++) { System.out.println(result[i][0] + " , "
		  + result[i][1]); }
		 

	}
	public int[][] intervalIntersection1(int[][] A, int[][] B) {
		
			List<int[]> results= new ArrayList<int[]>();
			int a=0;
			int b=0;
			while(a<A.length && b<B.length) {
				int left=Math.max(A[a][0], B[b][0]);
				int right=Math.min(A[a][1], B[b][1]);
				if(left<=right) {
					results.add(new int[] {left, right});
				}
				if(A[a][1]<B[b][1]) {
					a++;
				}
				else if(A[a][1]>B[b][1])
					b++;
				else {
					a++; b++;
				}
					
			}
			
			return results.toArray(new int[results.size()][]);
			
	}
	public int[][] intervalIntersection(int[][] A, int[][] B) {
		if(A.length < 1 || B.length<1)
			return new int[][] {};
			
			int a=0;
			int b=0;
			List<List<Integer>> results=new ArrayList<List<Integer>>();
			
			while(a<A.length && b<B.length) {
				if(A[a][0]>B[b][1] )
					b++;
				else if(A[a][1]<B[b][0])
				a++;
				else {
					int left=Math.max(A[a][0], B[b][0]);
					int right=Math.min(A[a][1], B[b][1]);
					List<Integer> interval=new ArrayList<Integer>();
					interval.add(left);
					interval.add(right);
					results.add(interval);
					if(A[a][1]==right)
						a++;
					else
						b++;
				}
			}
			System.out.println(results);
			int[][] intervals=new int[results.size()][2];
			for(int i=0; i<results.size(); i++) {
				intervals[i][0]=results.get(i).get(0);
				intervals[i][1]=results.get(i).get(1);
			}
			return intervals;	
    }
	
	

}
