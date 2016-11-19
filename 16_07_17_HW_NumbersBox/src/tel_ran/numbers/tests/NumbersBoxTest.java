package tel_ran.numbers.tests;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.junit.Before;
import org.junit.Test;

import tel_ran.numbers.implementation.NumbersBoxArrayList;
import tel_ran.numbers.implementation.NumbersBoxHashSet;
import tel_ran.numbers.implementation.NumbersBoxLinkedList;
import tel_ran.numbers.implementation.NumbersBoxTreeSet;
import tel_ran.numbers.interfaces.INumbersBox;

public class NumbersBoxTest {
	Integer [] array = {2,10,5,40,2};
	Integer [] expectedOne={10,5,40};
	Integer [] expectedAll={10,5,40};
	Integer [] expectedEven={5};
	Integer [] expectedOdd={2,10,40};
	Integer [] arrayUnion = {2,5,3};
	Integer [] arrayIntersection = {2,5,7};
	Integer [] arraySubstraction = {5,2};
	Integer [] expectedUnion = {2,10,5,40,3};
	Integer [] expectedIntersection = {2,5};
	Integer [] expectedRemoveRepeated = {2,10,5,40};
	Integer [] expectedSubstraction = {10,40};
	INumbersBox box;
	INumbersBox boxUnion;
	INumbersBox boxIntersection;
	INumbersBox boxSubstraction;

	@Before
	public void setUp() throws Exception {
//		box = new NumbersBoxArrayList(); 	 //tested
//		box = new NumbersBoxHashSet();		//tested
//   	box = new NumbersBoxLinkedList();	//tested
		box = new NumbersBoxTreeSet();		//tested
		for(int number:array)
			box.addNumber(number);
		
	}

	@Test
	public void testGetNumbersInRange() {
		box=box.getNumbersInRange(9, 40);
		box.removeRepeated();
		box.print();
		testArray(expectedSubstraction);
	}
	@Test
	public void testRemoveOne() {
		box.removeRepeated();
		box.removeNumber(2);
	//	box.print();
		testArray(expectedOne);
	}
	
	private void testArray(Integer[] expected) {
		LinkedList<Integer> list = new LinkedList<>();
		for(int number:box) 
			list.add(number);
		
		assertArrayEquals(Sort(expected),Sort(list.toArray(new Integer[list.size()])));
		
	}
	private Integer[] Sort(Integer[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 1; j < array.length; j++) {
				if (array[j]>array[j-1]) {
					int x=array[j];
					array[j]=array[j-1];
					array[j-1]=x;
				}
			}
		}
		
		return array;
	}

	@Test
	public void testRemoveAll() {
		box.removeAllNumbers(2);
		testArray(expectedAll);
	}
	
	@Test
	public void findNumbers() {
		box=box.findNumbers(t->t%2==1);
		//box=box.findNumbers(even);
		testArray(expectedEven);
	}
	
	@Test
	public void RemoveAllNumbersPredicate() {
		EvenPredicate even = new EvenPredicate();
		box.removeAllNumbers(t->t%2!=0);
		//box.removeAllNumbers(even);
		box.removeRepeated();
		testArray(expectedOdd);
	}
	
	@Test
	public void Union() {
		boxUnion = new NumbersBoxArrayList();
		for(int number:arrayUnion)
			boxUnion.addNumber(number);
		box.union(boxUnion);
		box.removeRepeated();
		testArray(expectedUnion);
	}
	
	@Test
	public void Intersection() {
		boxIntersection = new NumbersBoxArrayList();
		for(int number:arrayIntersection)
			boxIntersection.addNumber(number);
		box.intersection(boxIntersection);
		box.removeRepeated();
		testArray(expectedIntersection);
	}
	
	@Test
	public void RemoveRepeated() {
		box.removeRepeated();
		testArray(expectedRemoveRepeated);
	}
	
	@Test
	public void Subsctraction() {
		boxSubstraction = new NumbersBoxArrayList();
		for(int number:arraySubstraction)
			boxSubstraction.addNumber(number);
		box.subtract(boxSubstraction);
		testArray(expectedSubstraction);
	}
	
	@Test
	public void PerfomanceTest(){
		int NUMBER = 100000, n2=100, n3=100, n4=100;
		INumbersBox boxArrayList = new NumbersBoxArrayList(); 		
		INumbersBox boxLinkedList = new NumbersBoxLinkedList();	
		INumbersBox boxTreeSet = new NumbersBoxTreeSet();	
		INumbersBox boxHashSet = new NumbersBoxHashSet();	
		System.out.println("-------=:[ Adding test ]:=-----------");
		System.out.println("boxArrayList: "+run(boxArrayList, "add", NUMBER));
		System.out.println("boxLinkedList: "+run(boxLinkedList, "add", NUMBER));
		System.out.println("boxTreeSet: "+run(boxTreeSet, "add", NUMBER));
		System.out.println("boxHashSet: "+run(boxHashSet, "add", NUMBER));
		System.out.println("-------=:[ Get Numbers in Range test ]:=-----------");
		System.out.println("boxArrayList: "+run(boxArrayList, "range", n2));
		System.out.println("boxLinkedList: "+run(boxLinkedList, "range",n2));
		System.out.println("boxTreeSet: "+run(boxTreeSet, "range", n2));
		System.out.println("boxHashSet: "+run(boxHashSet, "range", n2));
		System.out.println("-------=:[ Union test ]:=-----------");
		System.out.println("boxArrayList: "+run(boxArrayList, "union", n3));
		System.out.println("boxLinkedList: "+run(boxLinkedList, "union",n3));
		System.out.println("boxTreeSet: "+run(boxTreeSet, "union", n3));
		System.out.println("boxHashSet: "+run(boxHashSet, "union", n3));
		System.out.println("-------=:[ Remove Repeated ]:=-----------");
		System.out.println("boxArrayList: "+run(boxArrayList, "rr", n4));
		System.out.println("boxLinkedList: "+run(boxLinkedList, "rr",n4));
		System.out.println("boxTreeSet: "+run(boxTreeSet, "rr", n4));
		System.out.println("boxHashSet: "+run(boxHashSet, "rr", n4));
	}
	
	public long run(INumbersBox iBox, String function, int number) {
		long time0, time1, time=0;
		Random random = new Random();	
		
		switch (function)
		{
		case "add" : { 
						time0=System.currentTimeMillis();
						for (int i = 0; i < number; i++) 
						{
							iBox.addNumber(random.nextInt(Integer.MAX_VALUE));
							
						}	
						time1=System.currentTimeMillis();
						time=time1-time0;
						break;
					}
		case "range" : { 
			int range1=random.nextInt(Integer.MAX_VALUE);
			int range2=random.nextInt(Integer.MAX_VALUE);
			if (range2<range1) {
				int x = range1;
				range1=range2;
				range2=x;
			}
			time0=System.currentTimeMillis();
			for (int i = 0; i < number; i++) 
			{
				INumbersBox newBox = iBox.getNumbersInRange(range1, range2);
				
			}	
			time1=System.currentTimeMillis();
			time=time1-time0;
			break;
		}
		case "union" : { 
			INumbersBox newBox1=null, newBox2=null;
			Class<? extends INumbersBox> c = iBox.getClass();
			try {
				newBox1=c.newInstance();
				newBox2=c.newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (int i = 0; i < 1000; i++) 
			{
				newBox1.addNumber(random.nextInt(Integer.MAX_VALUE));
				newBox2.addNumber(random.nextInt(Integer.MAX_VALUE));
				
			}
			time0=System.currentTimeMillis();
			for (int i = 0; i < number; i++) 
			{
				
				newBox1.union(newBox2);

				
			}	
			time1=System.currentTimeMillis();
			time=time1-time0;
			break;
		}
		case "rr" : { 
			time0=System.currentTimeMillis();
			for (int i = 0; i < number; i++) 
			{
				iBox.removeRepeated();
				
			}	
			time1=System.currentTimeMillis();
			time=time1-time0;
			break;
		}
		
		}
	
	
		return time;
	}
	


}
