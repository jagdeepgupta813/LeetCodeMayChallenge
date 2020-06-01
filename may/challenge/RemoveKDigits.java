package practiceJava.leetcode.may.challenge;

import java.util.Stack;

/*
 * Given a non-negative integer num represented as a string, 
 * remove k digits from the number so that the new number is the smallest possible.

Note:
The length of num is less than 10002 and will be ≥ k.
The given num does not contain any leading zero.
 * 
 */
public class RemoveKDigits {

	public static void main(String[] args) {
		RemoveKDigits r = new RemoveKDigits();
		String num="10";
		int k=1;
		long start=System.nanoTime();
		System.out.println(r.removeKdigits(num, k));
		long end = System.nanoTime();
		
		System.out.println("time taken for removeKdigits " + (end-start)) ;
		start=System.nanoTime();
		System.out.println(r.removeKDigit(num, k));
		end=System.nanoTime();
		System.out.println("time taken for removeKDigit " + (end-start)) ;
	}
	
	public String removeKdigits(String num, int k) {
		String res = "";
		
		if(k>=num.length())
			return "0";
		int index=0;
		while(k>0 && k<num.length()-index) {
			int minIndex=index;
			for(int i=1; i<=k; i++) {
				if(num.charAt(i+index) < num.charAt(minIndex))
					minIndex=(i+index);
			}
			res += num.charAt(minIndex);
			k=k-(minIndex - index);
			index=minIndex+1;			
		}
		if(k==0) {
			res = res+num.substring(index);
		}
		while(res.length()>1 && res.charAt(0)=='0') {
			res=res.substring(1);
		}
		return res;
		
	}
	
	public String removeKDigit(String num, int k) {
		if(k==0)
			return num;
        if(k>=num.length()) 
        	return "0";
        int count=0;
        StringBuilder sb=new StringBuilder(); 
        Stack<Integer> stack=new Stack();
        
        stack.push(Character.getNumericValue(num.charAt(0)));
        for(int i=1;i<num.length();i++){
            if(stack.isEmpty()||stack.peek()<=Character.getNumericValue(num.charAt(i))||count==k)
                stack.push(Character.getNumericValue(num.charAt(i)));
            else{
                stack.pop();
                count++;
                i--;
            }
        }
        while(!stack.isEmpty()) sb.insert(0,stack.pop());
        sb=new StringBuilder(sb.toString().substring(0,num.length()-k));
        while(sb.length()!=0&&sb.charAt(0)=='0') sb.deleteCharAt(0);
        if(sb.length()==0) return "0";
        return sb.toString();
	}

}
