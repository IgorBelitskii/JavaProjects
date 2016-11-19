
public class ExceptionsHandlingAppl {

	public static void main(String[] args) {
		String str="-123";		
	//	isNumber(str);
	//	System.out.println(isNumber(str));
		int nLongs=Integer.MAX_VALUE;
	//	System.out.println(nLongs);
		boolean running=true;
		
			while (running) {
				try {
				long[] arrayLongs = new long[nLongs];
				running=false;
				}
				catch (Throwable e) {
					nLongs=(nLongs/100)*99;
				}
		}
	//	System.out.println(nLongs);
		
		
	}

	private static boolean isNumber(String str) {
		
		try {
			double number=Double.parseDouble(str);
			} catch (NumberFormatException e) {
		//	System.out.println(str+" is not number");
			return false;
		}
	
		return true;
	}
	

}
