// https://practice.geeksforgeeks.org/problems/row-with-max-1s0023
//Row with max 1s in a sorted matrix, every row's 1's appear at the end
//O(N+M)
class Solution {
    int rowWithMax1s(int arr[][], int n, int m) {
        // code here
        
       int col = m-1;
        int row = 0;
        int ans = -1;
        while(row<n && col>=0){
            if(arr[row][col]==1){
                ans = row;
                col--;
            }
            else if(arr[row][col]==0){
                row++;
            }
        }
        return ans;
    }
}
