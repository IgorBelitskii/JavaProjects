package tel_ran.bits;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestInteger {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		IntegerBit a= new IntegerBit(7);
		assertEquals(3, a.subValue(0,2));
		assertEquals(true, a.compareMask(5, 5)==0);
		
		IntegerBit b= new IntegerBit(127);
		assertEquals(true, b.compareMask(56, 31)>0);
		boolean mas[]={true,true,false,false,true};
		IntegerBit c= new IntegerBit(mas);
		assertEquals(true, c.compareMask(7, 3)==0);
		
		boolean mas1[]={true,true,true};
		IntegerBit d= new IntegerBit(mas1);
		assertEquals(true,d.number==7);
	
	//	
	}

}
