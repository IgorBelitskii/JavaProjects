package tel_ran.sportsmen.impl;

import tel_ran.sportsmen.interfaces.iSportsmen;

public class Runner implements iSportsmen {
int speed=20;

	public int getSpeed() {
	return speed;
}

public void setSpeed(int speed) {
	this.speed = speed;
}

	@Override
	public void action() {
		System.out.println("I'm running with speed "+speed);

	}

}
