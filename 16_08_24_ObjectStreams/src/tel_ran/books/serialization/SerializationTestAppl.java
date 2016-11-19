package tel_ran.books.serialization;
import java.io.*;

public class SerializationTestAppl {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		X x = new X();
		X x1 = new X();
		x1.a=20;
		x.a=10;
		x.x=x1;
		x1.x=x;
		ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("file"));
		output.writeObject(x);
		output.close();

	}

}
