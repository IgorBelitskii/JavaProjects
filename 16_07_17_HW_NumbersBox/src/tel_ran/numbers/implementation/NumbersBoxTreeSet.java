package tel_ran.numbers.implementation;

import java.util.Iterator;
import java.util.TreeSet;

import tel_ran.numbers.interfaces.INumbersBox;

public class NumbersBoxTreeSet extends NumbersBoxCollection {

	public NumbersBoxTreeSet() {
		numbers = new TreeSet<Integer>();
	}
	public INumbersBox getNumbersInRange(int min, int max) {
		INumbersBox result = new NumbersBoxTreeSet();
		result.changeNumbers(((TreeSet<Integer>)this.numbers).subSet(min, true, max, true));
		return result;
	}
	public void removeRepeated() {
	}

}
