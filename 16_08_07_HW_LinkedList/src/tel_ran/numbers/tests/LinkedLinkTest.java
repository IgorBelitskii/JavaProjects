package tel_ran.numbers.tests;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.ListIterator;

import org.junit.Before;
import org.junit.Test;

import tel_ran.collections.LinkedList;

public class LinkedLinkTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(5);
		list.add(4);
		list.add(3);
		list.add(2);
		list.add(1);
		list.reverse(); // Преобразуем список 54321 -> 12345
		int i=1;
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			int type = (int) iterator.next();
			assertEquals(i, type); // testing Reverse
			i++;
		} 
		assertEquals(list.hasLoop(),false) ; // testing that there'se no loops
		assertEquals(list.hasLoopPreviousCorrupted(),false); // test2 that there'se no loops
	//	ListPrint(list);
		assertEquals(true, list.setLoop(2, 3));  // creating loop
		assertEquals(list.hasLoop(),true); //testing that there is loop
		assertEquals(list.hasLoopPreviousCorrupted(),true); //test2 that there is loop
		list.fixLoop();
//		ListPrint(list);
		assertEquals(list.hasLoopPreviousCorrupted(),false);
	}
	
	@Test
	public void TestListMerge(){
		LinkedList<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		//System.out.println(list.length());
		LinkedList<Integer> list2 = new LinkedList<>();
		list2.add(6);
		list2.add(7);
		list2.add(8);
	//	ListPrint(list);
	//	ListPrint(list2);
		//System.out.println(list2.length());
		assertEquals(list.getSharedIndex(list2), -1);
		assertEquals(list.setSharedList(list2, 2),true);
	//	ListPrint(list2);
		assertEquals(list.getSharedIndex(list2), 2);
 		
	}
	public void ListPrint(LinkedList<Integer> list){
		System.out.println(list+":");
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			System.out.print(iterator.next());
			if (iterator.hasNext()) System.out.print("->");
		} 
		System.out.println();
	}

}
