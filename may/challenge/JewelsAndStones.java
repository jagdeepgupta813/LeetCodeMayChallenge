package practiceJava.leetcode.may.challenge;

import java.util.HashSet;
import java.util.Set;

/*You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  
 * Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
The letters in J are guaranteed distinct, and all characters in J and S are letters. 
Letters are case sensitive, so "a" is considered a different type of stone from "A".
*/

public class JewelsAndStones {
    
	
	
	public int numJewelsInStones(String J, String S) {
		Set<Character> jewels= new HashSet<>();
		int result=0;
		for(char c:J.toCharArray()) {
			jewels.add(c);
		}
		
		for(char c:S.toCharArray()) {
			if(jewels.contains(c))
				result++;
		}
		
		return result;        
    }
	
	public static int numJewelsInStones1(String J, String S) {
	       int res=0;
	       for(char c : S.toCharArray()){
	           if(J.indexOf(c) != -1){
	               res++;
	           }
	       }
	       return res;
	   }

	
	public static void main(String[] args) {
		String J="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String S="AbbbaBbbdkjfkdhfdkdfkdhfkdhfkjdhdkhfjdhfdkhfkdA";
		JewelsAndStones js = new JewelsAndStones();
		
		long start=System.nanoTime();		
		System.out.println(js.numJewelsInStones(J,S));
		long end = System.nanoTime();
		System.out.println("numJewelsInStones " + (end-start));
		
		
		
		  start=System.nanoTime(); 
		  System.out.println(js.numJewelsInStones1(J,S)); 
		  end= System.nanoTime(); System.out.println("numJewelsInStones1 " + (end-start));
		 

	}

}
