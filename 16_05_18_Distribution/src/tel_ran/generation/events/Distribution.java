package tel_ran.generation.events;

import tel_ran.collections.Array;

public class Distribution {
Array events=new Array();

static public int getRandomNumber (int min, int max) //чтобы можно было добираться до класса без построения объекта
{
	if (max<min) {
		int tmp=min;
		min=max;
		max=tmp;
	}
	int rand = min + (int)(Math.random() * ((max - min) + 1));

	return rand;
}
public void addEvent (Event event) {
	events.add(event);
}
public Event getEvent() {
	fixDistribution(); 
	// after fixDistribution(); sum of all event probabilities is 100%
	
	int nEvents=events.size()-1;
	int prob=getRandomNumber (0,100);
	for (int i=0, border=((Event)events.get(0)).getProbability(); i<nEvents;
			 border+=((Event)events.get(++i)).getProbability()) {
		if (prob<border)
			return (Event) events.get(i);
	}
		
	return (Event) events.get(nEvents);
}
/** Есть 2 события суммарная 150%
 * мы должны привести суммарную вероятность к 100%
 * пропорционально
 * 150-100 = 50
 * делим на 2
 * по 25 - вычитаем с каждого по 25%
 * 
 * Если меньше 100 - пропорционально увеличить
 * 
 * 
 */
private void fixDistribution() {

	int sum=0;
	for (int i=0; i<events.size(); i++) {
		sum=sum+((Event)events.get(i)).getProbability();
	}
	int fix,newsum=0;
	if (sum>100) {
		fix=(sum-100)/events.size();
		for (int i=0; i<events.size(); i++) {
			((Event)events.get(i)).setProbability(((Event)events.get(i)).getProbability()-fix);
		}
	}
	if (sum<100) {
		fix=(100-sum)/events.size();
		for (int i=0; i<events.size(); i++) {
			((Event)events.get(i)).setProbability(fix+((Event)events.get(i)).getProbability());
		}
	}
	sum=0;
	for (int i=0; i<events.size(); i++) {
		sum=sum+((Event)events.get(i)).getProbability();
	}
	if (sum<100) ((Event)events.get(events.size()-1)).setProbability(1+((Event)events.get(events.size()-1)).getProbability());
	for (int i=0; i<events.size(); i++) {
		newsum=newsum+((Event)events.get(i)).getProbability();
	}
	if (sum>100) ((Event)events.get(events.size()-1)).setProbability(100-newsum);
}
}

