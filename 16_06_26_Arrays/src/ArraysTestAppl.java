import java.util.Arrays;
import java.util.Comparator;

public class ArraysTestAppl {

	public static void main(String[] args) {
		
		int ar1[]={1,10,5,20,3};
		Integer [] ar2 = {1,10,5,20,3};
		System.out.println("ar1:"+Arrays.toString(ar1));
		System.out.println("ar2:"+Arrays.deepToString(ar2));
		int [] ar3={40,-3,20,80};
		int [] ar4=ar1;
		int [] [] arr1={ar1,ar3,ar4};
		System.out.println("arr1:"+Arrays.deepToString(arr1));
		int ind=4;
		ar4[ind]=10;
		System.out.println("arr1:"+Arrays.deepToString(arr1));
		Arrays.sort(ar1);
		System.out.println("arr1:"+Arrays.deepToString(arr1));
		Arrays.sort(ar2, new EvenOddComparator());
		System.out.println("ar2"+ Arrays.toString(ar2));
		Arrays.sort(ar2, new Comparator<Integer>() {

			@Override
			public int compare(Integer arg0, Integer arg1) {
				// TODO Auto-generated method stub
				return arg0%2==0? 1: -1;
			}
			
		});
		System.out.println("ar2"+ Arrays.toString(ar2));
		System.out.println("--ar1:"+Arrays.toString(ar1));
		System.out.println("ar1"+Arrays.toString(insertNumberSorted(ar1, 3)));
		System.out.println("ar1"+Arrays.toString(insertNumberSorted(ar1, 5)));
		System.out.println("ar1"+Arrays.toString(removeNumberSorted(ar1, 5)));
		System.out.println("ar1"+Arrays.toString(removeNumberSorted(ar1, 20)));
	/*	Arrays.sort(ar1, new EvenOddComparator());
		System.out.println("ar1"+ Arrays.toString(ar1));*/
		}
	/**
	 * inserts the given number into the given sorted aray with keeping order
	 * @param array sorted array of integers
	 * @param number - one integer
	 * returns arrat[]
	 */
	public static int[] insertNumberSorted(int [] array, int number) {
		int[] arr = new int[array.length+1];
		int bin = Arrays.binarySearch(array, number);
		System.out.println(bin);
		if (bin<0) bin=0-bin-1;
	/*	Arrays.copyOfRange(array,0,bin);*/
		System.arraycopy(array, 0, arr, 0, bin);
		arr[bin]=number;
		System.arraycopy(array, bin, arr, bin+1, array.length-bin);
		return arr;
	}
	/***
	 * 
	 * @param array sorted 
	 * @param number - to be removed
	 * @return new array with no the given number if number exists
	 */
	public static int[] removeNumberSorted(int [] array, int number) {
		
		int bin = Arrays.binarySearch(array, number);
		if (bin<0) return array;
		System.out.println(bin);
		int[] arr = new int[array.length-1];
			
	/*	Arrays.copyOfRange(array,0,bin);*/
	/*	int[] ar1 = Arrays.copyOf(array, array.length-1);
		System.arraycopy(array, bin, ar1, bin, array.length-bin-1);*/
		System.arraycopy(array, 0, arr, 0, bin);
		System.arraycopy(array, bin+1, arr, bin, arr.length-bin);
		return arr;
	}
	

}
