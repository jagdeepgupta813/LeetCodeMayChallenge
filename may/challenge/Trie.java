package practiceJava.leetcode.may.challenge;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/*
 * Implement a trie with insert, search, and startsWith methods.
Example 

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true

 */
public class Trie {
	TriNode start=new TriNode();
	
	public static void main(String[] args) {		
		Trie tr = new Trie();  System.out.println("found App "+ tr.searchh("app"));
		System.out.println("found starting with app "+ tr.startsWit("app"));
		System.out.println("found apple "+ tr.searchh("apple")); tr.insertt("app");
		System.out.println("found App "+ tr.searchh("app")); 

		tr.insertt("");
		System.out.println(tr.searchh("d"));
	}
	
	public void insertt(String word) {
		if(word.length()<1)
			return;
		if(start==null)
			start=new TriNode();		
		TriNode t=start;		
		for(int i=0; i<word.length(); i++) {
			if(!t.containsChild(word.charAt(i))) {
				t.setChild(word.charAt(i), new TriNode(word.charAt(i)));
			}
			t=t.getChild(word.charAt(i));
		}		
		t.setLeaf(true);
		System.out.println("Inserted word " + word + " marked its leaf value " +  t.getC() +  " to " + t.isLeaf);
	}
	
	public boolean searchh(String word) {
		TriNode t=getLastNode(word);
		if(t==null || !t.isLeaf)
			return false;

		return true;
	}
	
	private TriNode getLastNode(String prefix) {
		TriNode t=start;
		for(char c:prefix.toCharArray()) {
			if(t==null)
				return null;
			t=t.getChild(c);
		}
		return t;		
	}
	
	public boolean startsWit(String prefix) {
		TriNode t=getLastNode(prefix);
		if(t==null)
			return false;		
		return true;
	}
}
class TriNode{
	char c;
	
	TriNode childeren[];
	boolean isLeaf;
	
	public char getC() {
		return c;
	}
	
	public void setChild(int c, TriNode node) {
		childeren[c-'a']=node;
		
		//System.out.println("setting letter " + c);
	}
	
	public TriNode getChild(char c) {
		return this.childeren[c-'a'];
	}
	public boolean containsChild(char c) {
		
		return this.childeren[c-'a']!=null;
	}

	public boolean isLeaf() {
		return isLeaf;
	}

	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

	TriNode(){
		childeren=new TriNode[26];
		isLeaf=false;
	}
	TriNode(char c){
		this.c=c;
		childeren=new TriNode[26];
		isLeaf=false;
		
	}
}



