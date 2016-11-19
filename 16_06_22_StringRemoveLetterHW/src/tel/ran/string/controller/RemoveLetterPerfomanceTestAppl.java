package tel.ran.string.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import tel.ran.string.perfomance.RemovePerfomance;
import tel.ran.string.remove.RemoveLetter;
import tel.ran.string.remove.RemoveLetterI;
import tel.ran.string.remove.RemoveLetterII;
import tel.ran.string.remove.RemoveLetterIII;

public class RemoveLetterPerfomanceTestAppl {

	public static void main(String[] args) {
		
		RemovePerfomance r = new RemovePerfomance(200, 100000);
		runTest(r,new RemoveLetterI(null,"+".charAt(0)),"RemoveLetter I");
		runTest(r,new RemoveLetterII(null,"+".charAt(0)),"RemoveLetter II"); 
		runTest(r,new RemoveLetterIII(null,"+".charAt(0)),"RemoveLetter III"); 
	
	}
	public static void runTest(RemovePerfomance r, RemoveLetter rl, String print) {
		r.SetRemoveLetter(rl); 
		System.out.println(print+": "+r.run()+ " ms.");
	}
}
