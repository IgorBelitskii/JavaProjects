package tel_ran.ranges.tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import tel_ran.ranges.PredicateFactor;
import tel_ran.ranges.PredicatePrimes;
import tel_ran.ranges.RangePredicate;

public class RangePredicateTest {
	RangePredicate rangeAll= new RangePredicate(1,6);
	RangePredicate rangeFactor10=new RangePredicate(1,55,new PredicateFactor(10));
	RangePredicate rangePrimes = new RangePredicate(1,6,new PredicatePrimes());
	RangePredicate rangeEven = new RangePredicate(1,6,new PredicateFactor(2));
	int expectedAll[]={1,2,3,4,5,6};
	int expectedFactor10[]={10,20,30,40,50};
	int expectedPrimes[]={2,3,5};
	int expectedEven[] ={2,4,6};

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testRangeAll() {
		testIterator(rangeAll,expectedAll);
		
	}
	
	private void testIterator(RangePredicate range, int[] expected) {
		int actual[] = new int [expected.length];
		int ind=0;
		for (int number : range) {
			actual[ind++]=number;
		}
		System.out.println(Arrays.toString(actual));
		assertArrayEquals(expected, actual);
	}

	@Test
	public void testRangeFactor10() {
		testIterator(rangeFactor10,expectedFactor10);
	}
	
	@Test
	public void testRangePrimes() {
		testIterator(rangePrimes,expectedPrimes);
	}
	
	@Test
	public void testEven() {
		testIterator(rangeEven,expectedEven);
	}

}
