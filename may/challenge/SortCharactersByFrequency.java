package practiceJava.leetcode.may.challenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*Given a string, sort it in decreasing order based on the frequency of characters.*/

public class SortCharactersByFrequency {

	public static void main(String[] args) {
		SortCharactersByFrequency s = new SortCharactersByFrequency();
		System.out.println(s.frequencySort("eetraa"));
		System.out.println(s.freqSort("ssdfd"));

	}
    public String frequencySort(String s) {
    	if(s==null || s.isEmpty())
    		return "";
        PriorityQueue<Map.Entry<Character, Integer>> p = new PriorityQueue<Map.Entry<Character,Integer>>((a,b)->b.getValue()- a.getValue());
        Map<Character, Integer> mp = new HashMap<>();
        for(char c:s.toCharArray()) {
        	mp.put(c, mp.getOrDefault(c, 0)+1);
        }
        p.addAll(mp.entrySet());
        StringBuilder sb = new StringBuilder();
        while(!p.isEmpty()) {
        	Map.Entry e= p.poll();
        	for(int i=0; i<(int)e.getValue();i++) {
        		sb.append(e.getKey());
        	}
        }
		
        return sb.toString();
    	
    }
    
    public String freqSort(String s) {
    	StringBuffer sb = new StringBuffer();
    	
    	int[] freq= new int[256];
    	for(char c:s.toCharArray()) {
    		freq[(int)c]++;
    	}
    	int x=0;
    	while(x<s.length()) {
    		int index=-1, max=0;
    	for(int i=0;i<freq.length; i++) {
    		
    		if(max<freq[i]) {
    			index=i;
    			max=freq[i];
    		}
    	}
    	
    	if(max==0) {
    		return sb.toString();
    	}
    	
    	while(max>0) {
    		sb.append((char)index);
    		max--;
    		x++;
    	}
    	}
    	
    	return sb.toString();
    }

}
