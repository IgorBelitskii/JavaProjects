import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class joinTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		
		String[] a={"1","2","3","4","5"};
		assertEquals("1+2+3+4+5",StringsJoin.join(a,"+"));
		assertEquals("1+2+3+4+5",StringsJoin.joinBuilder(a,"+"));
	}

}
