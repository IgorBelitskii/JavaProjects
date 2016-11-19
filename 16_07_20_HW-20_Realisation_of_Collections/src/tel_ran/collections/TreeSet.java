package tel_ran.collections;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ArrayList.Itr;

public class TreeSet<E extends Comparable<E>> implements NavigableSet<E> {
public class NodeTree<E extends Comparable<E>> {
	 E data;
	 NodeTree<E> parent, left, right;
	 
}
	private NodeTree<E> root;
	 
	 
	public void add(E data) {
		NodeTree<E> newNode = new NodeTree<E>();
		newNode.data=data;
		NodeTree<E> current = root;
		if (root==null) {
			root=newNode;
			return;
		}
		int resCompare = 0;
		NodeTree<E> parent = null;
		while(current!=null) {
			parent=current;
			resCompare=compareTreeNodes(current, newNode);
			if (resCompare==0)
				return;
			current=resCompare >0 ? current.left: current.right;
		}
		if(resCompare >0) 
			parent.left=newNode;
		else parent.right=newNode;
		newNode.parent=parent;
	}


	private int compareTreeNodes(NodeTree<E> current, NodeTree<E> newNode) {
		
		return current.data.compareTo(newNode.data);
	}



@Override
public void remove(E number) {
	NodeTree<E> nodeToDelete = new NodeTree<E>();
	nodeToDelete.data=number;
	NodeTree<E> current = root;
	if (root.data.compareTo(number)==0) {
		root=null;
		return;
	}
		while (current != null) {
			int resCompare=compareTreeNodes(current, nodeToDelete);
			if (resCompare==0) {
				// удаляем 
				if ((current.left!=null)&&(current.right!=null)) {
					NodeTree<E> currentRight = current.right;
					while (currentRight.left!=null) {
						currentRight=currentRight.left;
					}
					currentRight.parent.left=null;
					currentRight.parent=current.parent;
					currentRight.left=current.left;
					currentRight.right=current.right;
					current.parent.right=currentRight;
					current.left.parent=currentRight;
					current.right.parent=currentRight;
					return;				
				} else if (current.left==null) {
					NodeTree<E> currentRight = current.right;
					currentRight.parent=current.parent;
					current.parent.left=currentRight;
					return;								
				} else if (current.right==null) {
					NodeTree<E> currentLeft = current.left;
					currentLeft.parent=current.parent;
					current.parent.right=currentLeft;
				} else  {
					current.parent=null;
					return;
				}
				
			}
			current=resCompare >0 ? current.left: current.right;
		}
	
	// Описание функции удаления
	//Суть - замена элементов
	// если неполный узел - перекидываем
	// если полный узел - превращаем ее в ситуацию с неполным узлом
	//заменой. Либо меняем на наименьший среди больших или на наибольший среди меньших
	
	
	
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
public boolean contains(E data) {
	TreeSet<E>.NodeTree<E> current= root;
	NodeTree<E> pattern = new NodeTree<>();
	pattern.data=data;
	while (current != null) {
		int resCompare=compareTreeNodes(current, pattern);
		if (resCompare==0) return true;
		current=resCompare >0 ? current.left: current.right;
	}
	return false;
}

@Override
public Iterator<E> iterator() {
    return new Itr();
}

private class Itr implements Iterator<E> ()
{
	 NodeTree<E> current; 
	 
	 public boolean hasNext() {
		 if (current.right!=null) return true;
		 
	 
         return false;
     }

     @SuppressWarnings("unchecked")
     public E next() {
         checkForComodification();
         int i = cursor;
         if (i >= size)
             throw new NoSuchElementException();
         Object[] elementData = ArrayList.this.elementData;
         if (i >= elementData.length)
             throw new ConcurrentModificationException();
         cursor = i + 1;
         return (E) elementData[lastRet = i];
     }

     public void remove() {
         if (lastRet < 0)
             throw new IllegalStateException();
         checkForComodification();

         try {
             ArrayList.this.remove(lastRet);
             cursor = lastRet;
             lastRet = -1;
             expectedModCount = modCount;
         } catch (IndexOutOfBoundsException ex) {
             throw new ConcurrentModificationException();
         }
	 
}
}
     /* 1) First element  - most left element in tree
	2) next - going right and finding least (smallest) from among the greater ones
if there is right = going right and going all times to left
if right == null -> looking for the parent, greater than current
if right != null - >see 1;

Алгоритм удаления


*/

@Override
public NavigableSet<E> subSet(E from, boolean inclusiveFrom, E to, boolean inclusiveTo) {
	// TODO Auto-generated method stub
	return null;
}

}
