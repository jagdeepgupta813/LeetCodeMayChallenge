package practiceJava.leetcode.may.challenge;

/*
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
Some courses may have prerequisites, for example to take course 0 you have to first take course 1, 
which is expressed as a pair: [0,1]
Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
*/

/*
 * Check for Topological Sort in Algorithms section
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CourseSchedule {
	
	
	public boolean canFinish(int[][] prerequisites, int numCourses) {
		ArrayList[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList<Integer>();
        boolean[] memo = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if(!dfs(graph, visited, i, memo)) {
                return false;    
            }
        }
        return true;
    }

    private boolean dfs(ArrayList[] graph, boolean[] visited, int course, boolean[] memo){
        if (visited[course]) {
            return false;
        }
        
        if (memo[course]) {
            return true;
        }
        visited[course] = true;
        for (int i = 0; i < graph[course].size(); i++) {
            if (!dfs(graph, visited, (int)graph[course].get(i), memo)) {
                return false;
            }
        }
        visited[course] = false;
        memo[course] = true;
        return true;
    }

	
	public static void main(String ar[]) {
		CourseSchedule c = new CourseSchedule();
		int[][] prerequisites = new int[][] {{1,0}};
		
		System.out.println(c.canFinish(prerequisites, 2));
	}

}
