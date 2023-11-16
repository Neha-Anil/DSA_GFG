//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */


// https://practice.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1
// You have N books, each with A[i] number of pages. M students need to be allocated contiguous books, with each student getting at least one book.
// Out of all the permutations, the goal is to find the permutation where the student with the most books allocated to him gets the minimum number of pages, out of all possible permutations.

// Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order (see the explanation for better understanding).

// N = 4
// A[] = {12,34,67,90}
// M = 2
// Output:113
// Explanation:Allocation can be done in 
// following ways:
// {12} and {34, 67, 90} Maximum Pages = 191
// {12, 34} and {67, 90} Maximum Pages = 157
// {12, 34, 67} and {90} Maximum Pages =113.
// Therefore, the minimum of these cases is 113,
// which is selected as the output.

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    //Function to find minimum number of pages.
    
    public static int getNoOfStudents(int mid,int[] A){
        int students=1;
        int pages=0;
        int minSum=0;
        for(int i=0;i<A.length;i++){
            pages+=A[i];
            if(pages>mid){
                students++;
                pages=A[i];
            }
        }
        return students;
    }
    public static int findPages(int[]A,int N,int M)
    {
        //Your code here
        if(M>A.length)
        return -1;
        int minPages=Integer.MIN_VALUE;
        int maxPages=0;
        for(int i=0;i<A.length;i++){
            minPages=Math.max(minPages,A[i]);
            maxPages+=A[i];
        }
        int mid=0;
        while(minPages<=maxPages){
            mid=(minPages+maxPages)/2;
            int students=getNoOfStudents(mid,A);
            if(students<=M){
                
                maxPages=mid-1;
            }
            else{
                minPages=mid+1;
            }
        }
        
        return minPages;
    }
};
