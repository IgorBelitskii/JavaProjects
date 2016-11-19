package tel_ran.ranges;

public class PredicatePrimes implements PredicateRange {

	@Override
	public boolean matches(int number) {
		if (number==1) return false;
		for (int i = 2; i < number; i++) {
			if (number%i==0) return false;
		}
		return true;
	}

}
