import java.util.*;

public class MapsTestAppl {

	public static void main(String[] args) {
		TreeMap<Integer,String> months = new TreeMap<>();
		months.put(1,"Jan");
		months.put(12, "Dec");
		months.put(8, "Aug");
		months.put(4, "Apr");
		months.put(10, "Oct");
		months.put(2, "Feb");
	/*	months.put(3, "Mar");
		months.put(5, "May");
		months.put(6, "Jun");
		months.put(7, "July");
		months.put(9, "Sep");
		months.put(11, "Nov");
		*/
		System.out.println(months.put(1, "January"));
		System.out.println(months.get(1));
		System.out.println(months.putIfAbsent(1, "JAN"));
		System.out.println(months.get(1));
		System.out.println("keys");
		displayIterable(months.keySet());
		System.out.println("values");
		displayIterable(months.values());
		System.out.println("keys");
		displayIterable(months.entrySet());
		System.out.println("subMap");
		displayIterable(months.subMap(12,45).keySet());
		String[] strings = {"ab","abc","lm","abc","ab", "lm", "lm"};
		displayOccurrencies(strings);
		//lm -> 3
		//ab ->2
		//abc ->2
	}
		@SuppressWarnings("rawtypes")
		private static void displayIterable (Iterable iterable) {
			for (Object object : iterable) {
				System.out.println(object);
			}
		}
		
		// строки могут повторяться
		/* распечатать строку и число повторений строки в массиве
		 *  распечатать в порядке убывания частот встречаемости
		 */
		@SuppressWarnings("unchecked")
		private static void displayOccurrencies(String [] strings) {
			TreeMap<String, Integer> occurencies = new TreeMap<>();
			for (int i = 0; i < strings.length; i++) {
				if (occurencies.containsKey(strings[i])) {
					Integer x = occurencies.get(strings[i]);
					occurencies.put(strings[i],x+1);
				} else occurencies.put(strings[i], 1);
			}
			LinkedList<Map.Entry<String,Integer>> arraypairs = new LinkedList<>();
			for (Map.Entry<String,Integer> pair : occurencies.entrySet()) {
				arraypairs.add(pair);
			}
	
				arraypairs.sort(new Comparator<Map.Entry<String,Integer>>() {
				public int compare(Map.Entry<String,Integer> o1, Map.Entry<String,Integer> o2) {
					if (o1.getValue()==o2.getValue()) {
						return o1.getKey().compareTo(o2.getKey());
						} 
					else return o2.getValue()-o1.getValue();
				}
			});
			for (Map.Entry<String,Integer> pair :arraypairs) {;
				System.out.println(pair.getKey() +" -> " +pair.getValue());
			}
		}
}


