package practiceJava.leetcode.may.challenge;

/*
 * You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point.
 *  Check if these points make a straight line in the XY plane. 
 */

public class StraightLineCheck {

	public static void main(String[] args) {
		StraightLineCheck s = new StraightLineCheck();
		int [][]points = new int[][] {{1,1},{2,2},{-3,-3},{4,4}};
		System.out.println(s.checkStraightLine(points));

	}

	public boolean checkStraightLine(int[][] coordinates) {
    
		if(coordinates.length<=2)
			return true;
		
		int x1, x2, x3;
		int y1, y2, y3;
		x1=coordinates[0][0];
		x2=coordinates[1][0];
		x3=coordinates[2][0];
		y1=coordinates[0][1];
		y2=coordinates[1][1];
		y3=coordinates[2][1];
		
		
		boolean result=true;
		for(int i=2; i<coordinates.length; i++) {
			x3=coordinates[i][0];
			x2=coordinates[i-1][0];
			x1=coordinates[i-2][0];
			
			y1=coordinates[i-2][1];
			y2=coordinates[i-1][1];
			y3=coordinates[i][1];
			
			if((y2-y1)*(x3-x2)!=(y3-y2)*(x2-x1))
				return false;
			
		}
		return result;
    }
}
