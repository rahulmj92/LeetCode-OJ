/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ReverseNodeInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null)
            return null;
        if(!isKNodeLeft(head,k))
            return head;
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;
        int i = 0;
        while (i<k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            i++;
        }
        head.next = reverseKGroup(next, k);
        return prev;
    }
    private boolean isKNodeLeft(ListNode head, int k) {
        while(head != null){
            head = head.next;
            if(--k == 0)
                return true;
        }
        return false;
    }
}
