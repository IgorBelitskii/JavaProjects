package tel_ran.view.random;

import tel_ran.generation.events.Distribution;
import tel_ran.view.Menu;

public class RandomMenu implements Menu {
Distribution items;
int nRuns;

	public RandomMenu(Distribution items, int nRuns) {
	super();
	this.items = items;
	this.nRuns = nRuns;
}

	@Override
	public void runMenu() {
		
		for (int i = 0; i < nRuns; i++) {
			RandomItem item=(RandomItem)items.getEvent();
			String displayedName=item.getDisplayedName();
			RandomItem.dataProvider.showMessage(displayedName);
			item.action();
		}
			
	}

}
