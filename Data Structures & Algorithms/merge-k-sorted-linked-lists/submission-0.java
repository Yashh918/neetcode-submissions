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
        int n = lists.length;

        if(n == 0){
            return null;
        }

        for(int i=1; i<n; ++i){
            lists[i] = mergeTwoLists(lists[i], lists[i-1]);
        }

        return lists[n-1];
    }

    public ListNode mergeTwoLists(ListNode x, ListNode y){
        ListNode head = new ListNode(0);
        ListNode curr = head;

        while(x != null && y!= null){
            if(x.val < y.val){
                curr.next = x;
                x = x.next;
            } else {
                curr.next = y;
                y = y.next;
            }
            curr = curr.next;
        }

        if(x != null) curr.next = x;
        if(y != null) curr.next = y;

        return head.next;
    }
}
