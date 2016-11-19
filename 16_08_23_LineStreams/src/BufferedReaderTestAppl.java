import java.io.*;

public class BufferedReaderTestAppl {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new FileReader("file2.txt"));
		while (true) {
			String line=reader.readLine();
			if (line==null) break;
			System.out.println(line);
		}
		reader.close();
	}

}
