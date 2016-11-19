package tel_ran.collections;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class IteratorLinkedList<E> implements Iterator<E> {
	private LinkedList<E> linkedList;
	private LinkedList<E>.NodeList current;

	public IteratorLinkedList(LinkedList<E> linkedList) {
		this.linkedList=linkedList;
	}

	@Override
	public boolean hasNext() {
		if (current==null && linkedList.head!=null)  return true;
		else  return (current.next!=null);
	}

	@SuppressWarnings("unchecked")
	@Override
	public E next() {

		if (current==null) 
			current=linkedList.head;
		else 
			current=current.next;
		
		return (E)(current.data);
	}

	@Override
	public void remove() {
		if (current.next!=null) 
			if (current.next.prev!=current) throw new ConcurrentModificationException();

		linkedList.removeNote(current);

	}

//	public void remove() {
//		//Iterator.super.remove();
//		
//		LinkedList<E>.NodeList currentRemove=current;
//		current=current.next;
//		linkedList.removeNote(currentRemove);
//
//	}
}
