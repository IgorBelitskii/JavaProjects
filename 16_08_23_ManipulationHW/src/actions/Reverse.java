package actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import abstraction.Manipulation;

public class Reverse extends Manipulation {

	public ArrayList<String> Execute(ArrayList<String> list) {
		 Collections.reverse(list);
		return list;
	}

}
