package practiceJava.leetcode.may.challenge;

import java.util.HashMap;
import java.util.Map;

/*
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 */

/*Logic is : To mark 0 as -1 and 1 as 1 , and keep adding the values and store the sum and index
 * if we find the same sum in the map, it means that was encountered earlier and all the values in between adds to zero
 * so we can compare the length from previous index to current index and keep it in max lenght if its maximum 
 * 
 */
public class ContiguousArray {

	public static void main(String[] args) {
		ContiguousArray c = new ContiguousArray();
		int nums[]= new int[] {0,1,0,1,0,0,1,0,0,0,0,1,1,1,1};
		System.out.println("mera " + c.findMaxLength(nums));
		System.out.println(c.findMaxLength1(nums));


	}
	public int findMaxLength(int[] nums) {

		int maxLength=0,sum=0;
		Map<Integer, Integer> countKeeper = new HashMap<>();

		for(int i=0; i<nums.length; i++) {
			sum += (nums[i]==0?-1:1);
			if(sum==0)
				maxLength=i+1;  // because when sum is zero all the element contributing till this index would be added
			else if(countKeeper.containsKey(sum)) {
				maxLength=Math.max(maxLength, i-countKeeper.get(sum));
			}
			else {
				countKeeper.put(sum,i);
			}
		}
		return maxLength;
	}
	public int findMaxLength1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxlen = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 1 ? 1 : -1);
            if (map.containsKey(count)) {
                maxlen = Math.max(maxlen, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return maxlen;
    }

}
