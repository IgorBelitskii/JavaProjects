package tel_ran.ranges;

import java.util.Iterator;

public class Range implements Iterable<Integer>{
	int min,max;
	int array[];
	public Range(int min, int max) {
		array = new int [max-min];
		// TODO Auto-generated constructor stub
		for (int i = 0; i < max-min; i++) {
			array[i]=min+i;
		}
		this.min=min;
		this.max=max;
	}
	@Override
	public Iterator<Integer> iterator() {
	
		return new RangeIterator(this);
	}

}
