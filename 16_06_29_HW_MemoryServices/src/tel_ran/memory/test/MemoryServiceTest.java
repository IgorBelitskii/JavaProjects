package tel_ran.memory.test;
import tel_ran.memory.MemoryService;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MemoryServiceTest {
long [] array;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		
		int maxLongs=MemoryService.getMaxLongs();
	//	System.out.println(maxLongs);
		array=new long[maxLongs];
		array=null; // с этой строки и без этой строки
		boolean fl_exception=false;
		try {
			array = new long [maxLongs+1];
		} catch(Throwable e) {
			fl_exception=true;
		}
		assertTrue(fl_exception);
	
	}

}
