package chapter_8;

//Method 1 : HashTable			O(n) space, O(n) time
//Method 2 : naive two loops		O(1) space, O(n^2) time

//Floyd's cycle-finding algorithm	O(1) space, O(n) time
public class TestCycle {
	
	public static ListNode testCycle(ListNode head) {
		if (head == null || head.next == null) {
			return null;
		}
		
		ListNode slow = head;
		ListNode fast = head;
		
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				slow = head;
				while (slow != fast) {
					fast = fast.next;
					slow = slow.next;
				}
				return slow;
			}
		}
		
		return null;
	}
	
}
