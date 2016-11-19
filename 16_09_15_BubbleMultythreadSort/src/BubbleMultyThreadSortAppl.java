import java.util.Arrays;
import java.util.Random;

/*
 * 
 *  * 
 * параллельна€ сортировка (пузырьковаz) BubbleSorting
 * 100 000 элементов делитс€ на группы
 * кол-во thread - параметр
 * 
 * например 100 потоков каждый THREAD сортирует свою часть
 * 
 * а потом все части соедин€ютс€
 * 
 * ” thread ов ссылка на один и то же массив.
 * и индексы с какого по какой(по какой не включаетс€)
 * т.к. каждый синхронизирует свою часть самосто€тельно
 * Arrays.sort(int [] ar, int from, int to)
 * to - not inclusive
 * 
 * 
 * ((((((a+b)+c)+d)+e)...)
 * 
 * 
 * ‘ункци€ Merge сортирует
 * 
 *  5 8 20 50
 *  
 *  6 7 30 35
 *  
 *  формируем дополнительный массив
 *  перемеща€ индексы этих двух массивов
 * 
 * 
 */
public class BubbleMultyThreadSortAppl {
	
private static final int NUMBER_OF_ELEMENTS = 1000;
private static final int NUMBER_OF_THREADS = 50;
public static int[] array= new int[NUMBER_OF_ELEMENTS];

public static void main(String[] args) {
	
	
	SortingThread[] threads = new SortingThread[NUMBER_OF_THREADS];
	Random random = new Random();
	
	for (int i = 0; i < array.length; i++) {
		array[i] = random.nextInt(Integer.MAX_VALUE);
	}
	
	SortingThread.setArray(array);
	int step=NUMBER_OF_ELEMENTS/NUMBER_OF_THREADS;
	int plus=NUMBER_OF_ELEMENTS%NUMBER_OF_THREADS;
	if (plus!=NUMBER_OF_ELEMENTS-step*NUMBER_OF_THREADS) System.err.println("ERROR");
	
	for (int i = 0; i < threads.length; i++) {
		int from=i*step;
		int to=step*(i+1);
		if (i==threads.length-1) to = NUMBER_OF_ELEMENTS; 
		System.out.println("Created thread n "+i+", from "+from+" to "+to);
		threads[i] = new SortingThread(from,to);
		threads[i].start();
	}

	//Arrays.sort(array);
	for (int i = 0; i < threads.length; i++) {
		try {
			threads[i].join();
		} catch (InterruptedException e) {

		}
	}

//	array=mergeThreads(threads);
	System.out.println("After sorting multy threads..."); 
	printArray(array);
	System.out.println("After merging results of sorting...."); 
	int[] arr = mergeThreads(threads);
	printArray(arr);
	
//	int[] arr = merge2arrays(array, threads[0].getIndexFrom(), threads[0].getIndexTo(),array, threads[1].getIndexFrom(), threads[1].getIndexTo());

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




public static void printArray(int[] array) {
	System.out.println("Length array is "+array.length);
	for (int i = 0; i < array.length; i++) {
		System.out.println(array[i]);
	}
}
}
