package practiceJava.leetcode.may.challenge;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
 * Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.

Each person may dislike some other people, and they should not go into the same group. 

Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.

Return true if and only if it is possible to split everyone into two groups in this way.

 
 */
public class PossibleBipartition {

	public static void main(String[] args) {
		PossibleBipartition p = new  PossibleBipartition();
		int [][]dislikes = new int[][] {{1,2},{3,2}, {1,3}};
		System.out.println(p.possibleBipartition(3, dislikes));

	}
	
	
	/* 
	 * create an adjacency list to keep people which a person does not like
	 * then create three group  0 -- not grouped yet, 1 -- grouped in 1, 2 - grouped in 2
	 * initially all would be single i.e not yet in any group, process a loop over the dislikes array 
	 * pick up an entry , add one person in one group and the person which it does not like in other group
	 * add the person in a queue which would be repeatedly   process until empty, 
	 * and check if the person which are in its adjacency list has not been grouped yet, then put those in different group
	 * otherwise, if  those has been already grouped and are in same as the current person group, then return false 
	 * if all the loop runs fine and we are able to group person in different groups, then return true in the end.  
	*/
	public boolean possibleBipartition(int N, int[][] dislikes) {
		boolean isPossible=true;
		if(dislikes==null || dislikes.length <2)
			return isPossible;
		List<List<Integer>> graph = new ArrayList<List<Integer>>(); 
		int[] group=new int[N+1]; // by default all would be grouped to 0
		
		// add N adjancy lists
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<Integer>());
		}

		//create an adjaceny list 
		for(int i=0; i<dislikes.length; i++) {
			graph.get(dislikes[i][0]).add(dislikes[i][1]);  //get one person and add other in its dislike list
			graph.get(dislikes[i][1]).add(dislikes[i][0]); 
		}

		// maintain a queue like DFS to group the persons in different group
		Queue<Integer> q = new LinkedList<>(); 

		for(int i=0; i<=N; i++) {
			if(group[i]==0) {   // it means person is not gruped yet
				group[i]=1;
				q.add(i);  // add the grouped person in queue to process further
			}

			while(!q.isEmpty()) {
				int p=q.poll();
				for(int j : graph.get(p)) {
					if(group[j]==0) {
						if(group[p]==1) {
							group[j]=2;
						}else
							group[j]=1;
						q.add(j);
					}else if(group[j]==group[p])
						return false;
				}
			}
		}

		return isPossible;
	}

}
