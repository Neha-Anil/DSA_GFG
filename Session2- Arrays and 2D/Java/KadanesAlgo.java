import java.util.Scanner;
class KadanesAlgo{  

    public static int maximumSumSubarray(int arr[])
    {
        int n = arr.length;
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int i=0; i<n; i++) {
            currSum += arr[i];
            maxSum = Math.max(maxSum, currSum);
            if(currSum < 0) {
                currSum = 0;
            }
        }
        return maxSum;
    }
    
    //Return the subarray with max sum
    public static int[] returnMaxSumArray(int[] array) {
		int maxSum=Integer.MIN_VALUE;
		int currSum=0;
		int j=0,endIndex=0;
		
		for(int i=0;i<array.length;i++) {
			currSum+=array[i];
			
			if(currSum>maxSum) {
				maxSum=currSum;
				endIndex=i;
			}
			if(currSum<0) {
				currSum=0;
				j=i+1;
			}
			
			
		}
		int[] res=new int[endIndex-j+1];
		int c=0;
		for(int i=j;i<=endIndex;i++) {
			res[c++]=array[i];
		}
		return res;
		
	}

    public static void main(String args[]){  
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int result = maximumSumSubarray(arr);
        System.out.println(result);
    }  
}  
