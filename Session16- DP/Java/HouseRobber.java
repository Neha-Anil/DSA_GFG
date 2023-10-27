//Bottom up
// https://leetcode.com/problems/house-robber/

// You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

// Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

class Solution {
    public int rob(int[] arr) {
        
        for(int i=1;i<arr.length;i++){
            if(i==1){
                arr[i]=Math.max(arr[0],arr[1]);
            }
            else{
                arr[i]=Math.max(arr[i-1],arr[i]+arr[i-2]);
            }
        }
        return arr[arr.length-1];
    }
}
