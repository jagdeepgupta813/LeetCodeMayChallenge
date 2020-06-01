package practiceJava.leetcode.may.challenge;

import java.util.Stack;

public class CheckValidBSTFromPreorder {

	public static void main(String[] args) {
		int pre[] = new int[]{40, 30, 35, 80, 100};
		System.out.println(isValidPreorder(pre, pre.length));

	}
	
	static  boolean isValidPreorder(int pre[], int n) {
		   Stack<Integer> stk= new Stack<Integer>();
		   int root = Integer.MIN_VALUE;
		   for (int i=0; i<n; i++) {
		      if (pre[i] < root)
		         return false;
		      while (!stk.isEmpty()&& stk.peek()<pre[i]) {
		         root = stk.peek();
		         stk.pop();
		      }
		      stk.push(pre[i]);
		   }
		   return true;
		}

}
