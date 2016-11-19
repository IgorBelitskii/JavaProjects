package tel_ran.queues;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;

public class QueueTest {
	int size=10000000,x;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		
		LimitedQueue<Integer> qu = new LimitedQueue<Integer>(size);
		LimitedQueue<Integer> qu1 = new LimitedQueue<Integer>(size);
		Random random = new Random();
		for (int i = 0; i < size+1; i++) {
			try {
				x=random.nextInt(Integer.MAX_VALUE);
				qu.add(x);
				qu1.add(x);
			} catch (OutofLimitException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		qu.info();
		for (int i = 0; i < size; i++) {
			try {
				assertEquals(qu.offer(),qu1.getElement(i));
			} catch (EmptyQueueException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		qu.info();
		try {
			qu.offer();
		} catch (EmptyQueueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
