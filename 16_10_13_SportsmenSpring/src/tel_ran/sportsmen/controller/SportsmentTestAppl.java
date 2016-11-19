package tel_ran.sportsmen.controller;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import tel_ran.sportsmen.impl.OlympicTeam;
import tel_ran.sportsmen.interfaces.iSportsmen;

public class SportsmentTestAppl {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		// We are building application context
		AbstractApplicationContext  ctx = new FileSystemXmlApplicationContext("beans.xml");
		iSportsmen sportsman = (iSportsmen) ctx.getBean("sportsman");
		sportsman.action();
	//	sportsman = (iSportsmen) Class.forName(args[0]).newInstance(); // без спринга
		// Можно задавать свойства специфичные для конкрентного класса
		iSportsmen sportsman2 = (iSportsmen) ctx.getBean("runner");
		sportsman2.action();
		
		OlympicTeam team = (OlympicTeam) ctx.getBean("team");
		team.displayActions();
		ctx.close();
		
	}

}
