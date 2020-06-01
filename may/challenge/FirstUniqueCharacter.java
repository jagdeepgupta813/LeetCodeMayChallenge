package practiceJava.leetcode.may.challenge;

public class FirstUniqueCharacter {

	
	public int firstUniqChar(String s) {
		int length=s.length();
        if(length<=1){
            return s.length()-1;
        }
        int result=-1;
        int i;
        for(i=0; i<=length-2; i++){
            if(s.charAt(i)!=s.charAt(i+1)){
                if(i==0|| i>0 && (s.charAt(i)!=s.charAt(i-1))){                    
                    result=i;
                    break;
                }
                
            }
                
            
        }
        if(i==length-1 && i>0 && (s.charAt(i)!=s.charAt(i-1))){
            result=i;            
        }
        return result;
    }
	
	public int firstUniqChar1(String s) {
		
		for(int i=0; i<s.length(); i++) {
			
		}
		return 0;
	}
	
public static int firstUniqChar2(String s) {
        
		char[] a = s.toCharArray();
		
		for(int i=0; i<a.length;i++){
			System.out.println("s.indexOf(a[i]) " + s.indexOf(a[i]) + " s.lastIndexOf(a[i]) " + s.lastIndexOf(a[i]));
			if(s.indexOf(a[i])==s.lastIndexOf(a[i])){return i;}
		}
		return -1;
    }

	
	
	public static void main(String[] args) {
		FirstUniqueCharacter f = new FirstUniqueCharacter();
		System.out.println(f.firstUniqChar2("loeloec"));
		
		//System.out.println("loveloveove".indexOf('l',5));
		

	}

}

class Pair{
	char c;
	int i;
	Pair(char c, int i){
		this.c=c;
		this.i=i;
	}
	int getCount(){
		return this.i;
	}
	char getChar() {
		return this.c;
	}
}