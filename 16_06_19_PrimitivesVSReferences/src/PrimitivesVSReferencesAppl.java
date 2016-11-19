
public class PrimitivesVSReferencesAppl {
	static Integer n1=1000; 
public static void main (String[] args) {
	

	
	Integer n2=1000;
	System.out.println(n1==n2);
	System.out.println((int)Integer.valueOf(n1)==(int)Integer.valueOf(n2));
	System.out.println(n1.equals(n2));
	
	Integer n3=120;
	Integer n4=110;
	n4=n4+10;
	System.out.println(n3==n4);
	n4=n4+10;
	n3=n3+10;
	System.out.println(n3==n4);
	increment(n1);
	System.out.println(n1);
}
private static void increment(Integer n2) {
	n1++;
	n2++;
	System.out.println(n1.equals(n2));
}
	
}
