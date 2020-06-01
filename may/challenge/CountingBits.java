package practiceJava.leetcode.may.challenge;

import java.util.Arrays;

/*
 * Given a non negative integer number num. 
 * For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
 */


public class CountingBits {

	public static void main(String[] args) {
		
		CountingBits c = new CountingBits();
		int[] result=c.countBits1(128);
		for(int i:result) {
			System.out.print( i+ " ");
		}
		System.out.println();
		
	}
	
	public int[] countBits1(int num) {
	    int[] f = new int[num + 1];
	    for (int i=1; i<=num; i++) { 
	    	f[i] = f[i >> 1] + (i & 1);
	    	System.out.println("i "+ i +  " i & 1 " + (i & 1) +  " (i >> 1) " + (i >> 1)   );
	    }
	    
	    return f;
	}
	public int[] countBits(int num) {
		int[] result = new int[num+1];
		
		result[0]=0;
		for(int i=0; i<=num; i++) {
			int x=1<<i;
			if( x<=num) {
				result[x]=1;
			}else{
				break;
			}
		}
		int lastBinaryPosition=2;
		for(int i=3; i<=num; i++) {
			if(result[i]==1)
				lastBinaryPosition=i;
			else {
				result[i]=result[i-lastBinaryPosition] +1;				
			}
			
		}
		return result;
        
    }
	
	

}
