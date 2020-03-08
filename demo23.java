package leetTest;

/**
 * Input: [ 1->4->5, 1->3->4, 2->6 ] Output: 1->1->2->3->4->4->5->6
 * 
 * @author xueshangling
 *
 */
public class demo23 {

	static int a[] = { 1, 4, 5 };
	static int b[] = { 1, 3, 4 };
	static int c[] = { 2, 6 };

	static ListNode createList(int a[]) {
		if (a.length == 0)
			return null;
		ListNode phead = new ListNode(a[0]);
		ListNode p = phead;
		for (int i = 1; i < a.length; i++) {
			ListNode newnode = new ListNode(a[i]);
			p.next = newnode;
			p = p.next;
		}
		p.next = null;
		return phead;
	}

	public static void main(String[] args) {
		// create lists
		ListNode la = createList(a);
		ListNode lb = createList(b);
		ListNode lc = createList(c);
		ListNode lists[] = { la, lb, lc };

		demo23 s = new demo23();
		ListNode head = s.mergeKLists(lists);
		ListNode p = head;

		if (head == null)
			System.out.println("the list is empty");
		else {
			System.out.println("the whole lists:");
			System.out.printf("%d", p.val);
			p = p.next;
			while (p != null) {
				System.out.printf("--->%d ", p.val);
				p = p.next;
			}
		}
	}

	public ListNode mergeKLists(ListNode[] lists) {

		if (lists.length == 0) {
			return null;
		}

		if (lists.length == 1) {
			return lists[0];
		}

		// 所有list都是null
		int index = 0;
		while (index < lists.length && lists[index] == null) {
			index++;
		}
		if (index == lists.length) {
			return null;
		}

		int cursor;

		// 找到具有最小值的链表头
		int min = Integer.MAX_VALUE, startpos = 0;
		for (cursor = 0; cursor < lists.length; cursor++) {
			if (lists[cursor] != null) {
				if (lists[cursor].val < min) {
					startpos = cursor;
					min = lists[cursor].val;
				}
			}
		}

		// 合并
		ListNode p1 = lists[startpos];
		// 将剩下的列表依次插入
		for (cursor = 0; cursor < lists.length; cursor++) {

			if (lists[cursor] == null || cursor == startpos) {
				continue;
			}

			ListNode p2 = lists[cursor];
			ListNode p2next = p2.next;
			p1 = lists[startpos];

			while (p2 != null) {
				while (p1.next != null && p1.next.val < p2.val) {
					p1 = p1.next;
				}
				p2.next = p1.next;
				p1.next = p2;
				p1 = p2;
				p2 = p2next;

				if (p2 != null) {
					p2next = p2next.next;
				}
			}
		}

		return lists[startpos];
	}
}