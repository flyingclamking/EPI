package chapter_8;

public class MergeSortedLinkedList {
	
	public ListNode merge(ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null) {
			return l1 == null ? l2 : l1;
		}
		
		ListNode dummy = new ListNode(-1);
		ListNode curr = dummy;
		
		while (l1 != null && l2 != null) {
			if (l1.value < l2.value) {
				curr.next = l1;
				l1 = l1.next;
			} else {
				curr.next = l2;
				l2 = l2.next;
			}
			curr = curr.next;
		}
		
		if (l1 == null) {
			curr.next = l2;
		} else {
			curr.next = l1;
		}
		
		return dummy.next;
	}
	
}
