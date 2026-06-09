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
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists.length==0)
            return null;

        for(int i=1; i<lists.length; i++)
        {
            lists[i] = mergeTwoSortedList(lists[i], lists[i-1]);
        }

        return lists[lists.length-1];
    }

    public ListNode mergeTwoSortedList(ListNode head1, ListNode head2)
    {
        ListNode newHead = new ListNode(0);
        ListNode travNewHead = newHead;
        
        ListNode track1 = head1;
        ListNode track2 = head2;

        while(track1!=null && track2!=null)
        {
            if(track1.val<=track2.val)
            {
                travNewHead.next = track1;
                travNewHead = travNewHead.next;
                track1 = track1.next;
            }
            else
            {
                travNewHead.next = track2;
                travNewHead = travNewHead.next;
                track2 = track2.next;
            }
        }

        if(track1!=null)
            travNewHead.next = track1;

        if(track2!=null)
            travNewHead.next = track2;
        

        return newHead.next;
    }
}
