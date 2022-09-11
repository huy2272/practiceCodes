package LinkedLists;

public class MergingTwoLists {
	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public ListNode merge(ListNode list1, ListNode list2) {
		ListNode curr1 = list1;
		ListNode curr2 = list2;
		ListNode head = new ListNode(-1);
		ListNode temp = head;
		
		while (curr1 != null && curr2 != null) {
			if (curr1.val < curr2.val) {
				// If value in list 1 is smaller than list 2, have the dummy point at curr1
				// Have the curr1 listNode next pointer point at the next listNode
				head.next = curr1;
				curr1 = curr1.next;
			} else {
				// Have the dummy point at curr2 if curr2 listNode value is smaller
				head.next = curr2;
				curr2 = curr2.next;
			}
			
			head = head.next;
		}

		while (curr1 != null) {
			head.next = curr1;
			curr1 = curr1.next;
			head = head.next;
		}

		while (curr2 != null) {
			head.next = curr2;
			curr2 = curr2.next;
			head = head.next;
		}

		return temp.next;
	}
}
