package tel_ran.application;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import tel_ran.account.dao.AccountMongoDB;
import tel_ran.entities.Account;

public class ApplicationController {

	public static void main(String[] args) {
		//testing Authentication/Authorization
		AbstractApplicationContext ctx = new FileSystemXmlApplicationContext("beansAOP.xml");
		AplicationClass ap1 = (AplicationClass) ctx.getBean("applClass");
		AccountMongoDB accountDB = ctx.getBean(AccountMongoDB.class);
		accountDB.addAccount(new Account("Igor","admin5777","Admin"));
		accountDB.addAccount(new Account("Vasya","user5777","User"));
		accountDB.addAccount(new Account("hz","hz","yyy"));
		//System.out.println(accountDB.getAccount("Administrator"));
		System.out.println("---Admin");
		ap1.login("Igor", "admin5777");
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
		ap1.login("Vasya", "user5777");
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
		System.out.println("---Unlogined");
		ap1.login("unlogined", "123");
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
		ctx.close();
	}
}
