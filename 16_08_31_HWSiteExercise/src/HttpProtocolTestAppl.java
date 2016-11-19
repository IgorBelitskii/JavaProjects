import java.net.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.*;
public class HttpProtocolTestAppl {

	public static void main(String[] args) throws IOException {
		String nameSite = args[0];
		String config = args[1];
		ArrayList<String> domains = readConfigFile(config);
		for (Iterator iterator = domains.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			String urltext="http://"+nameSite+"."+string;
			System.err.println("Testing "+urltext+" ...");

				try {
					URL url = new URL(urltext);
					url.openConnection();
					InputStream stream = url.openStream();
					System.out.println(urltext);
				} catch (Exception e) {
					System.err.println(urltext+" error!!!");
				}
	
		}
		
	}

	private static ArrayList<String> readConfigFile(String config) throws IOException {
		ArrayList<String> inputList=new ArrayList<>();
		BufferedReader reader = new BufferedReader(new FileReader(config));
		while (true) {
			String line=reader.readLine();
			if (line==null) break;
			inputList.add(line);
	//		System.out.println(line);
		}
		reader.close();
		return inputList;
		
	}

}
