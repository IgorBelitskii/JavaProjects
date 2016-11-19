package tel_ran.collections;

import tel_ran.collections.LinkedList;
import java.util.Iterator;

public class HashSet<E> implements Set<E> {
	LinkedList<E>[] arrayHash; 
	private int capacity=16;
	int size=0;
	private float loadFactor = 0.75f;
	

	@SuppressWarnings("unchecked")
	public HashSet() {
		this.capacity=2; 
		this.arrayHash = new LinkedList[this.capacity]; 
	}

	@SuppressWarnings("unchecked")
	public HashSet(int capacity, float loadFactor) {
		this.capacity = (capacity<=0)? 16 :capacity;
		this.loadFactor = (loadFactor>1 || loadFactor<0)? 1 :loadFactor ;
		this.arrayHash = new LinkedList[this.capacity]; 
	}
	

	public int getSize() {
		return size;
	}
	public int getCapacity() {
		return capacity;
	}

	@Override
	public Iterator<E> iterator() {
		return new IteratorHashSet<E>(this);
	}

	@Override
	public void add(E element) {
		rechangeCapacity();
		if (contains(element)) return;
		int baket=element.hashCode()%capacity;
		
		if (arrayHash[baket] ==null) arrayHash[baket] = new LinkedList<E>();
		arrayHash[baket].add(element); 
		size++;
	}

	@Override
	public void remove(E element) {
		if (element==null) return;
		
		if (!contains(element)) return;
		int baket=element.hashCode()%capacity;
		arrayHash[baket].remove(element); 
		size--;
	}

	@Override
	public void retainAll(Collection<E> collection) {
		Iterator<E> itHashSet = this.iterator();
		
		while(itHashSet.hasNext()){
			E number = itHashSet.next();
			Iterator<E> itCollection=collection.iterator();
			boolean existValue=false;
			while(itCollection.hasNext() && !existValue){
				if (itCollection.next().equals(number))
					existValue=true;
			}
			if (!existValue) 
				itHashSet.remove();
		}
	}
	

	@Override
	public void removeAll(Collection<E> collection) {
		Iterator<E> itHashSet=this.iterator();
		while(itHashSet.hasNext()){
			E number = itHashSet.next();
			Iterator<E> itCollection=collection.iterator();
			while(itCollection.hasNext()){
				if (itCollection.next().equals(number))
					itHashSet.remove();
			}
		}
	}

	@Override
	public boolean contains(E element) {
		if (element==null) return false;
		int index = element.hashCode()%capacity;
		if (arrayHash[index]==null) return false;
		LinkedList<E> linedListIndex = arrayHash[index];
		return linedListIndex.contains(element);
	}

	public void setLoudfactor(int loudfactor) {
		if (loudfactor<=0 || loudfactor>1) return;
		this.loadFactor = loudfactor;
		if (((float)size)/capacity <loadFactor) return;
		reCreateHashSet( ((int)(size/loadFactor))+1);
	}
	private void rechangeCapacity() {
		if (((float)size)/capacity >=loadFactor) reCreateHashSet(capacity*2);
	}
	@SuppressWarnings("unchecked")
	private void reCreateHashSet(int capacity) {
		Iterator<E> itHashSet=this.iterator();

		LinkedList<E>[] arrayHashNew= new LinkedList[capacity]; 
		int baket;
		
		while (itHashSet.hasNext()) {
			E element=itHashSet.next();
			baket=element.hashCode()%capacity;
			if (arrayHashNew[baket] == null) arrayHashNew[baket] = new LinkedList<E>();
			arrayHashNew[baket].add(element); 
		}
		arrayHash=arrayHashNew;		
		this.capacity=capacity;

//		System.out.println("After capacity="+capacity+"    size="+size+"    loadFactor="+loadFactor);
	}

}
