package tel_ran.collections;

import java.util.Iterator;
@SuppressWarnings("unchecked")
public class LinkedList<E> implements List<E> {
class NodeList {
	public Object data;
	public NodeList next;
	public NodeList prev;
	
	public boolean equals(NodeList node) {
	if (this.data.equals(node.data)) return true;
		return false;
	}
}

NodeList head;
 NodeList tail;
	@Override
	public void add(E data) {
		NodeList newNode=new NodeList();
		newNode.data=data;
		if(head==null){
			head=tail=newNode;
		}
		else
			addAfterTail(newNode);
	}

	@Override
	public void remove(E data) {
		NodeList node=getNode(data);
		if (node != null) {
			removeNode(node);
		}
		
	}

	private NodeList getNode(E data) {
		NodeList node=null;
		for(node=head; node != null && !node.data.equals(data);node = node.next){}
		return node;
	}

	

	@Override
	public Iterator<E> iterator() {
		return new ListIterator<E>(this);
	}

	@Override
	public boolean contains(E number) {
		NodeList current;
		for(current=head; current != null; current=current.next){
			if(current.data != null ){
				if(current.data.equals(number))
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
		}
		else {
			NodeList current;
			int ind=0;
			for(current=head;current != null && ind < index;ind++,
					current=current.next) {}
			if(current == null){
				//add after tail
				addAfterTail(newNode);
			}
			else {
				if(ind == 0)
					addBeforeHead(newNode);
				else {
					addBeforeNode(current,newNode);
				}
			}
		}
	}

	private void addBeforeNode(NodeList current, NodeList node) {
		NodeList prev=current.prev;
		node.next=current;
		node.prev=prev;
		current.prev=node;
		prev.next=node;
		
	}

	private void addBeforeHead(NodeList node) {
		head.prev=node;
		node.next=head;
		head=node;
		
	}

	private void addAfterTail(NodeList node) {
		tail.next=node;
		node.prev=tail;
		tail=node;
		
	}

	@Override
	public int indexOf(E element) {
		NodeList node=null;
		int ind=0;
		
		for(node=head;node != null && !node.data.equals(element);node=node.next,ind++){}
		return node != null?ind:-1;
	}

	@Override
	public int lastIndexOf(E element) {
		NodeList node=null;
		int ind=0;
		int indRes=-1;
		for(node=head; node != null;node=node.next,ind++){
			if(node.data.equals(element))
				indRes=ind;
		}
		return indRes;
	}

	

	

	@Override
	public E remove(int index) {
		if(head==null)
			return null;
		NodeList current;
		int ind=0;
		if(index < 0)
			return null;
		if(index==0){
			return removeHead();
		}
		for(current=head; current != null && ind < index; current=current.next,ind++)
		{}
		if(current==null)
			return null;
		return removeNode(current);	
	}

	
	E removeNode(NodeList current) {
		if(current==head)
			return removeHead();
		if(current==tail)
			return removeTail();
		NodeList before=current.prev;
		NodeList after=current.next;
		E res=(E) current.data;
		before.next=after;
		after.prev=before;
		return res;
	}

	private E removeTail() {
		if(tail == null)
			return null;
		E res=(E) tail.data;
		tail=tail.prev;
		if(tail!=null)
			tail.next=null;
		else 
			head=null;
		return res;
	}

	private E removeHead() {
		if(head == null)
			return null;
		E res=(E) head.data;
		head=head.next;
		if(head != null)
			head.prev=null;
		else
			tail=null;
		return res;
	}

	@Override
	public boolean isEmpty() {
		return head==null;
	}
	/**
	 * 
	 * @param indTo - index of the element where a loop is directed (куда)
	 * @param indFrom - index of the element from wich a loop is derected (откуда)
	 * @return true if a loop has been set
	 * Поместить next indexFrom на indexTo
	 */
	public boolean setLoop(int indTo, int indFrom){
		NodeList nodeTo=null,current=head;
		for(int i=0;((current != null) && (i < indFrom)); i++,current=current.next){
			if(i==indTo) nodeTo=current;
		}
		if(current==null || nodeTo==null) return false;
		current.next=nodeTo;
	return true;
}
	/*public boolean setLoop(int indTo, int indFrom) {
		NodeList fromHead = head;
		NodeList nodelistTo = head;
		int i=0;
		do {
			if (i==indTo) nodelistTo=fromHead;
			if (i==indFrom) {
				fromHead.next=nodelistTo;
				return true;
			}
			fromHead=fromHead.next;
			i++;
		} while(fromHead!=tail);
		return false;
	} */
	
	/**
	 * recreating of the linked list for reversing
	 * идти с двух концов и менять местами
	 */
	 public void reverse(){
		 NodeList fromHead = head;
		 NodeList fromTail = tail;
		 Object change;
		 do {
			 change = fromHead.data;
			 fromHead.data=fromTail.data;
			 fromTail.data=change;
			 fromHead=fromHead.next;
			 fromTail=fromTail.prev;
		 } while ((fromTail.next!=fromHead)&&(fromTail!=fromHead));
	}
	 /**
	  * using previus (two directional list)
	  * @return true if a loop exists
	  */
	 public boolean hasLoop() {
		 NodeList fromHead = head;
		 NodeList fromHead2 = head.next;
		 do {
			 if (fromHead2.prev!=fromHead) return true;
			 fromHead=fromHead.next;
			 if (fromHead2.next!=null) fromHead2=fromHead2.next;
		 	}
		 while (fromHead!=tail);
		 return false;
	 }
	 
	 /**
	  * without using previous (one directional list)
	  * using traditional arrays/collections is prohibited
	  * O[N} algorithm complexity
	  * @return true if a loop exists
	  */
	 public boolean hasLoopPreviousCorrupted() {
		 NodeList slow = head;
		 NodeList fast = head;
		 while (fast != null && fast.next != null) {
		        slow = slow.next;
		        fast = fast.next.next;
		        if (slow == fast) { 
		           return true; // there is loop
		        }
		    }
		    if (fast == null || fast.next == null) {
		        return false; // there is no loop
		    }
		 return false;
	 }

	 /**
	  * tail of other (given) list will refer to the node of @this@ with indShared ind
	  * @param other
	  * @param indShared
	  * @return true if indShared has the correct value
	  */
	public boolean setSharedList(LinkedList<E> other, int indShared) {
		NodeList ind = head;
		NodeList ind2 = other.head;
		int i =0;
		while (i < indShared) {
			ind=ind.next;
			i++;
		}
		if (i<indShared) return false;
		int j=0;
		while (j<other.length()-1) {
				ind2=ind2.next;
				j++;
		}
		
		ind2.next=ind;
		return true;
	}
	/**
	 * getting index of "this" linked list shared
	 * @param other
	 * @return 0 or positive value if a sharing exists, else -1
	 */
	public int getSharedIndex(LinkedList<E> other) {
		NodeList ind = head;
		NodeList ind2 = other.head;
		int i=0;
		
		int len1=this.length();
		int len2=other.length();
		int maxlen=len1;
		if (len2<len1) {
			maxlen=len1;
			while (i<len1-len2) {
				ind=ind.next;
				i++;
			}
	//		System.out.println("changed");
			
		} else  {
			maxlen=len2;
			while (i<len2-len1) {
				ind2=ind2.next;
				i++;
	//		System.out.println("1st i ="+i);
			} 
		}
			int j=0;
			while (i<maxlen) {
		//		System.out.println("Comparing"+ind.data+" with "+ind2.data);
				if (ind.equals(ind2)) {
					if (maxlen==len2) return j; else return i;
				}
				ind=ind.next;
				ind2=ind2.next;
				i++;
				j++;
	//		System.out.println("2st i ="+i);
			}
		
		return -1;
	}
	public int length(){
		int i =0;
		Iterator<E> iterator = new ListIterator<E>(this); 
		while (iterator.hasNext()){
			iterator.next();
			i++;
		}
		return i;
	}
	
	public void fixLoop(){
		   if (hasLoopPreviousCorrupted()) {
			   
			   NodeList slow = head;
			   NodeList fast = head;
			   NodeList prev = head;
			 
			    /*Finding dot of meeting LOOP_SIZE-k steps*/
			    while (fast != null && fast.next != null) {
			        slow = slow.next;
			        fast = fast.next.next;
			  //      System.out.println("wo");
			        if (slow == fast) { //Коллизия
			           System.out.println(slow.data);
			           break;
			        }
			    }
			 
			    /* Moving slow to the Head. 
			     * Fast stays in place of meeting,
			     * all k steps from Loop Start.
			     * if they'll go
			     * they'll meet in place of Loop Start.
			     * I save Prev is previus from place of meeting
			     * to set after finding place, prev.next=null (set tail to prev)*/
			      slow = head;
			      while (slow != fast) {
			          slow = slow.next;
			          prev = slow;
			          fast = fast.next;
			          System.out.println(slow.data);
			          
			      }
			      prev.next=null;
			      
			      
		   }
	   }


}
