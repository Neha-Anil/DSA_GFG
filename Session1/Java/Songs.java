package sample.walmart;

import java.util.Random;

//Given a set of songs lets say 10 songs
//play the songs such that
//	1. All the songs in a set will get played
//	2. songs will get played in random order.
//	input: [1,2,3,4,5,6,7,8,9,10]
//	op:[2,6,1,3,4,10,9,7,8,5]
//	op:[7,6,1,3,4,5,9,2,8,10]


public class Songs {
	public static void main(String[] args) {
			int[] arr=new int[10];
			for(int i=0;i<10;i++) {
				arr[i]=i+1;
			}
			
			Random r=new Random();
			
			for(int i=0;i<10;i++) {
				int swapIndex=r.nextInt(10);
				int temp=arr[i];
				arr[i]=arr[swapIndex];
				arr[swapIndex]=temp;
			}
			
			for(int i:arr) {
				System.out.println(i);
			}
	}
}
