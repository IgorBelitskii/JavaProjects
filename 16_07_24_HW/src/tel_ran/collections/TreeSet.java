package tel_ran.collections;

import java.util.Iterator;

public class TreeSet<E extends Comparable<E>> implements NavigableSet<E> {

	@SuppressWarnings("hiding")
	class NodeTree<E extends Comparable<E>>{
		E data;
		NodeTree<E> parrent;
		NodeTree<E> left;
		NodeTree<E> right;
	}
	private NodeTree<E> root;
	
	public NodeTree<E> getRoot() {
		return root;
	}

	@Override
	public void add(E data) {
		NodeTree<E> newNode=new NodeTree<>();
		newNode.data=data;
		
		NodeTree<E> current=root;
		NodeTree<E> parrent=null;
		if (root==null) {	root=newNode;
			return;
		}
		int resCompare=0;
		while(current!=null){
			parrent=current;
			resCompare=compareTreeNodes(current,newNode);
			if (resCompare==0) return;
			current=resCompare>0?current.left: current.right;
		}
		if (resCompare>0) 
			parrent.left=newNode;
		else 
			parrent.right=newNode;
	
		newNode.parrent=parrent;
	}

	int compareTreeNodes(NodeTree<E> current, NodeTree<E> newNode) {
		//return current.data.compareTo(newNode.data);
		return compareTreeData(current.data,newNode.data);
	}
	
	int compareTreeData(E current, E newValue) {
		return current.compareTo(newValue);
	}
	
	@Override
	public void remove(E data) {
		if (root==null) return;
		
		NodeTree<E> newNode=new NodeTree<>();
		newNode.data=data;

		NodeTree<E> current=root;
		int resCompare=0;
		while(current!=null){
			resCompare=compareTreeNodes(current,newNode);
			if (resCompare==0) {
				removeNote(current);
				return;
					};
			
			current=resCompare>0?current.left: current.right;
		}
				
	}

	void removeNote(TreeSet<E>.NodeTree<E> current) {
		NodeTree<E> temp=null;
		if (current==root){
			if (current.left!=null && current.right!=null){
				root=current.left;

				temp = current.left;
				while (temp!=null && (temp.right!=null || temp.left!=null)){
					temp= (temp.right!=null) ? temp.right : temp.left;
				} 
				temp.right=current.right;
				current.right.parrent=temp;

			}
			else if (current.left!=null)
				root=current.left;
			else 
				root=current.right;
		}
		else {

			boolean parrentRight= (current.parrent.right==current);

			//can to move left
			if (current.left!=null){
				temp = current.left;

				while(temp.right!=null){
					temp=temp.right;
				}

				//if no only move one left 
				if (temp != current.left) {
					temp.parrent.right=temp.left;
					if (temp.left!=null) temp.left=temp.parrent;
				}
		
				//right new
				temp.right=current.right;
				if (current.right!=null) current.right.parrent=temp;
				
				//parrent to new current
				temp.parrent=current.parrent;
				if (parrentRight) current.parrent.right=temp; else current.parrent.left=temp;

			}
			//can to move right
			else if (current.right!=null) {
				temp = current.right;

				while(temp.left!=null){
					temp=temp.left;
				}
				
				//if no only move one right 
				if (temp != current.right) {
					temp.parrent.left=temp.right;
					if (temp.right!=null) temp.right=temp.parrent;
				}

				//left new
				temp.left=current.left;
				if (current.left!=null) current.left.parrent=temp;
				
				//parrent to new current
				temp.parrent=current.parrent;
				if (parrentRight) current.parrent.right=temp; else current.parrent.left=temp;
			}

			//NO move
			else {
				if (parrentRight) current.parrent.right=null; else current.parrent.left=null;
				current=null; 	
			}

			}
	}
			

	@Override
	public void retainAll(Collection<E> collection) {
		Iterator<E> itTreeSet=this.iterator();
		while(itTreeSet.hasNext()){
			E number = itTreeSet.next();
			Iterator<E> itCollection=collection.iterator();
			boolean existValue=false;
			while(itCollection.hasNext() && !existValue){
				if (itCollection.next().equals(number))
					existValue=true;
			}
			if (!existValue) 
				itTreeSet.remove();
		}
		
	}

	@Override
	public void removeAll(Collection<E> collection) {
		Iterator<E> itTreeSet=this.iterator();
		while(itTreeSet.hasNext()){
			E number = itTreeSet.next();
			Iterator<E> itCollection=collection.iterator();
			while(itCollection.hasNext()){
				E element = itCollection.next();
				if (element!=null)
					if (element.equals(number)) {
						itTreeSet.remove();
						//break;
					}
						
			}
		}
		
	}

	@Override
	public boolean contains(E data) {
		TreeSet<E>.NodeTree<E> current=null;
		NodeTree<E> pattern = new NodeTree<>();
		pattern.data=data;
		while (current !=null){
			int resCompare = compareTreeNodes(current, pattern);
			if (resCompare==0) return true;
			current= (resCompare>0)? current.left: current.right;
		}
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		return new IteratorTreeSet<E>((TreeSet<E>)this);

		
	}

	@Override
	public NavigableSet<E> subSet(E from, boolean inclusiveFrom, E to, boolean inclusiveTo) {

		NavigableSet<E> subSet = new TreeSet<E>() ;
		IteratorTreeSet<E> it = (IteratorTreeSet<E>)(this.iterator());
		
		NodeTree<E> nodeLeft = foundNode(from,inclusiveFrom);
		if (nodeLeft==null) return subSet;
		
		it.setCurrent(nodeLeft);
		subSet.add(it.getCurrent());
		E element;
		int comp=0;

		while (it.hasNext() && comp<=0) {
			element = it.next();
			comp=compareTreeData(element, to);
			if ( (comp==0 && inclusiveTo)  || comp<0)
				subSet.add(element);
		}
		return subSet;
	}

	private TreeSet<E>.NodeTree<E> foundNode(E pattern, boolean inclusive) {

		TreeSet<E>.NodeTree<E> current=root;
		int resCompare;
		
		while (current !=null){
			resCompare = compareTreeData(current.data, pattern);
			
			if (resCompare==0 && inclusive) 
				return current;
			else if ((resCompare<0) || (resCompare==0 && !inclusive))
				current=current.right; 
			else if (resCompare>0)  {
				if (current.left!=null) {
					resCompare = compareTreeData(current.left.data, pattern);
					if (resCompare==0 && inclusive) return current.left;
					else if (resCompare>0) current=current.left; else return current;
					
				}
				else return current;
			}
		}
		
		return null;
	}
}
