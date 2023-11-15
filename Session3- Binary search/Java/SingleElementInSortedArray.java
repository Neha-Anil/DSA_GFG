// You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

// Return the single element that appears only once.

// Your solution must run in O(log n) time and O(1) space.

// Example 1:

// Input: nums = [1,1,2,3,3,4,4,8,8]
// Output: 2



class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length==2)
        return -1;
        if(nums.length==1)
        return nums[0];
        int low=0;
        int high=nums.length-1;
        int mid;
        while(low<=high){
            mid=(low+high)/2;

            if( (mid==0 && nums[mid]!=nums[mid+1]) || (mid==nums.length-1 && nums[mid]!=nums[mid-1]) || (nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1]))
            return nums[mid];

            else if((mid%2==0 && nums[mid]==nums[mid-1]) || (mid%2!=0 && nums[mid]==nums[mid+1]))
             high=mid-1;
            else
             low=mid+1;
        }
        return -1;
    }
    
}
