import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.aop.aspectj.annotation.PrototypeAspectInstanceFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import abstraction.Manipulation;

public class ManipulateAppl {

	public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		final String PACKAGE_NAME="actions";
		if (args.length!=2) {
			System.out.println("Wrong input format - Format must be: manipulateappl.exe inputfile.txt outputfile.txt");
		} else {
			String inputFile= args[0];
			String outputFile= args[1];
			
			System.out.println("Input file:\""+inputFile+"\"");
			System.out.println("Output file:\""+outputFile+"\"");
			ArrayList<String> inputList=new ArrayList<>();
			ArrayList<String> outputList=new ArrayList<>();
			Readfile(inputFile, inputList);
			AbstractApplicationContext  ctx = new FileSystemXmlApplicationContext("beans.xml");
			Map<String, String> actions = (Map) ctx.getBean("actions");
			System.out.println(actions);
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("Please enter name of action");
			String line = console.readLine();
			if(line==null||line.length()==0||"exit".equals(line))
				break; 
			Manipulation action = null;
			String result;
			try {
				result= actions.get(line);
				if (result==null)
					System.out.println("There is no such a method");
				else {
				action = (Manipulation) Class.forName(result).newInstance();
				}
			} catch (ClassNotFoundException e) {
				System.out.println("There is no such a method - please check beans.txt");
				continue;
			} 
			if (result!=null) 
				{ outputList=action.Execute(inputList);
				Writefile(outputFile,outputList);
				}
			System.out.println("Bye");
			break;
		}
		}
	}

	private static void Writefile(String outputFile,ArrayList<String> outputList) throws FileNotFoundException {
		PrintStream stream = new PrintStream(outputFile);
		int len = outputList.size();
		int count=0;
		try {
			for (String line: outputList) {
				if (count<len-1) { 
					stream.println(line);

				} else  {
					stream.print(line);
					break;
				}
				count++;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		stream.close();
	}

	private static void Readfile(String inputFile, ArrayList<String> inputList) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		while (true) {
			String line=reader.readLine();
			if (line==null) break;
			inputList.add(line);
	//		System.out.println(line);
		}
		reader.close();
		
	}

}
