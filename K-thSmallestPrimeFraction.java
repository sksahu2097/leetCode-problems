/**
786. K-th Smallest Prime Fraction
Medium
1K
47
Companies
You are given a sorted integer array arr containing 1 and prime numbers, where all the integers of arr are unique. You are also given an integer k.

For every i and j where 0 <= i < j < arr.length, we consider the fraction arr[i] / arr[j].

Return the kth smallest fraction considered. Return your answer as an array of integers of size 2, where answer[0] == arr[i] and answer[1] == arr[j].

 

Example 1:

Input: arr = [1,2,3,5], k = 3
Output: [2,5]
Explanation: The fractions to be considered in sorted order are:
1/5, 1/3, 2/5, 1/2, 3/5, and 2/3.
The third fraction is 2/5.
Example 2:

Input: arr = [1,7], k = 1
Output: [1,7]
 

Constraints:

2 <= arr.length <= 1000
1 <= arr[i] <= 3 * 104
arr[0] == 1
arr[i] is a prime number for i > 0.
All the numbers of arr are unique and sorted in strictly increasing order.
1 <= k <= arr.length * (arr.length - 1) / 2
 

Follow up: Can you solve the problem with better than O(n2) complexity?

https://leetcode.com/problems/k-th-smallest-prime-fraction/description/

*/

class Solution {
    public int[] kthSmallestPrimeFraction(int[] A, int B) {

        PriorityQueue<ArrayList<Integer>> queue = new PriorityQueue<>(
        				Collections.reverseOrder(
        						Comparator.comparingDouble(noList -> ((double)noList.get(0)/(double)noList.get(1))))); 
        for (int i = 0; i < A.length; i++) {
        	int j = A.length-1;
        	while(j > i) {
        		//System.out.println("Hiii");
            	int no1 = A[i];
            	int no2 = A[j];
            	if(queue.size() == B) {
            		ArrayList<Integer> temp = queue.peek();
            		double prev = (double)temp.get(0) / (double)temp.get(1);
            		double curr = (double)no1 / (double)no2;
            		if(curr < prev) {
            			queue.poll();
            			ArrayList<Integer> so = new ArrayList<>();
                		so.add(no1);
                		so.add(no2);
                    	queue.add(so);
            		}
            		
            	} else {
            		ArrayList<Integer> temp = new ArrayList<>();
            		temp.add(no1);
            		temp.add(no2);
                	queue.add(temp);
            	}
            	
            	j--;
            }
		}
        ArrayList<Integer> answer = queue.poll();
        int ans[] = new int[2];
        ans[0] = answer.get(0);
        ans[1] = answer.get(1);
        return ans;
        
    }
}
