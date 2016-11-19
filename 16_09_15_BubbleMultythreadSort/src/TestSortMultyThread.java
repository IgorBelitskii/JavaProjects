import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class TestSortMultyThread {
	private static final int NUMBER_OF_ELEMENTS = 1000000;
	private static final int NUMBER_OF_THREADS = 4;
	public static int[] array= new int[NUMBER_OF_ELEMENTS];
	SortingThread[] threads = new SortingThread[NUMBER_OF_THREADS];

	@Before
	public void setUp() throws Exception {
		Random random = new Random();
		
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(Integer.MAX_VALUE);
		}
		
		SortingThread.setArray(array);

	}

	@Test
	public void test() {
		int step=NUMBER_OF_ELEMENTS/NUMBER_OF_THREADS;
		long time0=System.currentTimeMillis();
		for (int i = 0; i < threads.length; i++) {
			int from=i*step;
			int to=step*(i+1);
			if (i==threads.length-1) to = NUMBER_OF_ELEMENTS; 
			threads[i] = new SortingThread(from,to);
			threads[i].start();
		}
		for (int i = 0; i < threads.length; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {

			}
		}
		int[] arr = mergeThreads(threads);
		long time1=System.currentTimeMillis();
		System.out.println("Time1 = "+(time1-time0));
		long time2=System.currentTimeMillis();
		Arrays.sort(array);
		long time3=System.currentTimeMillis();
		System.out.println("Time2 = "+(time3-time2));
		assertArrayEquals(array, arr);
	}

private static int[] mergeThreads(SortingThread[] threads) {
	int [] newarr= new int[NUMBER_OF_ELEMENTS];
	
	int indFrom = threads[0].getIndexFrom();
	int indTo = threads[0].getIndexTo();
	int[] temparr = new int[indTo-indFrom];
	for (int i = 0; i < temparr.length; i++) {
		temparr[i]=array[i];
	}
	for (int i = 1; i < threads.length; i++) {
		indFrom = threads[i].getIndexFrom();
		indTo = threads[i].getIndexTo();
		int [] ntemparr = merge2arrays(temparr, 0, temparr.length, array, indFrom, indTo);
		temparr=ntemparr;
	}
	return temparr;
}

private static int[] merge2arrays(int[] array1, int indFrom, int indTo, int[] array2, int indFrom2, int indTo2){
int [] newarr = new int[indTo-indFrom+indTo2-indFrom2];
int point=0;
int c1=indFrom;
int c2=indFrom2;
while (true) {
	if ((c1>=indTo)&&(c2>=indTo2)&&(point>=newarr.length-1)) {
		 break;
	 } else if (c1>=indTo) {
		 newarr[point++]=array2[c2++];
	 } else if (c2>=indTo2) {
		 newarr[point++]=array1[c1++];
	 } else if (array1[c1]<=array2[c2]) {
		newarr[point++]=array1[c1];
		if (c1<indTo) c1++;
	 } else {
		newarr[point++]=array2[c2];
		 if (c2<indTo2) c2++;
	 }
}
return newarr;
}

}
