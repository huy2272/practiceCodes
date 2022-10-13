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
    
//    public ListNode removeElementsRecursive(ListNode head, int val) {
//        if  (head == null) {return null;}
//        ListNode next = removeElementsRecursive(head.next, val);
//        if  (head.val == val) {return next;}
//        head.next = next;
//        return head;
//    }
    
    public ListNode removeElementsRecursive(ListNode head, int val) {
        //Base case for when we reached the end of the linked list
    	if  (head == null) {return null;}
    	//Recursively call this function until we get to the end of the linkedlist
        head.next = removeElementsRecursive(head.next, val);
        //Now if the current node is == val, we just return head.next
        //In other words, we are skipping the node that contains int val
        //If the node is != we return head, which is the node itself
        //This keeps the node inside the linked list
        return  head.val == val ? head.next : head;
    }    
}
