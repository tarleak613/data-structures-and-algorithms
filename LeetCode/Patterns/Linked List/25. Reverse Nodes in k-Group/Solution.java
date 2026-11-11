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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prev = null,curr = head,Next = null;
        int n = k;
        while(curr != null && n > 0){
            Next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = Next;
            n--;
        }
        if(curr == null && n > 0){
            curr = prev; //storing the previous node address to start reverse
            prev = null;
            Next = null;
            while(curr != null){
                Next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = Next;
            }
        }
        if(n > 0){ //conditon to check whether it has reached the end
            return prev;
        }
        else{
            head.next = reverseKGroup(curr,k);
        }
        return prev;
    }
}