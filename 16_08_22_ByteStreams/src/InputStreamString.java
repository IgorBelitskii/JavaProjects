import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InputStreamString {

	public static void main(String[] args)  {
//		try (FileInputStream input=new FileInputStream( "file1.txt")){
//			byte[] array = new byte[input.available()];
//			input.read(array);
//			String str = new String(array);
//			System.out.println(str);
			
			//написать аппликацию которая печатает сама себя
			
			try(FileInputStream fis = new FileInputStream("src/InputStreamString.java")) {
				   int len;
				   byte[] b = new byte[128];
				   while((len = fis.read(b)) > 0)
				    System.out.print(new String(b, 0, len));
				  } catch (IOException e) {
				   
				  }
			
		}
	

}
