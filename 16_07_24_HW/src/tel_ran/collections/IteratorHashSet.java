package tel_ran.collections;

import java.util.Iterator;
import tel_ran.collections.HashSet;

public class IteratorHashSet<E> implements Iterator<E> {
	private HashSet<E> hashSet;
	private Iterator<E> current;
	int index;
	int hasNextIndex;
	
	public IteratorHashSet(HashSet<E> hashSet) {
		this.hashSet=hashSet;
		index=-1;
	}

	@Override
	public boolean hasNext() {
		Iterator<E> current= this.current;
		hasNextIndex=this.index;
		
		if (current==null) current = LinkedListNextIterator();
		if (current==null) return false;

		if (!current.hasNext()) current = LinkedListNextIterator();
		if (current==null) return false;

		return current.hasNext();
	}

	private Iterator<E> LinkedListNextIterator() {
		int capacity=hashSet.getCapacity();
		for (int i = hasNextIndex+1; i < capacity; i++) {
			if (hashSet.arrayHash[i]!=null) {
				LinkedList<E> linkedList=hashSet.arrayHash[i];
				if (linkedList.head!=null){ 
					hasNextIndex=i;
					return  linkedList.iterator();
				}
			}
		}
		return null;
	}

	@Override
	public E next() {
		hasNextIndex=index;
		if (current==null) current = LinkedListNextIterator();
		if (!current.hasNext()) 
			current = LinkedListNextIterator();
		index=hasNextIndex;
		return current.next();
	}
	
	@Override
	public void remove() {
		if (current!=null) current.remove();
		hashSet.size--;

	}
}
