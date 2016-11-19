import java.io.IOException;
import java.net.*;
public class JavaIPTestAppl {
	
	public static void main(String[] args) throws IOException {
		
		InetAddress [] adresses = InetAddress.getAllByName("google.co.il");
		System.out.println(adresses.length);
		for (InetAddress adress:adresses) {
			System.out.println(adress.getHostAddress());
			System.out.println(adress.isReachable(25));
		}
	}

}
