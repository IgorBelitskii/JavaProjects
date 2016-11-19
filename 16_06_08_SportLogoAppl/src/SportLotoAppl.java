public class SportLotoAppl {
	/**
	 * Написать аппликацию спортлото
	 * Выдает 7 случайных чисел от 1 до 49 и эти числа не повторяются
	 * массивы не иcпользовать и классы тоже
	 * 
	 * печатаем результат
	 *  проверить что число не повторяется
	 *  
	 *  
	 *только Random
	 * 
	 * */
	public static void main (String[] args) {
		
		int a;
		long save=0;
		for (int i = 0; i < 7; i++) {
			a=1 + (int)(Math.random() * 49); 
		//	System.out.println("Bit по a до"+getBitValue(save, a));
			while(getBitValue(save, a)==1) {
				a= 1 + (int)(Math.random() * 49); 
			}
			save=setBitValue(save, a, 1);
			System.out.println("Число №"+i+" = "+a);
		//	System.out.println("Bit по a после"+getBitValue(save, a));
			
		}
	}
	  public static int getBitValue(long number, int nBit) {
		  if (nBit < 0 || nBit > 64) {
		  return -1; 
		  }
		  number>>=nBit;
		  return (int) Math.abs(number % 2);
		     }
		     
    

		     public static long setBitValue(long number, int nBit, int bitValue) {
		     	 if (!checkBitNumber(nBit)||!checkBitValue(bitValue)) {
		     	     return number;
		     	 }
		     	 long mask = 1L << nBit;
		     	 if (getBitValue(number, nBit) == bitValue) {
		     	     return number;
		     	 }
		     	 return (long) (number ^ mask); // ^ - XOR
		     	    }

		     	    private static boolean checkBitValue(int bitValue) {
		     	 
		     	 return (bitValue == 0) || (bitValue == 1);
		     	    }

		     	    private static boolean checkBitNumber(int nBit) {

		     	 return nBit >= 0 && nBit <= 63;
		     	    }
}
