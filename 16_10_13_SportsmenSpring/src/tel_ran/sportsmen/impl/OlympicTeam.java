package tel_ran.sportsmen.impl;

import tel_ran.sportsmen.interfaces.iSportsmen;

public class OlympicTeam {
private iSportsmen[] team;

public OlympicTeam(iSportsmen[] team) {
	super();
	this.team = team;
}
public void displayActions(){
	for (iSportsmen sportsman: team) {
		sportsman.action();
	}
}

}
