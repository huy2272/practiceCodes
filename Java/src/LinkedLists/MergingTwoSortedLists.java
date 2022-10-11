package LinkedLists;

public class MergingTwoSortedLists {
	public ListNode merge(ListNode list1, ListNode list2) {
		ListNode curr1 = list1;
		ListNode curr2 = list2;
		//Instead of a pointer, we are making a dummy Node
		ListNode temp = new ListNode(-1);
		ListNode head = temp;
		
		while (curr1 != null && curr2 != null) {
			if (curr1.val < curr2.val) {
				// If value in list 1 is smaller than list 2, have the dummy point at curr1
				// Have the curr1 listNode next pointer point at the next listNode
				temp.next = curr1;
				curr1 = curr1.next;
			} else {
				// Have the dummy point at curr2 if curr2 listNode value is smaller
				temp.next = curr2;
				curr2 = curr2.next;
			}
			
			temp = temp.next;
		}

		while (curr1 != null) {
			temp.next = curr1;
			curr1 = curr1.next;
			temp = temp.next;
		}

		while (curr2 != null) {
			//Make the next pointer points to curr2 Node
			temp.next = curr2;
			//Move on to the next Node in curr2
			curr2 = curr2.next;
			//This moves the pointer to the next new Node
			temp = temp.next;
		}

		//Since we used a dummy Node, the first node contains dummy data, so return temp.next
		return head.next;
	}
}
