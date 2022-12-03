package NodePositionList;

public interface PositionList<E> {
	public int size();
	public Position<E> first();
	public Position<E> last();
	public Position<E> next(Position<E> p); 
	public Position<E> prev(Position<E> p); 
	public void addFirst(E v);
	public void addLast(E v);
	public void addAfter(Position<E> p, E v); 
	public void addBefore(Position<E> p, E v); 
	public E remove(Position<E> p);
	public E set(Position<E> p, E v);
}
