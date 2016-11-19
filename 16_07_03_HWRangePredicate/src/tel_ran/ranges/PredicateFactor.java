package tel_ran.ranges;
import tel_ran.ranges.tests.*;

import java.util.function.Predicate;

public class PredicateFactor implements PredicateRange{
	int factor;
	public PredicateFactor(int factor) {
		this.factor=factor;
	}
	@Override
	public boolean matches(int number) {
		if (number%factor==0) return true;
		return false;
	}



}
