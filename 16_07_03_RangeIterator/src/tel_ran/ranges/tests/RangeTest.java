package tel_ran.ranges.tests;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import tel_ran.ranges.Range;

public class RangeTest {
Range range = new Range(1,5); // последовательный набор значений
int expected[] = {1,2,3,4,5};

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testRangeInterator() {
		int ind=0;
		int actual[] = new int[expected.length];
				for(int number:range) 
					actual[ind++]=number;
			assertArrayEquals(expected,actual);
			Iterator<Integer> it = range.iterator();
			ind = 0;
			while (it.hasNext()) {
				actual[ind++]=it.next();
			}
			try {
				it.next();
				fail("No exception");
			} catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			assertArrayEquals(expected,actual);
	}

}
