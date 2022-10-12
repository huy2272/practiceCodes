package LinkedLists;

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode temp = new ListNode(0);
        ListNode headptr = temp;
        
        while   (head != null){
            if  (head.val != val){
                temp.next = head;
                temp = temp.next;
            }
            head = head.next;
        }
        temp.next = null;
        return headptr.next;
    }
    
    public ListNode removeElementsRecursive(ListNode head, int val) {
        if  (head == null) {return null;}
        ListNode next = removeElementsRecursive(head.next, val);
        if  (head.val == val) {return next;}
        head.next = next;
        return head;
    }
}
