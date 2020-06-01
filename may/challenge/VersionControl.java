package practiceJava.leetcode.may.challenge;


/*
 * You are a product manager and currently leading a team to develop a new product. 
 * Unfortunately, the latest version of your product fails the quality check. 
 * Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 * You are given an API bool isBadVersion(version) which will return whether version is bad. 
 * Implement a function to find the first bad version. You should minimize the number of calls to the API.
 */

/*Logic : Implement Binary search 
 * look for  left to middle value, if its false, then check current value , if that is true then current value is first version
 * if left is true, re run the search
 */
public class VersionControl {
	
	public boolean isBadVersion(int x) {
		if(x>=1)
		return true;
		else 
			return false;
	}
	
	
	public int firstBadVersion(int n) {
        //if(isBadVersion(n)) return n;
        int i=0, j =n, mid=0;
        while(i<=j){
            mid = i + (j-i) / 2;
            if(!isBadVersion(mid)) i = mid+1;
            else j = mid-1;
        }
        if(!isBadVersion(mid)) return mid+1;
        return mid;
    }

	public static void main(String[] args) {
		VersionControl vc = new VersionControl();
		long start=System.nanoTime();
		System.out.println(vc.firstBadVersion(5));
		long end=System.nanoTime();
		System.out.println("Time taken for firstBadVersion " + (end-start));
		
	}

}
