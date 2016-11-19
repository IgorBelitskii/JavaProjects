
public class ExceptionThrowAppl {

	public static void main(String[] args) {

			Range range=new Range(10,20);
		try {
				range.checkNumber(21);
				System.out.println("OK");
			} catch (Throwable e) {
				System.out.println(e.getMessage());
			}

	}

}
