package LinkedLists;

public class RemoveDuplicatesSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = new ListNode(-101);
        ListNode headptr = temp;
        
        while   (head != null){
            temp.next = head;
            head = head.next;
            if  (head != null && temp.next.val != head.val){
                temp = temp.next;
            }
        }
        return headptr.next;
    }
}
