
//The span Si of the stocks price on a given day i is defined as the maximum number of consecutive days just before the given day, 
//for which the price of the stock on the current day is less than or equal to its price on the given day.
class Solution
{
    //Function to calculate the span of stock's price for all n days.
    public static int[] calculateSpan(int price[], int n)
    {
        // Your code here
        int[] res=new int[price.length];
        Arrays.fill(res,1);
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<price.length;i++){
            while(!s.isEmpty() && price[i]>=price[s.peek()]){
                res[i]+=res[s.peek()];
                s.pop();
            }
            s.push(i);
        }
        return res;
    }
    
}
