package tel_ran.ranges;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RangeIterator implements Iterator<Integer> {
private Range range;
private int current;
	public RangeIterator(Range range) {
		this.range=range;
		current=range.min;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return current<=range.max;
	}

	@Override
	public Integer next() {
		if (!hasNext()) throw new NoSuchElementException();
		return current++;
	}

}
