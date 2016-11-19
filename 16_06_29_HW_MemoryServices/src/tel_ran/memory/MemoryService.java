package tel_ran.memory;


public class MemoryService {
	public static void main(String args[]) {
	//	System.out.println(getMaxLongs());
	}
	public static int getMaxLongs() {
			int low = 0, high = Integer.MAX_VALUE, mid=0;
			while (low < high) {
				mid = (low >>> 1) + (high>>>1);
						try {
							long[] arrayLongs = new long[mid];
							low = mid + 1;
							}
						catch (Throwable e) {
						high = mid;
						}
			}		
		return low-1;
		
	}

}
