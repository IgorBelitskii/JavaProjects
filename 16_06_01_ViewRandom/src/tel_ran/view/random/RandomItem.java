package tel_ran.view.random;

import tel_ran.generation.events.Event;
import tel_ran.view.Item;

public abstract class RandomItem extends Event implements Item {

	public RandomItem(int probability) {
		super(probability);
		
	}

	protected static DataProviderRandomConsole dataProvider = new DataProviderRandomConsole();
// к полю можно будет обращаться из детей этого класса
}
