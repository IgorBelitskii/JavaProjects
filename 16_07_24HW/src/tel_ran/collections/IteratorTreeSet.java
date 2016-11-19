package tel_ran.collections;

import java.util.Iterator;

public class IteratorTreeSet<E extends Comparable<E>> implements Iterator<E> {
	private TreeSet<E>.NodeTree<E> current;
	private TreeSet<E> treeSet; 
	
	public IteratorTreeSet(TreeSet<E> treeSet) {
			this.treeSet=treeSet;
	}


	@Override
	public void remove() {
		treeSet.removeNote(current);
	}

	void setCurrent(TreeSet<E>.NodeTree<E> current) {
		this.current = current;
	}
	E getCurrent() {
		return current.data;
	}

	@Override
	public boolean hasNext() {
		TreeSet<E>.NodeTree<E> root=treeSet.getRoot();
		if (root==null) return false;

		if (this.current==null) return true;

		TreeSet<E>.NodeTree<E> max=root;
		while(max.right!=null){
			max=max.right;
		}
		if (treeSet.compareTreeNodes(this.current, max)>=0) return false;

		return true;
	}

	@Override
	public E next() {
		TreeSet<E>.NodeTree<E> root=treeSet.getRoot();
		if (root==null) return null;

		if (this.current==null) {
			TreeSet<E>.NodeTree<E> min=root;
			while(min.left!=null){
				min=min.left;
			}
			current=min;
			return min.data;
		}
		else {
			TreeSet<E>.NodeTree<E> next=this.current;

			if (next.right==null){ 
				while(next!=null && treeSet.compareTreeNodes(this.current, next)>=0){
					next=next.parrent;
				}
				current=next;
				return next.data;
			}
			else {
				next=next.right;
				while(next.left!=null){
					next=next.left;
				}
				current=next;
				return next.data;
			}
		}
	}
			

}
