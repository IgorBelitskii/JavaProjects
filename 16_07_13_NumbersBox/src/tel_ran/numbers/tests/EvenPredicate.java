package tel_ran.numbers.tests;

import java.util.function.Predicate;

public class EvenPredicate implements Predicate<Integer> {

	@Override
	public boolean test(Integer t) {
		if (t%2!=0) return true;
		return false;
	}

}
