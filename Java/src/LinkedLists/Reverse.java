package LinkedLists;

public class Reverse {
    public ListNode reverseList(ListNode head) {
        ListNode ptr = null;
        ListNode current = head;
        ListNode temp;
        while   (current!=null){
            temp = current.next;
            current.next = ptr;
            ptr = current;
            current = temp;
        }
        return ptr;
    }
}
