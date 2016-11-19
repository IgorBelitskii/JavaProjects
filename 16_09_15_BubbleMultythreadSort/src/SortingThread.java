import java.util.Arrays;

public class SortingThread extends Thread{
	public static int[] Array;
	public int indexFrom; //inclusive
	public int indexTo; //exclusive
	
	public int getIndexFrom() {
		return indexFrom;
	}

	public int getIndexTo() {
		return indexTo;
	}

	public static int[] getArray() {
		return Array;
	}

	public static void setArray(int[] array) {
		Array = array;
	}

	public SortingThread(int indexFrom, int indexTo) {
		super();
		this.indexFrom = indexFrom;
		this.indexTo = indexTo;
	}

	@Override
	public void run() {
		Arrays.sort(Array, indexFrom, indexTo);
	}


}
