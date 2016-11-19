package actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import abstraction.Manipulation;

public class Sort extends Manipulation {

	public ArrayList<String> Execute(ArrayList<String> list) {
	//	 list.sort((String a, String b) -> a.compareTo(b)>0 ? 1: -1);
		 Collections.sort(list);
		return list;
	}

}
