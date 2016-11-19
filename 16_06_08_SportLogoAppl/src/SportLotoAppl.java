public class SportLotoAppl {
	/**
	 * �������� ���������� ���������
	 * ������ 7 ��������� ����� �� 1 �� 49 � ��� ����� �� �����������
	 * ������� �� �c���������� � ������ ����
	 * 
	 * �������� ���������
	 *  ��������� ��� ����� �� �����������
	 *  
	 *  
	 *������ Random
	 * 
	 * */
	public static void main (String[] args) {
		
		int a;
		long save=0;
		for (int i = 0; i < 7; i++) {
			a=1 + (int)(Math.random() * 49); 
		//	System.out.println("Bit �� a ��"+getBitValue(save, a));
			while(getBitValue(save, a)==1) {
				a= 1 + (int)(Math.random() * 49); 
			}
			save=setBitValue(save, a, 1);
			System.out.println("����� �"+i+" = "+a);
		//	System.out.println("Bit �� a �����"+getBitValue(save, a));
			
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
