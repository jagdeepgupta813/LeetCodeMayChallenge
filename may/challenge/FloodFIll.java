package practiceJava.leetcode.may.challenge;

/*
 * An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).

Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, 
and a pixel value newColor, "flood fill" the image.

To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, 
plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. 
Replace the color of all of the aforementioned pixels with the newColor.

At the end, return the modified image.

 */



public class FloodFIll {

	public static void main(String[] args) {
		FloodFIll f = new FloodFIll();
		int [][] image=new int[][]{{0,0,0},{0,1,1}};
		int sr=1;
		int sc=1;
		int newColor=1;
		image=f.floodFill(image, sr, sc, newColor);
		for(int i=0; i<image.length; i++) {
			for(int j=0; j<image[0].length; j++) {
				System.out.print(image[i][j]);
			}
			System.out.println();
		}

	}
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		int color=image[sr][sc];
		
		if(color==newColor)
			return image;
		//dfs(image, image.length, image[0].length,sr, sc, color, newColor);
		dfs1(image, sr, sc, newColor, color);
    
		return image;
    }
	
	public void dfs(int[][] image,int length, int width, int r, int c, int color, int newColor) {
		
		if(r<length&& r>=0 && c<width&& c>=0 && image[r][c]==color) {
			image[r][c]=newColor;
			dfs(image, length, width, r+1,c, color, newColor);
			dfs(image, length, width, r-1,c, color, newColor);
			dfs(image, length, width, r,c+1, color, newColor);
			dfs(image, length, width, r,c-1, color, newColor);			
			
		}
		/*
		 * for(int i=0; i<image.length; i++) { for(int j=0; j<image[0].length; j++) {
		 * System.out.print( image[i][j]); } System.out.println(); }
		 */
	}
	
	private void dfs1(int [][] image, int sr,int sc, int newColor, int color){
        // base case
        if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color) return;
        image[sr][sc] = newColor;
        // Initiate a directions array
        int [][] dirs = new int[][] {{0,1}, {1,0}, {-1,0}, {0,-1}};
        for(int [] dir : dirs){
            int i = dir[0] + sr;
            int j = dir[1] + sc;
            // recurse on all neigbors.
            dfs1(image, i, j , newColor, color);
        }
    }
	
	public int[][] floodFill1(int[][] image, int sr, int sc, int newColor) {
        int oColor = image[sr][sc];
        if (oColor == newColor) {
            return image;
        }
        int[][] dir = new int[][]{{0, 1},{0, -1},{1, 0},{-1, 0}};
        image[sr][sc] = newColor;
        for (int i = 0; i < dir.length; i ++) {
            int nextX = sr + dir[i][0];
            int nextY = sc + dir[i][1];
            if (nextX < 0 || nextX >= image.length || nextY < 0 || nextY >= image[0].length) {
                continue;
            }
            if (image[nextX][nextY] != oColor) {
                continue;
            }
            floodFill(image, nextX, nextY, newColor);
        }
        return image;
    }


}
