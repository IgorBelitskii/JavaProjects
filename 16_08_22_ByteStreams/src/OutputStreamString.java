import java.io.*;

public class OutputStreamString {

	public static void main(String[] args) {
		try (FileOutputStream output=new FileOutputStream( "file1.txt",true)){
			String str = "privet \n";
//			str="Zdraste\n";
			byte[] array = str.getBytes();
			output.write(array);
		} catch (Exception e) {
			
		}

}
}
