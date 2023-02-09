/**

You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

Example 1:

Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: list1 = [], list2 = []
Output: []
Example 3:

Input: list1 = [], list2 = [0]
Output: [0]

https://leetcode.com/problems/merge-two-sorted-lists/

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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode C = new ListNode(0);
        ListNode first = list1;
        ListNode second = list2;
        ListNode temp = C;

        while(first != null && second != null) {
            
            if(first.val < second.val) {
                //System.out.println("if => "+second.val);
                ListNode demo = new ListNode(first.val);
                first = first.next;
                temp.next = demo;
            } else {
                //System.out.println("Val => "+second.val);
                ListNode demo = new ListNode(second.val);
                second = second.next;
                temp.next = demo;
            }
            temp = temp.next;
        }
        if(first != null) {
            while(first != null) {
                temp.next = first;
                temp = temp.next;
                first = first.next;
            }
        }
        if(second != null) {
            while(second != null) {
                temp.next = second;
                temp = temp.next;
                second = second.next;
            }
        }
        return C.next;
        
    }
}