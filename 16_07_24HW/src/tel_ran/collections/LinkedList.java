package tel_ran.collections;

import java.util.Iterator;

@SuppressWarnings("unchecked")
public class LinkedList<E> implements List<E> {
	class NodeList {
		public Object data;
		public NodeList next;
		public NodeList prev;
	}
	NodeList head; //private
	NodeList tail; //private 
	
	
	private void addAfterTail(NodeList node) {
		tail.next=node;
		node.prev=tail;
		tail=node;
	}
	private void addBeforeHead(NodeList node) {
		head.prev=node;
		node.next=head;
		head=node;
	}

	private void addBeforeNode(NodeList current,NodeList node) {
		NodeList prev=current.prev;
		node.next=current;
		node.prev=prev;
		current.prev=node;
		prev.next=node;
	}

	@Override
	public void add(int index, E element) {
		NodeList newNode = new NodeList();
		newNode.data=element;
		if (head==null){
			head=tail=newNode;
		}
		else {
			NodeList current;
			int ind=0;
			for (current=head; current!=null && ind < index; ind++,current=current.next) {
			}
			if (current == null) {
				addAfterTail(newNode);
			}
			else{
				if (ind==0) addBeforeHead(newNode);
				else addBeforeNode(current,newNode);
			}
							
		}

	}

	@Override
	public boolean contains(E number) {
		NodeList current;
		
		for (current=head  ;current!=null; current= current.next) {
			if (current.data != null){
				if (current.data.equals(number)) return true;
				}
			else if (number==null) return true;
		}
		return false;
	}


	@Override
	public E remove(int index) {
		if (head==null) return null;
		
		NodeList current;
		int ind=0;
		if (index<0) return null;
		if (index==0) return removeHead();
		
		for (current=head; current!=null && ind <index ; current=current.next,ind++) {
			
		} 
		if (current==null) return null;
		return removeNote(current);

	}
	
	//private
	E removeNote(NodeList current) {
		if (current==head) return removeHead();
		if (current==tail) return removeTail();
		NodeList before=current.prev;
		NodeList after=current.next;
		E res=(E)current.data;
		before.next=after;
		after.prev=before;
		return res;
	}
	private E removeTail() {
		if (tail == null) return null;
		
		E res =(E) tail.data;
		tail=tail.prev;
		if (tail !=null) tail.next=null;
		else head=null; 

		return res;

	}
	private E removeHead() {
		if (head == null) return null;
		
		E res =(E) head.data;
		head=head.next;
		if (head !=null) head.prev=null;
		else tail=null; 
			
		return res;
	}

	
	//HW ------------------------------------------------------
//	public NodeList getHead() {
//		return head;
//	}

	@Override
	public void add(E element) {
		NodeList newNode = new NodeList();
		newNode.data=element;
		if (head==null){
			head=tail=newNode;
			}
		else {
			addAfterTail(newNode);
		} 	
	}
	
	@Override
	public void remove(E element) {

		if (head==null) return;
		
		NodeList current;
		
		for (current=head; current!=null && !current.data.equals(element) ; current=current.next) {
		} 
		if (current==null) return;
		
		removeNote(current);
		
	}

	@Override
	public int indexOf(E element) {
		NodeList current;
		int index=0;
		
		for (current=head  ;current!=null; current= current.next,index++) {
			if (current.data != null)
				if (current.data.equals(element)) return index;			
			else if (element==null) return index;
		}
		return -1;
	}

	@Override
	public int lastIndexOf(E element) {
		NodeList current;
		int indexLast=-1;
		int index=0;
		
		for (current=head  ;current!=null; current= current.next,index++) {
			if (current.data != null)
				if (current.data.equals(element)) indexLast=index;
			else if (element==null) indexLast=index;
		}
		
		return indexLast;
	}

	
	@Override
	public void retainAll(Collection<E> collection) {
		Iterator<E> itLinkedList=this.iterator();
		while(itLinkedList.hasNext()){
			E number = itLinkedList.next();
			Iterator<E> itCollection=collection.iterator();
			boolean existValue=false;
			while(itCollection.hasNext() && !existValue){
				if (itCollection.next().equals(number))
					existValue=true;
			}
			if (!existValue) 
				itLinkedList.remove();
		}
	}

	@Override
	public void removeAll(Collection<E> collection) {
		Iterator<E> itLinkedList=this.iterator();
		while(itLinkedList.hasNext()){
			E number = itLinkedList.next();
			Iterator<E> itCollection=collection.iterator();
			while(itCollection.hasNext()){
				if (itCollection.next().equals(number))
					itLinkedList.remove();
			}
		}
	}

	@Override
	public Iterator<E> iterator() {
		return new IteratorLinkedList<E>(this);
	}


}





