package practiceJava.leetcode.may.challenge;

/*
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. 
 * In other words, one of the first string's permutations is the substring of the second string.
 * Note:

The input strings only contain lower case letters.
The length of both given strings is in range [1, 10,000].
 */
public class PermutationinString {

	public static void main(String[] args) {
		PermutationinString p = new PermutationinString();
		String s1="leo";
		String s2="HelloJagdeep";
		System.out.println(p.checkInclusion(s1.toLowerCase(), s2.toLowerCase()));

	}
	public boolean checkInclusion(String s1, String s2) {
		boolean result=false;
		int s1Length=s1.length();
		int s2Length=s2.length();
		if(s2Length<s1Length)
			return result;
		char[] s1Chars=new char[256];  // as the input contains only lower case letters 
		char[] s2Chars=new char[256];
		int[] count = new int[26];
		
		for(int i=0; i<s1Length; i++) {
			s1Chars[s1.charAt(i)]++;
			s2Chars[s2.charAt(i)]++;
			count[s1.charAt(i) -'a']++;
			count[s2.charAt(i) -'a']--;
		}
		
		/*if(compareArray(s1Chars, s2Chars)) {
			result=true;
		}
		*/
		if(isEqual(count)) {
			result=true;
		}
		else {
			for(int i=s1Length; i<s2Length; i++) {
				s2Chars[s2.charAt(i-s1Length)]--;
				s2Chars[s2.charAt(i)]++;
				count[s2.charAt(i-s1Length) -'a']++;
				count[s2.charAt(i) -'a']--;
				
				if(isEqual(count)) {
					result=true;
					break;
				}
			}
		}
		return result;
        
    }
	
	boolean compareArray(char[] c1, char[]c2) {
		boolean equals=true;
		for(int i=0; i<c1.length; i++) {
			if(c1[i]!=c2[i]) {
				equals=false;
				break;
			}
		}
		return equals;
	}
	
	boolean isEqual(int[] charCounts) {
		boolean isequal=true;
		for(int i=0; i<charCounts.length; i++) {
			if(charCounts[i]!=0) {
				isequal=false;
				break;
			}
		}
		return isequal;
	}

}
