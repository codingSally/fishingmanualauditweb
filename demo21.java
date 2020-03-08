package leetTest;

/**
 * Input: 1->2->4, 1->3->4
   Output: 1->1->2->3->4->4
 * Merge Two Sorted Lists
 * @author xueshangling
 * @date 2019-06-05
 */
public class demo21 {
	
	/**
	 * Definition for singly-linked list.
	 */
	 public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	 }

	public static void main(String[] args) {
		ListNode head_1 = new demo21().new ListNode(1);
		ListNode mid_1 = new demo21().new ListNode(2);
		ListNode tail_1 = new demo21().new ListNode(4);
		head_1.next = mid_1;
		mid_1.next = tail_1;
		
		ListNode head_2 = new demo21().new ListNode(1);
		ListNode mid_2 = new demo21().new ListNode(3);
		ListNode tail_2 = new demo21().new ListNode(4);
		head_2.next = mid_2;
		mid_2.next = tail_2;
		
		ListNode head_merge = mergeTwoLists(head_1, head_2);
		while(head_merge != null){
			System.out.println(head_merge.val);
			head_merge = head_merge.next;
		}

	}
	
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
    	if(l1 == null){
    		return l2;
    	}
    	if(l2 == null){
    		return l1;
    	}
    	ListNode head_merge = new demo21().new ListNode(0);
    	ListNode merge = head_merge;
    	
    	while(l1 != null && l2 != null){
    		if(l1.val < l2.val){
    			head_merge.next = l1;
    			l1 = l1.next;
    		}else {
    			head_merge.next = l2;
    			l2 = l2.next;
    		}
    		head_merge = head_merge.next;
    	}
    	
    	head_merge.next = l1 != null ? l1 : l2;
    	
    	return merge.next;
    }
    
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {

        ListNode flag = new demo21().new ListNode(0); 
        ListNode firstflag = flag; 
        while (l1 != null && l2 != null) {
            if(l1.val < l2.val){ 
                flag.next = l1; 
                l1 = l1.next; 
            }else { 
                flag.next = l2; 
                l2 = l2.next; 
            } 
            flag = flag.next; 
        } 
        flag.next = l1 != null ? l1 : l2;  
        
//    	while(flag != null){
//    		System.out.println(flag.val);
//    		flag = flag.next;
//    	}
    	
        return firstflag.next; 
    }

}
