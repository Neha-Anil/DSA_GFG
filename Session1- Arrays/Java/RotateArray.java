package sample.edel;

//problem:- Rotate an array to the left or right direction by count k. 
//
//Example 1: 
//
//Input :- Array = [1,2,3,4,5,6,7], direction = left, k = 1
//Output :- Array = [2,3,4,5,6,7,1]
//
//Input :- Array = [1,2,3,4,5,6,7], direction = left, k = 2
//Output :- Array = [3,4,5,6,7,1,2]
//
//Input :- Array = [1,2,3,4,5,6,7], direction = left, k = 8
//Output :- Array = [2,3,4,5,6,7,1]
//
//Input :- Array = [1,2,3,4,5,6,7], direction = right, k = 3
//Output :- Array = [5,6,7,1,2,3,4]
//
//Input :- Array = [1,2,3,4,5,6,7], direction = right, k = 1
//Output :- Array = [7,1,2,3,4,5,6]
//
//Note: Treat array as a circular array where it can be rotated even if the number of rotations is more than the length of the array.

public class RotateArray {

	public static void reverse(int arr[],int start,int end) {
		while(start<end) {
			int temp=arr[start];
			arr[start]=arr[end];
			arr[end]=temp;
			start++;
			end--;
		}
	}
	public static void rotateArray(int arr[],int dir,int k) {
		int n=arr.length;
		k=k%n;
		if(dir==0) {//left
			
			reverse(arr,0,k-1);
			reverse(arr,k,n-1);
			reverse(arr,0,n-1);
		}
		else { //right
			reverse(arr,0,n-k-1);
			reverse(arr,n-k,n-1);
			reverse(arr,0,n-1);
		}
	}
	
	public static void main(String[] args) {
		int input[]= {1,2,3,4,5,6,7};
		
		System.out.println("Original array:");
		for(int i=0;i<input.length;i++) {
			System.out.print(input[i]);
		}
		
//		rotateArray(input, 0, 8);
//		System.out.println(" array after left rotate:");
//		
//		for(int i=0;i<input.length;i++) {
//			System.out.print(input[i]);
//		}
		
		System.out.println(" array after right rotate:");
		
//		int input2[]= {1,2,3,4,5,6,7};
		rotateArray(input, 1, 9);
		for(int i=0;i<input.length;i++) {
			System.out.print(input[i]);
		}
	}
	
	
}
