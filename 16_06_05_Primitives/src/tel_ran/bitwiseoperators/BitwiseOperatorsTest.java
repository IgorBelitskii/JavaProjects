package tel_ran.bitwiseoperators;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BitwiseOperatorsTest{

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testGetBit() {
 assertEquals(0, BitwiseOperators.getBitValue(5, 1));
 for (int i = 0; i < 32; i++) {
     assertEquals(0, BitwiseOperators.getBitValue(1, BitwiseOperators.getBitValue(-1, i)));
 }
 assertEquals(-1, BitwiseOperators.getBitValue(10, 32));
    }
    @Test
    public void testSubstract() {
 assertEquals(2, BitwiseOperators.subtract(5, 3));
 assertEquals(-8, BitwiseOperators.subtract(-5, 3));
 assertEquals(8, BitwiseOperators.subtract(5, -3));
 assertEquals(-2, BitwiseOperators.subtract(-5, -3));
    }
    
    @Test
    public void testMultiply() {
 assertEquals(20, BitwiseOperators.multiplyFive(4));
 assertEquals(-20, BitwiseOperators.multiplyFive(-4));
    }
    
    @Test
    public void setBitValue() {
 assertEquals(7, BitwiseOperators.setBitValue(5, 1, 1));
 assertEquals(Integer.MIN_VALUE, BitwiseOperators.setBitValue(0, 31, 1));
 assertEquals(Integer.MAX_VALUE, BitwiseOperators.setBitValue(-1, 31, 0));
    }

}