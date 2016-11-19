package tel_ran.orm.controller;


import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import tel_ran.orm.dao.EntitiesOrm;
import java.io.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
public class OrmConsoleAppl {
static Logger loggerHibernate=Logger.getLogger("org.hibernate");

	public static void main(String[] args)  {
		loggerHibernate.setLevel(Level.SEVERE);
		AbstractApplicationContext ctx=
				new FileSystemXmlApplicationContext("beans.xml");
		EntitiesOrm objects=(EntitiesOrm) ctx.getBean("objects");
		BufferedReader console=new BufferedReader
		(new InputStreamReader(System.in));
		while(true){
			try {
				System.out.println("Please enter a JPQL select request:");
				String line=console.readLine();
				if(line.equalsIgnoreCase("exit"))
					break;
				List<String> res=objects.getResultAnyJpql(line);
				for(String str:res)
					System.out.println(str);
			} catch (Throwable e) {
				System.out.println(e.getMessage());
			}
			
				
		}
		System.out.println("Bye");
		ctx.close();
	}

}
