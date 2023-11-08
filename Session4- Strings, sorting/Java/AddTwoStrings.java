class Solution {
    public String addStrings(String num1, String num2) {
        int i=num1.length()-1;
		int j=num2.length()-1;
		int carry=0;
		StringBuilder sb=new StringBuilder();
		
		while(i>=0 || j>=0 || carry>0) {
			int n1=0;
			if(i>=0) {
				n1= num1.charAt(i) - '0';
				i--;
			}
			int n2=0;
			if(j>=0) {
				n2=num2.charAt(j) - '0';
				j--;
			}
			int sum=n1+n2+carry;
			sb.append(sum%10);
			carry=sum/10;
		}
		
		return sb.reverse().toString();
    }
}
