package tel_ran.math;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Random;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestMatrix {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Random random = new Random();
		int size = random.nextInt(10)+5;
		int istr = random.nextInt(10)+5;
		Integer str[] = new Integer [istr];
		Integer [] [] arr = new Integer [size] [size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j <size; j++) {
				arr[i] [j] = (random.nextInt(9));
			}
		}
		Matrix <Integer> matrix = new Matrix <Integer>(arr);
		matrix.print();
		for (int i=0; i<istr; i++) {
			str[i]=random.nextInt(9);
		}
		matrix.addColumn(str);
		matrix.print();
		assertArrayEquals(str,Arrays.copyOf(matrix.matrix[size], istr));
		for (int i=0; i<istr; i++) {
			str[i]=random.nextInt(9);
		}
		matrix.addRow(str);
		for (int i = 0; i < istr; i++) {
			assertEquals(matrix.matrix[i][matrix.size-1].equals(str[i]), true);
		}
		matrix.print();
		Object [] [] arr1 = new Object [matrix.size] [matrix.size];
		arr1=matrix.matrix;
		matrix.transp();
		matrix.print();
		for (int i = 0; i < matrix.size; i++) {
			for (int j = 0; j<matrix.size; j++) {
			 if (arr1[j][i]!=null) {
				assertEquals(matrix.matrix[i][j].equals(arr1[j][i]), true);
			 }
		   }
		}

	}

}
