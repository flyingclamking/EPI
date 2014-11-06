package chapter_8;

public class ReverseLinkedList {
	
	public static ListNode reverse(ListNode head) {
		
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode newHead = reverse(head.next);
		head.next.next = head;
		head.next = null;
		
		return newHead;
	}
	
	public static ListNode reverseLL(ListNode head) {
		
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode prev = null;
		ListNode curr = head;
		
		while (curr != null) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		return prev;
	}
	
}
