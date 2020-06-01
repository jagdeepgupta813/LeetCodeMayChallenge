package practiceJava.leetcode.may.challenge;

/*
 * Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
 */

/* logic is to start from 1, 1 
 * 1) if value at that bottom right corner is 1 and the value at the other three corner is also 1 
 * then the value at that position would be be two as the position can make one additional square matrix 
 * if anyone of the corner is not 1, then it can not add a square
 * 2) Similarly when the value of row and column index increases, 
 * we can keep checking the other three corner and take the minimum of three corners and add to the current one
 * because if all other three corners are able to form a matrix of size n then, the bottom righ corner is going to add +1 if its also one.   
 * 
 */

public class CountSquareSubmatrices {

	public static void main(String[] args) {
		CountSquareSubmatrices c = new CountSquareSubmatrices();
		int[][]matrix=new int[][] {{1,0,1},
			  {1,1,1},
			  {1,1,1}};
		System.out.println(c.countSquares(matrix));

	}
	public int countSquares(int[][] matrix) {
        int total=0;
        for(int i =0; i<matrix.length; i++) {
        	
        	for( int j=0; j<matrix[0].length; j++) {
        			if(matrix[i][j]>0 && i>0 &&j>0) {
        				matrix[i][j]+=Math.min(Math.min(matrix[i-1][j], matrix[i][j-1]), matrix[i-1][j-1]);        				
        			}
        		total+=matrix[i][j];
        	}
        	
        }
        
        
		return total;
    }

}
