import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileProcessingTestAppl {

	public static void main(String[] args) throws IOException {
	
		// ОТносительность в Eclipse - относительно корневой директории
		// А в JAR это будет относительно другой папки
		// Абсолютный путь сохраняется 
		File file=new File(args[0]);
//		if (args.length>0) {
//			
////			file.mkdirs();
//			if (!file.exists()) file.createNewFile();
//			System.out.println(file.exists());
//		}

		displayFileContentRecursive(file, 0);
		
	}
/**
 *  displaying content of directory related with the parameter file
 *  in the form <name> dir||file
 * @param file
 */
	@SuppressWarnings("rawtypes")
	private static void displayFileContent(File file) {

	        File[] nodes = file.listFiles();
	        for (File node : nodes) {
	        	System.out.println(node.getName()+" "+(node.isDirectory()?"dir":"file"));     
	        }

		
	}
	@SuppressWarnings("rawtypes")
	private static void displayFileContentRecursive(File file, int level) {
	        File[] nodes = file.listFiles();
	        for (File node : nodes) {
	        	printspaces(level);
	        	if (node.isDirectory()) {
	        		System.err.println(node.getName()+":");
	        		displayFileContentRecursive(node, level+1);
	        	} else System.out.println(node.getName());
	        }

		
	}
	private static void printspaces(int level) {
		for (int i = 0; i < level*2; i++) {
			System.out.print(" ");
		}
		
	}

}
