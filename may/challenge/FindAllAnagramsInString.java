package practiceJava.leetcode.may.challenge;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lower-case English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.
 */
public class FindAllAnagramsInString {

	public static void main(String[] args) {
		FindAllAnagramsInString f = new FindAllAnagramsInString();
		String s="abab";
		String p="abab";
		System.out.println(f.findAnagrams(s,p));

	}
	public List<Integer> findAnagrams(String s, String p) {
		if(s.length()<1)
			return null;
		char [] countCharInS=new char[256];
		char [] countCharInP=new char[256];
		int pLength=p.length();
		int sLength=s.length();
		
		List<Integer> result= new ArrayList<Integer>();
		for(int i=0; i<pLength; i++) {
			countCharInP[p.charAt(i)]++;
			countCharInS[s.charAt(i)]++;
		}
		
		for(int j=pLength; j<sLength; j++) {
			if(compare(countCharInP, countCharInS))
				result.add(j-pLength);
			countCharInS[s.charAt(j)]++;
			countCharInS[s.charAt(j-pLength)]--;
		}
		if(compare(countCharInP, countCharInS))
			result.add(sLength-pLength);
		
		
		return result;
        
    }
	
	boolean compare(char [] arr1, char[] arr2) {
		boolean equals=true;
		for(int i=0; i<arr1.length; i++) {
			if(arr1[i]!=arr2[i]) {
				equals=false;
				break;
			}
		}
		return equals;
	}

}
