package ElasticERL;

public class ListNode<E> extends Position<E> {
  private ListNode<E> prev, next;	// References to the nodes before and after
  private E element;	// Element stored in this position
  /** Constructor */
  public ListNode(E val, ListNode<E> newNext, ListNode<E> newPrev) {
    prev = newPrev;
    next = newNext;
    element = val;
  }
  // Method from interface Position
  public E getElement() {
    if ((prev == null) && (next == null)) {
    	System.out.println("Position is not in a list");
    }
    return element;
  }
  // Accessor methods
  public ListNode<E> getNext() { return next; }
  public ListNode<E> getPrev() { return prev; }
  // Update methods
  public void setNext(ListNode<E> newNext) { next = newNext; }
  public void setPrev(ListNode<E> newPrev) { prev = newPrev; }
  public void setElement(E newElement) { element = newElement; }
}