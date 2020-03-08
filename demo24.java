package leetTest;

/**
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * @author xueshangling
 *
 */
public class demo24 {

	public static void main(String[] args) {
		ListNode h = new ListNode(1);
		h.next = new ListNode(2);
		h.next.next = new ListNode(3);
		h.next.next.next = new ListNode(4);
		
		ListNode result = swapPairs(h);
		System.out.print(result.val);
	}
	
    public static ListNode swapPairs(ListNode head) {
        
    	if(head == null){
    		return null;
    	}
    	
    	if(head.next == null){
    		return head;
    	}
    	
    	ListNode p = head;
    	ListNode guard = p; //因为要返回的是一个列表，所以需要一个哨兵，来一直标识lian'b
    	
    	while(head != null && head.next != null){
    		
    		ListNode n = head.next;
    		
    		head.next = n.next; // 第一个节点指向下一个节点的下一个
    		n.next = head;
    		guard.next = n;
    		
    		p = head;
    		head = head.next;
    	}
    	
    	return guard.next;
    }

}
