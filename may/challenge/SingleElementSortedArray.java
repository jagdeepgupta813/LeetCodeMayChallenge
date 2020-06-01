package practiceJava.leetcode.may.challenge;

/*
 * You are given a sorted array consisting of only integers where every element appears exactly twice, 
 * except for one element which appears exactly once. 
 * Find this single element that appears only once.
 */

/**
 * 
 * Basically we need to figure out a way to navigate either go to the left half or the right half of the array like every binary search problem.
So first observation was that the length of the array is always odd given the condition of the problem since there is only one single element and all the others comes in pair.
And for a middle element, the length of the left half = right half. So there are three scenarios for the middle element:

it is the singular one
2, 2, 3, 4, 4
the left neighbor has the same value
2, 3, 3, 4, 4
the right neighbor has the same value
2, 2, 3, 3, 4
At this point it seems like the problem is solved given the information above. 
If the middle one is not the singular one, we would simply just navigate to the left if left neighbor has the same value and navigate to the right otherwise. 

But there is one more variable that could break the condition, that is the length of the left and right half of the array.
If the length is an even number like what's shown above, the condition holds but when the length is an odd number, the condition is completely the opposite.
2, 2, 3, 4, 4, 5, 5
2, 2, 3, 3, 4, 5, 5
 *
 */

public class SingleElementSortedArray {

	public static void main(String[] args) {
		SingleElementSortedArray s = new SingleElementSortedArray();
		int nums[] = new int[] {1,1,3,3,4,4,8,8,3};
		System.out.println(" result " + s.singleNonDuplicate(nums));
		System.out.println("result binary " + s.singleNonDuplicate1(nums));

	}
    
	public int singleNonDuplicate(int[] nums) {
		int i;
    
		for(i=0; i<nums.length-1; i=i+2) {
			if(nums[i]!=nums[i+1])
				return nums[i];
		}
		return nums[nums.length-1];
		
    }
	
	public int singleNonDuplicate1(int[] nums) {
		 int low = 0, high = nums.length - 1;
	        while (low <= high) {
	            int mid = (high + low) / 2;
	            //if the current one is the single one
	            if (mid == 0 || mid == nums.length - 1 || (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1])) return nums[mid];
	            //if the single one is on the left side
	            if (((mid - low) % 2 == 0 && nums[mid - 1] == nums[mid]) || ((mid - low) % 2 == 1 && nums[mid - 1] != nums[mid])) {
	                if (nums[mid - 1] == nums[mid]) high = mid;
	                else high = mid - 1;
	            }
	            //if the single one is on the right side
	            else {
	                if (nums[mid - 1] == nums[mid]) low = mid + 1;
	                else low = mid;
	            }
	        }
	        return nums[low];
	}

}
