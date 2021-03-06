/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode(-1);
        ListNode cur = ret;
        int carryOver = 0;
        while(l1 != null || l2 != null){
            int sum = carryOver;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            carryOver = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
        }
        if(carryOver != 0){
            cur.next = new ListNode(carryOver);
        }
        return ret.next;
    }
}