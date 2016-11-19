package actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import abstraction.Manipulation;

public class Shuffle extends Manipulation {

	public ArrayList<String> Execute(ArrayList<String> list) {
		 Collections.shuffle(list);
		return list;
	}

}
