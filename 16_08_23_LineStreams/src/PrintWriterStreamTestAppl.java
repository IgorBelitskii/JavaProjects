import java.io.*;
import java.util.Date;

public class PrintWriterStreamTestAppl {

	public static void main(String[] args) throws FileNotFoundException {
		
//		try (PrintStream printStream = new PrintStream(new FileOutputStream("file2.txt",true));
//				PrintWriter printWriter = new PrintWriter("file3.txt");) {
//				printStream.println("Hello world");
//				printWriter.println("Hello world");
//		}
//		
		
		try (PrintStream stream = new PrintStream("file2.txt");
				PrintWriter writer = new PrintWriter("file3.txt");) {
			perfomanceTest(stream);
			perfomanceTest(writer);
	}

		Object object = new Object();
		
		// PrintWriter пишет сначала в Buffer и 
		// 1) перенос в файл при вызове метода Flush
		// 2) при закрытии файла пишет в файл
		
		// PrintStream - пишет сразу в файл
	}

	private static void perfomanceTest(PrintWriter writer) {
		long start = System.currentTimeMillis();	
		for (int i = 0; i < 1000000; i++) {
			writer.println("Hello world");
		}
		long finish = System.currentTimeMillis();
		long timeConsumedMillis = finish - start;
		System.out.println("WriteStream time = "+timeConsumedMillis);

		
		
	}

	private static void perfomanceTest(PrintStream stream) {
	long start = System.currentTimeMillis();	
	for (int i = 0; i < 1000000; i++) {
		stream.println("Hello world");
	}
	long finish = System.currentTimeMillis();
	long timeConsumedMillis = finish - start;
	System.out.println("TestStream time = "+timeConsumedMillis);

	} 
	
	private static void perfomanceTest1(Object stream,boolean app) {
		long start = System.currentTimeMillis();	
		for (int i = 0; i < 1000000; i++) {
			//stream.println("Hello world");
		}
		long finish = System.currentTimeMillis();
		long timeConsumedMillis = finish - start;
		System.out.println("TestStream time = "+timeConsumedMillis);

		} 

}
