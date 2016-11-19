package tel_ran.application;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ApplicationController {

	public static void main(String[] args) {
		//testing Authentication/Authorization
		AbstractApplicationContext ctx = new FileSystemXmlApplicationContext("beansAOP.xml");
		AplicationClass ap1 = (AplicationClass) ctx.getBean("applClass");
		System.out.println("---Unknown");
		ap1.login("hz", "hz");
		try {
			ap1.set1();
		} catch (SecurityException e) {
			System.out.println(e.getMessage());
		}
		try {
			ap1.set2();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			ap1.get1();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		ap1 = (AplicationClass) ctx.getBean("applClass");
		System.out.println("---Admin");
		ap1.login("Admin", "admin5777");
		try {
			ap1.set1();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			ap1.set2();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			ap1.get1();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		ap1 = (AplicationClass) ctx.getBean("applClass");
		System.out.println("---User");
		ap1.login("User", "user5777");
		try {
			ap1.set1();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			ap1.set2();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			ap1.get1();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		ap1 = (AplicationClass) ctx.getBean("applClass");
		ctx.close();
	}
}
