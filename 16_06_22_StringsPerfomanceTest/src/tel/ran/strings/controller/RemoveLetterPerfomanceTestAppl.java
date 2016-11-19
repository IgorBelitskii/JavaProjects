package tel.ran.strings.controller;

import java.text.SimpleDateFormat;

import tel.ran.strings.model.StringJoinString;
import tel.ran.strings.model.StringsJoinBuilder;
import tel.ran.strings.tests.StringsJoinPerfomance;


public class RemoveLetterPerfomanceTestAppl {

	public static void main(String[] args) {
		
		StringsJoinPerfomance s1 = new StringsJoinPerfomance(10000, 10), 
				s2= new StringsJoinPerfomance(10000, 10);
		s1.SetStringsJoin(new StringJoinString(null, null));
		s2.SetStringsJoin(new StringsJoinBuilder(null, null));
		SimpleDateFormat format = new SimpleDateFormat("mm:ss:SSS");//dd/MM/yyyy
	
	 
		System.out.println("Methond 'Strings concat' works "+format.format(s1.run())+ "ms");
		System.out.println("Methond 'Strings builder' works "+format.format(s2.run())+ "ms");
			
	}

}
