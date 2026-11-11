/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        // 4 -> 5 -> 1 -> 9 
        // 4 is the node to be deleted
        node.val = node.next.val; //copying the value of 5 to 4
        node.next = node.next.next; //then (previously 5)4.next points to 9
    }
}