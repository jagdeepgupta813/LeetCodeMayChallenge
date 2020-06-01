package practiceJava.leetcode.may.challenge;

public class NumberComplement {

	public int findComplement(int num) {
		int result=0;
		int n=0;
		     while(num>0){
		    	 
			result = result + (int)Math.pow(2, n)*(num%2==0?1:0);
			num=num/2;
			n++;
			}
		return result;
    }
	public static void main(String[] args) {
		
		NumberComplement n = new NumberComplement();
		System.out.println(n.findComplement(2));

	}

}
