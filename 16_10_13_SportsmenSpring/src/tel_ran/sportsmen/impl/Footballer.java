package tel_ran.sportsmen.impl;

import tel_ran.sportsmen.interfaces.iSportsmen;

public class Footballer implements iSportsmen {
String team="Spartak";

	public Footballer(String team) {
	super();
	this.team = team;
}

	@Override
	public void action() {
		System.out.println("I'm playing football in "+team);
	}

}
