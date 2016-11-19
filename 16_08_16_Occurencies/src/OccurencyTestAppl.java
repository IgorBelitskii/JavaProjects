import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class OccurencyTestAppl {

	public static void main(String[] args) {
		
		displayOccurrencies(args);

	}
	private static void displayOccurrencies(String [] args) {
		HashMap<String, Integer> occurencies = getMap(args);
	
		LinkedList<Map.Entry<String,Integer>> listOccurencies = new LinkedList<>(occurencies.entrySet());
		// лямбда- выражение заменяет компараор
		listOccurencies.sort((a,b)-> {int r=b.getValue()-a.getValue(); 
		return r==0 ? a.getKey().compareTo(b.getKey()): r;});
				
		for (Map.Entry<String,Integer> pair :listOccurencies) {;
			System.out.println(pair.getKey() +" -> " +pair.getValue());
		}
	}
	private static HashMap<String, Integer> getMap(String[] args) {
		HashMap<String, Integer> occurencies=new HashMap<>();
			for (String str:args) {
				Integer count = occurencies.put(str, 1);
				if (count!=null) 
					occurencies.put(str,count+1);
			}
		return occurencies;
	}
}
