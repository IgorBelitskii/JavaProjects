package tel_ran.numbers.implementation;

import java.util.LinkedList;

import tel_ran.numbers.interfaces.INumbersBox;

public class NumbersBoxLinkedList extends NumbersBoxCollection {

	public NumbersBoxLinkedList (){
		numbers = new LinkedList<Integer>();
	}

}
