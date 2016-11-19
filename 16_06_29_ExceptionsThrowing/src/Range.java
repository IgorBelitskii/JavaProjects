
public class Range {

	private int min;
	private int max;
	
	public Range(int min, int max) {
		this.min = min;
		this.max = max;
	}
	public int getMin() {
		return min;
	}
	public int getMax() {
		return max;
	}
	
	void checkNumber(int number)  {
		if (number< min || number > max) 
			throw new Error("number "+number+" is out of range");
	}
	
}
