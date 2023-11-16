// You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

// You may assume the two numbers do not contain any leading zero, except the number 0 itself.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

// https://leetcode.com/problems/add-two-numbers-ii/description/
class Solution {

    ListNode res=null;
    public ListNode reverse(ListNode head){
        ListNode prev=null,curr,next=null;
         curr=head;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }

    public void insertToRes(int val){
        ListNode newNode=new ListNode(val);
        if(res==null)
        res=newNode;
        else{
            ListNode temp=res;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=newNode;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         l1=reverse(l1);
         l2=reverse(l2);
        int carry=0;
        while(l1!=null || l2!=null || carry>0){
            int n1=0;
            if(l1!=null){
                n1=l1.val;
                l1=l1.next;
            }
            int n2=0;
            if(l2!=null){
                n2=l2.val;
                l2=l2.next;
            }
            int sum=n1+n2+carry;
            insertToRes(sum%10);
            carry=sum/10;
        }
        ListNode rev=reverse(res);
        return rev;
    }
}
