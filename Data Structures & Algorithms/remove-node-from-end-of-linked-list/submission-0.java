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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null)
            return head;

        int size = 0;
        ListNode trav = head;
        while(trav!=null)
        {
            trav = trav.next;
            size++;
        }
        trav = head;
        int nodeIndex = size-n+1;
        ListNode prev = new ListNode(0);
        prev.next = head;

        nodeIndex = nodeIndex-1;

        while(nodeIndex!=0)
        {
            nodeIndex--;
            
            trav = trav.next;
            prev = prev.next;
        }

        if(trav==head)
        {
            return head.next;
        }
        prev.next = trav.next;
        trav.next = null;

        return head;

    }
}
