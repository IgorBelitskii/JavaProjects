import java.net.*;
import java.io.*;
public class HttpProtocolTestAppl {

	public static void main(String[] args) throws IOException {
		
		URL url = new URL("http://google.co.il");
	//	URL url = new URL("http://localhost");
		url.openConnection();
		InputStream stream = url.openStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		while (reader.ready()) {
				System.out.println(reader.readLine());
		}
		
	}

}
