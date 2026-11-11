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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /* 
            l1= [1,2,3,4,5,6] l2= [4,5,6]
            reverse order 
            so 654321 + 654
        */

        int carry = 0;
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        while(l1 != null || l2 != null || carry != 0){
        //    if(l1 != null){
        //         sum += l1.val;
        //         l1 = l1.next;
        //    }
        //    if(l2 !=null){
        //         sum += l2.val;
        //         l2 = l2.next;
        //    }

            int digit1 = (l1 != null) ? l1.val : 0;
            int digit2 = (l2 != null) ? l2.val : 0;

            //sum = 12, then carry = 1, this carry should be added to the next LL node
            int sum = digit1 + digit2 + carry;
            int digit = sum % 10;
            carry = sum / 10;

            ListNode newNode = new ListNode(digit); //first digit of the number
            tail.next = newNode;
            tail = tail.next;


            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;


        }
        ListNode result = dummyHead.next;
        dummyHead.next = null;
        return result;
    }
}