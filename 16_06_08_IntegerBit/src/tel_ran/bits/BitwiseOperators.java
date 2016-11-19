package tel_ran.bits;
public class BitwiseOperators {
	
	public void main() {
		System.out.println(multiplyFive(2));
	}
    /**
     * 
     * @param number
     * @param nBit
     * @return value of bit with number nBit for the given number if nBit < 0 or nBit > 31 -> -1
     * example: number = 5, nBit = 1 -> 0
     */
    public static int getBitValue(int number, int nBit) {
 if (nBit < 0 || nBit > 31) {
 return -1; 
 }
 number>>=nBit;
 return Math.abs(number % 2);
    }
    
    /**
     * 
     * @param number
     * @param nBits
     * @param bitValue
     */
  
   

    public static int setBitValue(int number, int nBit, int bitValue) {
    	 if (!checkBitNumber(nBit)||!checkBitValue(bitValue)) {
    	     return number;
    	 }
    	 long mask = 1L << nBit;
    	 if (getBitValue(number, nBit) == bitValue) {
    	     return number;
    	 }
    	 return (int) (number ^ mask); // ^ - XOR
    	    }

    	    private static boolean checkBitValue(int bitValue) {
    	 
    	 return (bitValue == 0) || (bitValue == 1);
    	    }

    	    private static boolean checkBitNumber(int nBit) {

    	 return nBit >= 0 && nBit <= 31;
    	    }

/**
 * Реализовать оператор минус без использования оператора минус
 * ни бинарный ни унарный
 * 
 * Умножить на 5 без умножения и без циклов
 */
/**
 * 
 * @param op1
 * @param op2
 * @return  op1-op2 with no usage of operator minus
 */
public static int subtract(int op1, int op2) {
	
	return op1+(~op2)+1;
}
/**
 * 
 * @param number
 * @return number*5 with no multiply and only one plus
 */
static public int multiplyFive (int number) {
	
	return (number<<2)+number;
}

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
 * 
 */
}