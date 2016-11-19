package tel_ran.numbers.tests;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import tel_ran.numbers.implementation.NumbersBoxArrayList;
import tel_ran.numbers.interfaces.INumbersBox;

public class NumbersBoxTest {
	Integer [] array = {2,10,5,40,2};
	Integer [] expectedOne={10,5,40,2};
	Integer [] expectedAll={10,5,40};
	Integer [] expectedEven={5};
	Integer [] expectedOdd={2,10,40,2};
	Integer [] arrayUnion = {2,5,3};
	Integer [] arrayIntersection = {2,5,7};
	Integer [] arraySubstraction = {5,2};
	Integer [] expectedUnion = {2,10,5,40,2,3};
	Integer [] expectedIntersection = {2,5,2};
	Integer [] expectedRemoveRepeated = {10,5,40,2};
	Integer [] expectedSubstraction = {10,40};
	INumbersBox box;
	INumbersBox boxUnion;
	INumbersBox boxIntersection;
	INumbersBox boxSubstraction;

	@Before
	public void setUp() throws Exception {
		box = new NumbersBoxArrayList();
		for(int number:array)
			box.addNumber(number);
		
	}

	@Test
	public void testRemoveOne() {
		box.removeNumber(2);
		testArray(expectedOne);
	}
	
	private void testArray(Integer[] expected) {
		LinkedList<Integer> list = new LinkedList<>();
		for(int number:box) 
			list.add(number);
		assertArrayEquals(expected,list.toArray(new Integer[list.size()]));
		
	}

	@Test
	public void testRemoveAll() {
		box.removeAllNumbers(2);
		testArray(expectedAll);
	}
	
	@Test
	public void findNumbers() {
		EvenPredicate even = new EvenPredicate();
		box=box.findNumbers(t->t%2==1);
		//box=box.findNumbers(even);
		testArray(expectedEven);
	}
	
	@Test
	public void RemoveAllNumbersPredicate() {
		EvenPredicate even = new EvenPredicate();
		box.removeAllNumbers(t->t%2!=0);
		//box.removeAllNumbers(even);
		testArray(expectedOdd);
	}
	
	@Test
	public void Union() {
		boxUnion = new NumbersBoxArrayList();
		for(int number:arrayUnion)
			boxUnion.addNumber(number);
		box.union(boxUnion);
		testArray(expectedUnion);
	}
	
	@Test
	public void Intersection() {
		boxIntersection = new NumbersBoxArrayList();
		for(int number:arrayIntersection)
			boxIntersection.addNumber(number);
		box.intersection(boxIntersection);
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
	


}
