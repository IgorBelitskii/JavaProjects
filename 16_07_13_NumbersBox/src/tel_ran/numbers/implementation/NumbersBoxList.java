package tel_ran.numbers.implementation;

import java.util.*;
import java.util.function.Predicate;

import tel_ran.numbers.interfaces.INumbersBox;

public abstract class NumbersBoxList implements INumbersBox {
protected List<Integer> numbers;

	@Override
	public Iterator<Integer> iterator() {

		return numbers.iterator();
	}

	@Override
	public void addNumber(int number) {
		numbers.add(number);

	}

	@Override
	public void removeNumber(int number) {
		numbers.remove((Integer)number);
		//функция принимает объект и удаляет по объекту
		//Если не делать кастинг по интеджеру то он будет пытаться удалить объект по номеру

	}

	@Override
	public INumbersBox findNumbers(Predicate<Integer> predicate) {
		Iterator<Integer> it=numbers.iterator();
		/*INumbersBox result = new NumbersBoxArrayList();*/
		INumbersBox result = null;
		Class<? extends INumbersBox> c = this.getClass();
		try {
			result=c.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			while(it.hasNext()) {
			int num = it.next();
			if (predicate.test(num))
				result.addNumber(num);
		}
		return result;
	}

	@Override
	public void removeAllNumbers(int number) {
	
		Iterator<Integer> it=numbers.iterator();	
		while(it.hasNext()) {
			int num = it.next();
			if (num==number)
				it.remove();
		}
		/* Так удалять неправильно
		 * **	for(int num: numbers) {
			if (num==number) numbers.remove(num);
		}**/

	}

	@Override
	public void removeAllNumbers(Predicate<Integer> predicate) {
		Iterator<Integer> it=numbers.iterator();
			while(it.hasNext()) {
			int num = it.next();
			if (predicate.test(num))
				it.remove();
		}

	}
	
	/**
	 * this numbers box will add all numbers from the given numbers box except those
	 * already existed in this box
	 * **/
	@Override
	public void union(INumbersBox numbers) {

		boolean flag;
		for (Integer i : numbers) {
			flag=false;
			for (Integer j : this.numbers) {
				if (i.equals(j)) flag = true;
			}
			if (flag==false) addNumber(i);
		}

	}
	
	
	/**
	 * this numbers box will contain only those numbers that exist in the given one
	 * example: this {2,5,7}; the given {5,3,10,20}  after the method call this will contain just {5}
	 * @param numbers

	 */
	@Override
	public void intersection(INumbersBox numbers) {

		boolean flag;
		Iterator<Integer> it=this.numbers.iterator();
		while(it.hasNext()) {
			flag=false;
			int i = it.next();
			for (Integer j : numbers) {
				if (i==j) flag = true;
			}
			if (flag==false) it.remove();
		}

	}
	
	/**
	 * assumed that this numbers box don't have the repeated numbers
	/*
	 *  * this numbers box will contain all unrepeated numbers except those existing in the given numbers
	 *  {2,2,5,5,7,7} substract {5,7} = {2}
	 * @param numbers
	 */
	@Override
	public void subtract(INumbersBox numbers) {
		removeRepeated();
		boolean flag;
		Iterator<Integer> it=this.numbers.iterator();
		while(it.hasNext()) {
			flag=false;
			int i = it.next();
			for (Integer j : numbers) {
				if (i==j) flag = true;
			}
			if (flag==true) it.remove();
		}

		
	}

	@Override
	public void removeRepeated() {
		int repeated;
		Iterator<Integer> it=this.numbers.iterator();
		
		while(it.hasNext()) {
			repeated=0;
			int i = it.next();
			for (Integer j : numbers) {
				if (i==j) repeated++;
			}
			if (repeated>1) it.remove();
		}

	}

}
