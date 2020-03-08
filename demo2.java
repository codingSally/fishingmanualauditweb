package leetTest;

/**
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
   Output: 7 -> 0 -> 8
   Explanation: 342 + 465 = 807.

 * @author xueshangling
 *
 **
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }

 */
public class demo2 {
	
	public static void main(String args[]){
		
		ListNode list1 = new ListNode(2);
		ListNode node2 = new ListNode(4);
		ListNode node3 = new ListNode(3);
		
		list1.next = node2;
		node2.next = node3;
		node3.next = null;
		
		ListNode list2 = new ListNode(5);
		ListNode node4 = new ListNode(6);
		ListNode node5 = new ListNode(4);
		
		list2.next = node4;
		node4.next = node5;
		node5.next = null;
		
		ListNode result = addTwoNumbers(list1,list2);
		ListNode first = result;
		while(first != null){
			System.out.println(first.getVal());
			first = first.next;
		}
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	    
		
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int d1 = l1 == null ? 0 : l1.val;
            int d2 = l2 == null ? 0 : l2.val;
            int sum = d1 + d2 + carry;
            carry = sum >= 10 ? 1 : 0;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry == 1) cur.next = new ListNode(1);
        return dummy.next;
	}
}












