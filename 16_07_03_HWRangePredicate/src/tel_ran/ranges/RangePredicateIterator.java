package tel_ran.ranges;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RangePredicateIterator implements Iterator<Integer> {

	RangePredicate rangePredicate;
	private int current;
	public RangePredicateIterator(RangePredicate rangePredicate) {
		this.rangePredicate=rangePredicate;
		current=rangePredicate.min;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		for (int i = current; i <= rangePredicate.max; i++) {
			if (rangePredicate.predicate.matches(i)) return true;
		}
		return false;
	}

	@Override
	public Integer next() {
		for (int i=current; i<=rangePredicate.max;i++) {
		if (rangePredicate.predicate.matches(i)) {
				current=i;
				return current++;
			}
		}
	throw new NoSuchElementException();
	}

}
