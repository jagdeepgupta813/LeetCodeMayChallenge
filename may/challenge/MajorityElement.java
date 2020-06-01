package practiceJava.leetcode.may.challenge;

import java.util.HashMap;
import java.util.PriorityQueue;

/*Given an array of size n, find the majority element. 
 * The majority element is the element that appears more than  n/2  times.

You may assume that the array is non-empty and the majority element always exist in the array.
*/

public class MajorityElement {

	public static void main(String[] args) {
		MajorityElement m = new MajorityElement();
		int nums[] = new int[] {8,8,8,6,8,8, 6,7,7,7};
		
		long end, start;
		start = System.nanoTime();
		
		System.out.println(" majorityElement1 " + m.majorityElement1(nums));
		end=System.nanoTime();
		System.out.println(" majorityElement1 " + (end-start));
		
		start = System.nanoTime();
		
		System.out.println(" majorityElement " + m.majorityElement(nums));
		end=System.nanoTime();
		System.out.println(" majorityElement " + (end-start));


	}
	
	 public int majorityElement1(int[] num) {

	        int major=num[0], count = 1;
	        for(int i=1; i<num.length;i++){
	            if(count==0){
	                count++;
	                major=num[i];
	            }else if(major==num[i]){
	                count++;
	            }else count--;
	            
	        }
	        return major;
	    }
	
	public int majorityElement(int[] nums) {
    
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		int currentMaxFreq=1;
		int currentMaxNumber=nums[0];
		hm.put(nums[0], 1);
		for(int num=1; num<nums.length; num++) {
			
			if(hm.containsKey(nums[num])) {
				int f=hm.get(nums[num]);
				f++;
				hm.put(nums[num],f );
				if(f>currentMaxFreq) {
					currentMaxFreq=f;
					currentMaxNumber=nums[num];
				}
			}
			else
				hm.put(nums[num], 1);
		}
		
		return currentMaxNumber;
    }

}

