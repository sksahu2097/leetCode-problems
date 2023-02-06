/**
Given the head of a linked list, remove the nth node from the end of the list and return its head.

https://leetcode.com/problems/remove-nth-node-from-end-of-list/

Example 1:
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]
 

Constraints:

The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
 

Follow up: Could you do this in one pass?
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
    public ListNode removeNthFromEnd(ListNode A, int B) {

         ListNode temp = A;
        int count = 0;
        while(temp != null) {
            count++;
            temp = temp.next;
        }
        //System.out.println("count => "+count);
        int remove = count - B;
        //System.out.println("Remove => "+remove);
        if(remove <= 0 || count == B) {
            return A.next;
        }
        temp = A;
        count = 0;
        while(temp !=  null) {
            count ++;
            if(count == remove) {
                temp.next = temp.next.next;
                //temp.next.next = null;
            }
            temp = temp.next;
        }
        return A;
        
    }
}