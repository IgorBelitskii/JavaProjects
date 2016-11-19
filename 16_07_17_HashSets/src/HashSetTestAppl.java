import java.util.*;
public class HashSetTestAppl {

	public static void main(String[] args) {
	// HashSet - не сохраняет порядоек
		// Linked Has Set - сохраняет порядок, для этого есть отдельнй LinkedList для итерирования
		
		//HashSet<Integer> set = new HashSet<>();
		Collection<Integer> set = new LinkedHashSet<>();
		Random gen= new Random();
		/*set.add(0);
		set.add(16);
		set.add(32);
		set.add(64);*/
		/*for (int i=0; i<12; i++) 
			set.add(gen.nextInt());
		
		set.add(gen.nextInt());*/
		
		Integer array[]={40,20,30,60,10};
		for (Integer number:array) 
			set.add(number);
		for(Integer number:set)
			System.out.println(number);
	}

}
