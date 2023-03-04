/**
Reorder List

You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.

Input: head = [1,2,3,4]
Output: [1,4,2,3]

Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]

https://leetcode.com/problems/reorder-list/description/

*/
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

    public ListNode getSecondLastNode(ListNode head) {
        while(head.next.next != null) {
            head = head.next;
        }
        return head;
    }

    public void reorderList(ListNode head) {
        if(head == null || head.next == null) {
            return;
        }
        ListNode first = head;
        ListNode prevLast = null;
        //To access the list fast retrival
        ArrayList<ListNode> nodeList = new ArrayList<>();
        int j = 0;
        while(first != null) {
            ListNode temp = first;
            nodeList.add(temp);
            first = first.next;
            j++;
        }
        //System.out.println("J => "+j);
        int i=0;
        if(j %2 == 0) {
            i = 1;
        }
        j=j-1;
        first = head;
        //System.out.println("LAst Node => "+nodeList.get(j).val);
        while(first != prevLast && j > i ) {
            ListNode temp = first;
            prevLast = nodeList.get(j-1);
            //System.out.println("loop second LAst Node => "+prevLast.val);
            temp = first.next;
            first.next = prevLast.next;
            prevLast.next.next = temp;
            prevLast.next = null;
            first = temp;
            j--;
            i++;
            //System.out.println("firstNode => "+first.val);
            //System.out.println("PrevNode inside => "+prevLast.val);
        }
        // System.out.println("firstNode after => "+first.next.val);
        // System.out.println("firstNode next after => "+first.next.val);
        //System.out.println("i => "+i+ " : j => "+j);
        // System.out.println("j node => "+nodeList.get(i).val);
        //System.out.println("PrevNode => "+prevLast.val);
        //return head;
    }
}
