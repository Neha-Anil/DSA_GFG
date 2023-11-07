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
class Solution {
    public ListNode reverseList(ListNode head) {        
        ListNode prev=null,current=head,next=null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }
    public boolean isPalindrome(ListNode head) {
       ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        } 
        ListNode temp=reverseList(slow);
        while(temp!=null && head!=null)
        {
            if(temp.val!=head.val)return false;
            temp=temp.next;
            head=head.next;
        }
        return true;
    }
}
