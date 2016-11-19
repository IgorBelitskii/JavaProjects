
public class Strings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		
//		String str1="Hello";
//		String str2="Hello";
//		
//		System.out.println(str1==str2);
//		str1.concat("");
//		System.out.println(str1==str2);
//	
//		str1.replace('l', '*');
//		str2=str2.replace('l', '*');
//		System.out.println(str2);
//		System.out.println(str1);
//		System.out.println(str1==str2);
//		str1=str1+"";
//		System.out.println(str1==str2);
//		replace(str2);
//		System.out.println(str2);
		
		String re="[0-9]?.*";
		String str1="asd";
		System.out.println(str1.matches(re));
		re="\\/*";
		String str2="abc! lm, n? tr";
		String tokens[]=str2.split("[^a-zA-Z]+");
		for (int i = 0; i < tokens.length; i++) {
			System.out.println(tokens[i]);
		}
		
		
	}
	private static void replace(String str) {
		str.replace('*','l');
	}

}
/**
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * */
