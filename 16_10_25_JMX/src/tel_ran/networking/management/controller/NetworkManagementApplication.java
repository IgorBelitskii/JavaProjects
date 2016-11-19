package tel_ran.networking.management.controller;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class NetworkManagementApplication {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx =
				new FileSystemXmlApplicationContext("mbeansNoReg.xml");
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
