public class X {
	@Id("integer value")
	@Index
	private int xi;

	@Index(unique="2", value="rrr")
	@Id("string")
	private String xs;
	
	@Override
	public String toString() {
		return "X [xi=" + xi + ", xs=" + xs + "]";
	}
	public X(int xi, String xs) {
		super();
		this.xi = xi;
		this.xs = xs;
	}
	public X() {
		super();

	}
	public int getXi() {
		return xi;
	}
	public String getXs() {
		return xs;
	} 
	
	
}
