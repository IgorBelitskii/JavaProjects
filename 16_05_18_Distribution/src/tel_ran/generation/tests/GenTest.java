package tel_ran.generation.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import tel_ran.collections.Array;
import tel_ran.generation.events.Distribution;
import tel_ran.generation.events.Event;

public class GenTest {

	Distribution distribution;
	private static final int N_NUMBERS=100;
	private static final int MIN=10;
	private static final int MAX=20;
	
	@Before
	public void setUp() throws Exception {
		distribution=new Distribution();
		distribution.addEvent(new EventInteger(10,0));
		distribution.addEvent(new EventInteger(90,1));
	}

	@Test
	public void testGetEvent() {
		int numbers[]={0,0};
		int N_TRIALS=1000;
		for(int i=0; i<N_TRIALS; i++) {
			Event event = distribution.getEvent();
			numbers[((EventInteger)event).getValue()]++;
		}
	//	System.out.println("0 -> "+numbers[0]);
	//	System.out.println("1 -> "+numbers[1]);
	}
	
	@Test
	public void testRandom() {
		
		for (int i=0; i<N_NUMBERS; i++) {
			int a=Distribution.getRandomNumber(MIN, MAX);
		//	System.out.print(a +" ");
			assertEquals(a>=MIN, true);
			assertEquals(a<=MAX, true);
			
		}
	}
	
	@Test
	public void ArrayFixTest (){
		distribution=new Distribution();
		distribution.addEvent(new EventInteger(5,0));
		distribution.addEvent(new EventInteger(5,1));
		distribution.addEvent(new EventInteger(5,2));
		
		int n1=0, n2=0, n3=0, p1=0, p2=0,p3=0;
		
		do {
			Event event = distribution.getEvent();
			if ((n1==0) && (((EventInteger)event).getValue()==0)) { 
				p1=event.getProbability();
				n1++;
			}
			if ((n2==0) && (((EventInteger)event).getValue()==1)) { 
				p2=event.getProbability();
				n2++;
			}
			if ((n3==0) && (((EventInteger)event).getValue()==2)) { 
				p3=event.getProbability();
				n3++;
			}
			}
		while ((n1==0)||(n2==0)||(n3==0)); 
		
		System.out.println(" Array fix Test - Fixed probability: ");
		System.out.println(" 0 -> "+p1);
		System.out.println(" 1 -> "+p2);
		System.out.println(" 2 -> "+p3);
	//	System.out.println(distribution.getEvent()+" "+distribution.getEvent().getProbability());
		//System.out.println(distribution.getEvent()+" "+distribution.getEvent().getProbability());
	}
	
	@Test
	public void ArrayKohavitTest (){
		distribution=new Distribution();
		distribution.addEvent(new EventInteger(5,0));
		distribution.addEvent(new EventInteger(10,1));
		distribution.addEvent(new EventInteger(25,2));
		distribution.addEvent(new EventInteger(30,3));
		distribution.addEvent(new EventInteger(25,4));
		distribution.addEvent(new EventInteger(10,5));
		distribution.addEvent(new EventInteger(5,6));
		//System.out.println(distribution.getEvent().getProbability());
		
		Array n = new Array();
		Array p = new Array();
		for (int i=0; i<7; i++) {
			n.add(i, 0);
		}
		int sumn;
		
		do {
				sumn=0;
				for (int i=0; i<7; i++) {
							Event event = distribution.getEvent();
							if (((int)n.get(i)==0) && ((int)((EventInteger)event).getValue()==i)) { 
								p.add(i, (int)event.getProbability());
								n.add(i, 1);
								}
						sumn=sumn+(int)n.get(i);
				}
			}
		while (sumn<7); 
		int numbers[]={0,0,0,0,0,0,0};
		int N_TRIALS=1000;
		for(int i=0; i<N_TRIALS; i++) {
			Event event = distribution.getEvent();
			numbers[((EventInteger)event).getValue()]++;
		}
		int z=0;
		System.out.println(" Array Kohavit Test + fixed");
		for (int i=0; i<7; i++) {
			System.out.print(i+" -"+ (int)p.get(i)+" > ");
			z=80*numbers[i]/1000;
			for (int j=0; j<z; j++) {
				System.out.print("*");
			}
			System.out.println("");
		
			}
	//	System.out.println(distribution.getEvent()+" "+distribution.getEvent().getProbability());
		//System.out.println(distribution.getEvent()+" "+distribution.getEvent().getProbability());
	}
	/**
	 * Делаем массив событий - чисел
	 * В нашем тесте
	 * 
	 * фикс. дистрибутив приводящий все к 100%
	 * 
	 * 
	 */
	
	/**
	 * Строится массив счетчиков
	 * 
	 *  Чтобы тест выдавал диаграмму распределения
	 *  (гаусовское распределение)
	 *  
	 *  
	 * 
	 * 
	 */
}
