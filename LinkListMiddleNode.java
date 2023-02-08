/**

876. Middle of the Linked List

Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node.

Example 1:

Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.

https://leetcode.com/problems/middle-of-the-linked-list/

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
    public ListNode middleNode(ListNode head) {

        int count = 1;
        ListNode temp = head;
        while(temp != null) {
            temp = temp.next;
            count ++;
        }
        count--;
        //System.out.println("Count => "+count);
        //System.out.println("divide => "+nodeMap.keySet().size());
        int breakPoint = 0;
        if(count%2 == 0) {
           breakPoint = ((count/2)+1);
        } else {
            //System.out.println("Count => "+count);
            breakPoint = ((count+1)/2);
        }
        temp = head;
        while(breakPoint > 1) {
            temp = temp.next;
            breakPoint--;
        }
        return temp;
    }
}