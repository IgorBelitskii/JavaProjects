package tel_ran.view;
import java.io.*;
public class ViewConsole implements View {

	@Override
	public String getStringValue(String message) {
		String line=null;
		BufferedReader console=
		new BufferedReader(new InputStreamReader(System.in));
		display(message);
		try {
			line=console.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return line;
	}

	@Override
	public int getIntValue(String message, int min, int max) throws Exception {
		String line=null;
		int res=0;
		BufferedReader console=
				new BufferedReader(new InputStreamReader(System.in));
		while(true){
			System.out.println(message+" ("+min+"-"+max+" )");
			line=console.readLine();
			try {
				res=Integer.parseInt(line);
			} catch (Exception e) {
				System.out.println(" no number was entered");
				continue;
			}
			if(res >= min && res <= max)
				return res;
			System.out.println("wrong number (out of the range)");
		}
		
	}

	@Override
	public void display(String message) {
		System.out.println(message);

	}

}
