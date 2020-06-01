package practiceJava.leetcode.may.challenge;

import java.util.HashSet;
import java.util.Set;

/*
 * In a town, there are N people labelled from 1 to N.  
 * There is a rumor that one of these people is secretly the town judge.
If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given trust, an array of pairs trust[i] = [a, b] 
representing that the person labelled a trusts the person labelled b.
If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.
 */


public class FindTownJudge {

	public static void main(String[] args) {
		FindTownJudge f = new FindTownJudge();
		int [][] trust = new int[][] {};
		int N=1;
		System.out.println(f.findJudge4(N, trust));

	}
	
	 public int findJudge(int N, int[][] trust) {
		 int[] trusted= new int[N+1];
		 for(int[] t:trust) {
			 trusted[t[1]] ++;
			 trusted[t[0]]--;
		 }
		
		 for(int i=0; i<=N; i++) {
			 if(trusted[i]==N-1)
				 return ((i==0)?i+1:i);
		 }
		 
		 return -1;
	    }
	 
	 public int findJudge1(int N, int[][] arr) {
	        int[] trust = new int[N];
	        int[] trusted = new int[N];
	        for(int i = 0; i < arr.length; i++){
	            int a = arr[i][0]; 
	            int b = arr[i][1];
	            trust[a - 1]++;
	            trusted[b - 1]++;
	        }
	        for(int i = 0; i < N; i++){
	            if(trust[i] == 0 && trusted[i] == N - 1)
	                return i + 1;
	        }
	        return -1;
	    }
	 public static int findJudge4(int N, int[][] trust) {

	        int[] degree = new int[N+1];

	        for( int[] i : trust){
	            degree[i[0]]--;
	            degree[i[1]]++;
	        }

	        for( int i =1 ; i <= N ; i++)
	            if(degree[i] == N-1)
	                return i;


	        return -1;
	    }



}
