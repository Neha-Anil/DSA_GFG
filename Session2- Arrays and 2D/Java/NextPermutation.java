//https://leetcode.com/problems/next-permutation

class Solution {
    public void nextPermutation(int[] nums) {
        int pivot=-1;
        for(int i=nums.length-1;i>=1;i--){
            if(nums[i]>nums[i-1]){
                pivot=i-1;
                break;
            }
        }
        if(pivot==-1){
            Arrays.sort(nums);
            return;
        }
        int nextBiggerIndex=-1;
        for(int i=nums.length-1;i>=pivot;i--){
            if(nums[i]>nums[pivot]){
                nextBiggerIndex=i;
                break;
            }
        }

        int temp=nums[pivot];
        nums[pivot] = nums[nextBiggerIndex];
        nums[nextBiggerIndex] = temp;

        reverse(nums, pivot + 1);
}
private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
