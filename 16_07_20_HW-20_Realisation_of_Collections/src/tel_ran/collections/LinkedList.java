package tel_ran.collections;

import java.util.Iterator;

@SuppressWarnings("unchecked")
public class LinkedList<E> implements List<E> {
	
private class NodeList	{
	public Object data;
	public NodeList next;
	public NodeList prev;
}
private NodeList head;
private NodeList tail;

	@Override
	public void add(E number) {
	//TODO
	}

	@Override
	public void remove(E number) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void retainAll(Collection<Integer> collection) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeAll(Collection<Integer> collection) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterator<E> iterator() { // Создать класс ListIterator. Итератор должен возвращать три функции - включая remove
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(E number) {
		NodeList current;
		for(current=head; current!=null; current=current.next) {
			if (current.data!=null) {
				if (current.data.equals(number)) 
					return true;
			}
			else if (number==null)
				return true;
		}
		return false;
	}

	@Override
	public void add(int index, E element) {
		NodeList newNode=new NodeList();
		newNode.data=element;
		if(head==null){
			head=tail=newNode;
		} else {
			NodeList current;
			int ind=0;
			for (current = head; current!=null && ind < index; ind++, current = current.next ) {}
			if (current == null) {
				//add after tail
				addAfterTail(newNode);
			}
			else {
				if (ind==0) 
					addBeforeHead(newNode);
					else {
						addBeforeNode(current, newNode);
					}
			}
		}
		
	}

	private void addBeforeNode(NodeList current, NodeList node) {
		node.next=current;
		//NodeList prev=current.prev;
		node.prev=current.prev;
		current.prev=node;
		node.prev.next=node;
	}

	private void addBeforeHead(NodeList node) {
		head.prev=node;
		node.next=head;
		head=node;
	}

	private void addAfterTail(NodeList node) {
		tail.next=node; //вставляем после хвоста
		node.prev=tail; // связь с тейлом
		tail=node; // переопределение хвоста 
	}

	@Override
	public int indexOf(E element) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(E element) {
		// TODO Auto-generated method stub
		return 0;
	}

	

	

	@Override
	public E remove(int index) {
		if (head==null) 
			return null;
		NodeList current;
		int ind=0;
		if (index<0) return null;
		if (index==0) {
			return removeHead();
		}
		for(current=head; current!=null && ind<index; current=current.next, ind++) {
		}
		if (current==null) return null;
		return removeNode(current);
	}

	private E removeNode(NodeList current) {
		if (current==head) 
			removeHead();
		if (current==tail)
			removeTail();
		NodeList before=current.prev;
		NodeList after=current.next;
		before.next=after;
		after.prev=before;
	/*	current.prev.next=current.next;
		current.next.prev=current.prev;*/
		E res=(E) current.data;
		return res;
	}

	private E removeTail() {
		if (tail == null) 
			return null;
		E res=(E) tail.data;
		tail=tail.prev;
		if (tail!=null) 
			tail.next=null;
		else head=null;
		return res;
	}

	private E removeHead() {
		if (head == null) 
			return null;
		E res=(E) head.data;
		head=head.next;
		if(head != null) head.prev=null; 
		else tail=null;
		return res;
	}

	

}
