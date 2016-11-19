package tel_ran.bits;

public class IntegerBit {

	int number;
	public IntegerBit(int number) {
	
		this.number=number;
	}
	
	/**
	 * 
	 * @param bits
	 * должен построить число по массиву переданных битов
	 * bit value ==1, false value ==0
	 * array value at index i equals bit value at bit number
	 * missing array values are zero bit values at the proper positions
	 */
	public IntegerBit(boolean[] bits) {
		int size = bits.length;
		number=0;
		for (int i = 0; i < size; i++) {
			if (bits[i]==true) number=BitwiseOperators.setBitValue(number, i, 1); 
				else number=BitwiseOperators.setBitValue(number, i, 0);
		}
	}
	
	/**
	 * 
	 * @param nBit
	 * @param length
	 * @return integer Value of the number part extracted from bit with number nBit and amount of bits equaled to the given length
	 * 
	 * 32 = вернуть число
	 * 31 - вернуть число битов
	 * если от 0 до 8 значение нулевого байта
	 * вернуть кусок числа длиной length которое равно значению бит этого числа 
	 * пример
	 * examples number = 7
	 * 
	 * subValue(0,2)=3
	 */
	public int subValue(int nBit, int length) {
		
		int num=0;
		if (nBit==32) return number;
		for (int i = nBit; i < nBit+length; i++) {
			num=BitwiseOperators.setBitValue(num, i, BitwiseOperators.getBitValue(number, i));
		}
		return num;
	}
	/**
	 * Сравнивает биты по маске
	 * 0 если биты равны
	 * если текущее число (number) по маске больше чем othernumber то больше нуля, если нет то меньше нуля
	 * 
	 * Comparing this.number with otherNumber only part extracted according to the given mask
	 * comparing just bits watching 1 in the given mask
	 * 
	 * @param otherNumber
	 * @param mask
	 * @return
	 * 
	 * при -1 сравниваются все биты
	 * если все нули то нечего сравниваьт
	 * 
	 */
	public int compareMask(int otherNumber, int mask) {
		int k1=0,k2=0;
		boolean masNumber[]= new boolean[32], masOtherNumber[] = new boolean[32];
		if (mask==-1) {
			return number-otherNumber;
			} else  {
				for (int i = 0; i < 31; i++) {
					if(BitwiseOperators.getBitValue(mask, i)==1) {
						if (BitwiseOperators.getBitValue(number, k1)==1) {
							masNumber[k1]=true;
						} else masNumber[k1]=false;
						if (BitwiseOperators.getBitValue(otherNumber, k2)==1) {
							masOtherNumber[k2]=true;
						} else masOtherNumber[k2]=false;
						k1++;
						k2++;
					}
					IntegerBit a1 =new IntegerBit(masNumber);
					IntegerBit a2 =new IntegerBit(masOtherNumber);
					if (mask>0) return a1.number-a2.number;
					if (mask==0) return 0;
					if (mask<0) {
						if ((number<=0)&&(otherNumber<=0)) return a2.number-a1.number;
						if ((number>0)&&(otherNumber<0)) return 1;
						if ((number<=0)&&(otherNumber>0)) return -1;
						
					}
				}
			} 
		return 0;
	}
}
