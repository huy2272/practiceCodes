package ElasticERL;

public class NodeList<E> implements PositionList<E> {
	int counter;
	ListNode<E> head, tail;

	public NodeList() {
		counter = 0;
		head = new ListNode<E>(null, null, null);
		tail = new ListNode<E>(null, null, head);
		head.setNext(tail);
	}

	private ListNode<E> checkPosition(Position<E> p) {
		if (p == null) {
			System.out.println("Null position passed to NodeList");
		}
		if (p == head) {
			System.out.println("The trailer node is not a valid position");
		}
		if (p == tail) {
			System.out.println("The trailer node is not a valid position");
		}
		try {
			ListNode<E> temp = (ListNode<E>) p;
			if ((temp.getPrev() == null) || (temp.getNext() == null)) {
				System.out.println("Position does not belong to a valid NodeList");
			}
			return temp;
		} catch (ClassCastException e) {
			System.out.println("Position is of wrong type for this list");
		}
		return null;
	}

	public int size() {
		return counter;
	}

	public boolean isEmpty() {
		return (counter == 0);
	}

	public Position<E> first() {
		if (isEmpty()) {
			System.out.println(("List is empty"));
		}
		return head.getNext();
	}

	public Position<E> last() {
		if (isEmpty()) {
			System.out.println(("List is empty"));
		}
		return tail.getPrev();
	}

	public Position<E> prev(Position<E> p) {
		ListNode<E> v = checkPosition(p);
		ListNode<E> prev = v.getPrev();
		if (prev == head)
			System.out.println("Cannot advance past the beginning of the list");
		return prev;
	}

	public Position<E> next(Position<E> p){
		ListNode<E> v = checkPosition(p);
		ListNode<E> next = v.getNext();
		if (next == tail)
			System.out.println("Cannot advance past the end of the list");
		return next;
	}

	public Position<E> addBefore(Position<E> p, E element){
		ListNode<E> v = checkPosition(p);
		counter++;
		ListNode<E> newNode = new ListNode<E>(element, v, v.getPrev());
		v.getPrev().setNext(newNode);
		v.setPrev(newNode);
		return v.getPrev()	;
	}


	public Position<E> addAfter(Position<E> p, E element) {
		ListNode<E> v = checkPosition(p);
		counter++;
		ListNode<E> newNode = new ListNode<E>(element, v.getNext(), v);
		v.getNext().setPrev(newNode);
		v.setNext(newNode);
		return v.getNext();
	}

	public void addFirst(E element) {
		counter++;
		ListNode<E> newNode = new ListNode<E>(element, head.getNext(), head);
		head.getNext().setPrev(newNode);
		head.setNext(newNode);
	}


	public void addLast(E element) {
		counter++;
		ListNode<E> oldLast = tail.getPrev();
		ListNode<E> newNode = new ListNode<E>(element, tail, oldLast);
		oldLast.setNext(newNode);
		tail.setPrev(newNode);
	}


	public E remove(Position<E> p){
		ListNode<E> v = checkPosition(p);
		counter--;
		ListNode<E> prev = v.getPrev();
		ListNode<E> next = v.getNext();
		prev.setNext(next);
		next.setPrev(prev);
		E vElem = v.getElement();
		v.setNext(null);
		v.setPrev(null);
		return vElem;
	}

	public E set(Position<E> p, E element){
		ListNode<E> v = checkPosition(p);
		E oldVal = v.getElement();
		v.setElement(element);
		return oldVal;
	}
	
	@Override
	public String toString() {
		return "NodeList [ current="+ null + ", counter=" + counter + ", head=" + head.getNext().getElement() + ", tail=" + tail.getPrev().getElement() + "]";
	}

	public static void main(String[] args) {
		NodeList<Integer> a = new NodeList<>();
		a.addLast(10);
		a.addLast(11);
		a.addLast(12);
		System.out.println(a.toString());
		Position<Integer> p = a.last();
		System.out.println(p.getElement().toString());
		a.remove(p);
		p = a.last();
		Position<Integer> q = a.addAfter(p, 100);
		System.out.println(p.getElement().toString());
		System.out.println(a.toString());
	}
}

