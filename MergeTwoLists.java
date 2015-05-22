/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode finalLN , tempLN, lastNode , nextNode, backupLN;
        //checks
        if(l1 == null && l2 == null) {
            return null;
        }
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        
        //impl
        if(l1.val > l2.val) {
            finalLN = l2;
            tempLN = l1;
            lastNode = l2;
            nextNode = l1;
        }
        else {
            finalLN = l1;
            tempLN = l2;
            lastNode = l1;
            nextNode = l2;
        }
        
        backupLN = finalLN;
        
        while(finalLN != null && tempLN != null){
            if(finalLN.val <= tempLN.val) {
                lastNode = finalLN;
                finalLN = finalLN.next;
            }
            else {
                lastNode.next = tempLN;
                nextNode = tempLN.next;
                tempLN.next = finalLN;
                tempLN = nextNode;
                lastNode = lastNode.next;
            }
        }
        
        if(finalLN == null && tempLN != null) {
            lastNode.next = tempLN;
        }
        
        return backupLN;
    }
}
