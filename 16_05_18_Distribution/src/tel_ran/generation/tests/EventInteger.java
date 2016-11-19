package tel_ran.generation.tests;

import tel_ran.generation.events.Event;

public class EventInteger extends Event {
int value;

public EventInteger(int probability, int value) {
	super(probability); //Event (probability)
	this.value = value;
}

@Override
public String toString() {
	return "EventInteger [value=" + value + "]";
}

public int getValue() {
	return value;
}

}
