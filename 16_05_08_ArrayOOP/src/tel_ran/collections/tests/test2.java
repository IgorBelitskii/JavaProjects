package tel_ran.collections.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import tel_ran.collections.Array;

public class test2 {
private static final int N_ELEMENTS = 10;
Array array = new Array();
	@Before
	public void setUp() throws Exception {
		for (int i=0; i<N_ELEMENTS; i++){
			array.add(i);
		}
	}

	@Test
	public void testSize(){
		assertEquals(N_ELEMENTS, array.size());
	}
	@Test
	public void testGet() {
			for (int i=0; i<N_ELEMENTS; i++) {
			assertEquals (i,array.get(i));
		}
		
	}
	
	@Test
	public void testAdd() {
		array.add(5, 77);
		assertEquals(77, array.get(5));
	
	}

}
