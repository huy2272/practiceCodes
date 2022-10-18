package LinkedLists;

public class Middle {
    public ListNode middleNode(ListNode head) {
        ListNode temp = head;
        int size = 0;
        while(temp != null){
            size++;
            temp = temp.next;
        }
        
        if  (size%2==0){
            size = size/2;
            for (int i = 0; i<size;i++) {
                temp = head;
                temp.next = head.next;
                head = head.next;
                //temp.next = null;
            }
        }else{
            size = size/2;
            for (int i =0; i<size; i++) {
                temp = head;
                temp.next = head.next;
                head = head.next;
                //temp.next = null;
            }
        }
        
        return head;
    }
}
