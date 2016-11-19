package tel_ran.ranges;

import java.util.Iterator;

public class RangePredicate implements Iterable<Integer> {
	int min, max;
	public PredicateRange predicate;
	public RangePredicate(int min, int max) { //����������� ��� �����
		//TODO
		this.min=min;
		this.max=max;
		this.predicate= new PredicateAll();
	}

	public RangePredicate(int min, int max, PredicateRange predicate) { //� ��������� ������� �� �������
		// TODO Auto-generated constructor stub
		this.min=min;
		this.max=max;
		this.predicate=predicate;
	}

	@Override
	public Iterator<Integer> iterator() {
		return new RangePredicateIterator(this);
	}

}
