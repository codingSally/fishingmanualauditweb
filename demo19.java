package leetTest;

public class demo19 {

	/**
	 * Definition for singly-linked list.
	 */
	 public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	 }
	 
	public static void main(String[] args) {
		ListNode head = new demo19().new ListNode(1);
		ListNode p = head;
		for(int i = 1; i < 5; i++){
			ListNode newNode = new demo19().new ListNode(i+1);
			p.next= newNode;
			p = p.next;
		}
		ListNode index = head;
		while(index!= null){
			System.out.println(index.val);
			index = index.next;
		}
		removeNthFromEnd(head,0);
	}
	
    public static ListNode removeNthFromEnd(ListNode head, int n) {
    	if(n == 0 ){
    		return head;
    	}
    	int length = 0;
    	ListNode p = head;
    	while(p!= null){
    		length ++;
    		p = p.next;
    	}
    	
    	if(length == n){
    		head = head.next;
    	}
    	
    	int cursor = length - n;
    	System.out.println("cursor: " + cursor);
    	int index = 0;
    	
    	ListNode temp = null;
    	ListNode curNode = head;
    	while(cursor != 0 && index <= cursor){
    		if(index == cursor){
    			temp = curNode.next.next;
    			curNode.next = temp;
    			temp = null;
    		}else {
    			if(index + 1 < cursor){
    				curNode = curNode.next;
    			}
    		}
    		index ++;
    	}
    	
    	System.out.println("最终的结果");
		ListNode index2 = head;
		while(index2 != null){
			System.out.println(index2.val);
			index2 = index2.next;
		}
		
		return head;
    }
}
