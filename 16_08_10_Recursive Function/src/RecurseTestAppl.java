
public class RecurseTestAppl {

	public static void main(String[] args) {
			byte n=5;
		System.out.println(factorial(n));
		int ar[]={10,-2,8};
		System.out.println(sum(ar));
		System.out.println(square(n));

	}
	private static int sum(int[] ar) {
		if ((ar==null)||(ar.length==0)) return 0;
		int k=ar.length;
	  return sumRecurse(ar, 0);
	}
	private static int sumRecurse (int[] ar, int i) {
		
		if (i==ar.length-1) return ar[i];
		return ar[i]+sumRecurse(ar,i+1);
	}
	public static long factorial(byte n) {
		
		if (n<2) return 1;
	
		return n*factorial((byte)(n-1));
	}
	
	/** 
	 * ДЗ  написать функцию без циклов без умножения и без написания дополнит. функций.
	 * @param x
	 * @return
	 */
	//	(x-1)^2=x^2-2*x-1 => x^2=(x-1)^2+x+x-1
	public static int square (int x) {		
		if (x<0) return square(-x);
		if (x==0) return 0;
		if (x==1) return 1;
	 return square(x-1)+x+x-1;
	}

}
