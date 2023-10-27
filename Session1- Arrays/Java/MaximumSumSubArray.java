package sample.edel;
//SLIDING WINDOW PROBLEM

//Given an array of positive numbers and a positive number ‘k,’ find the maximum sum of any contiguous subarray of size ‘k’.
//
//Example 1:
//Input: [2, 1, 5, 1, 3, 2], k=3 
//Output: 9
//
//Explanation: Subarray with maximum sum is [5, 1, 3].
//
//Example 2:
//Input: [2, 3, 4, 1, 5], k=2 
//Output: 7
//
//Explanation: Subarray with maximum sum is [3, 4].

public class MaximumSumSubArray {

	public static int getMaxsumSubArray(int[] nums,int k) {
		int count=0;
		int maxSum=Integer.MIN_VALUE;
		int left=0;
		int n=nums.length;
		int currSum=0;
		
		
		for(int i=0;i<n;i++) {
			currSum+=nums[i];
			count++;
			if(count==k) {
				maxSum=Math.max(maxSum, currSum);
				currSum=currSum-nums[left];
				left++;
				count--;
			}
		}
		return maxSum;
	}
	
	public static void main(String[] args) {
		int[] nums= {2,3,4,1,5};
		System.out.println(getMaxsumSubArray(nums, 2));
	}
}
