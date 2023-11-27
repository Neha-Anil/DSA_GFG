// Java program to find the array 
// element that appears only once 
// Given an array of integers. All numbers occur twice except one number which occurs once. Find the number in O(n) time & constant extra space.
import java.io.*; 
class ElementOccuringOnce 
{ 
	
	static int findSingle(int ar[], int ar_size) 
	{ 
		// Do XOR of all elements and return 
		int res = ar[0]; 
		for (int i = 1; i < ar_size; i++) 
			res = res ^ ar[i]; 
	
		return res; 
	} 

	// Driver code 
	public static void main (String[] args) 
	{ 
		int ar[] = {2, 3, 5, 4, 5, 3, 4}; 
		int n = ar.length; 
		System.out.println("Element occurring once is " + 
							findSingle(ar, n) + " "); 
	} 
} 
// This code is contributed by Prakriti Gupta 
