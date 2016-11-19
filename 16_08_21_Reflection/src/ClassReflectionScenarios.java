import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import tel_ran.reflection.x.X;
import tel_ran.reflection.x.X1;

public class ClassReflectionScenarios {

	private static String PACKAGE_NAME = "tel_ran.reflection.x";



	public static void main(String[] args) {
		//Scenario #1 - get empty object from object of unknown class
//		Collection<Integer> collection = new LinkedList<>();
//		collection.add(10);
//		collection.add(15);
//		Collection<Integer> resEven = getEvenNumbers(collection);
//		System.out.println(resEven.getClass() == collection.getClass());
		
//		//Scenario #2 - get name of the class of an object of unknown class
//		X[] array = {new X(),new Z(),new Z(),new X(),new Y(),new X()};
//		
//		HashMap<String, Integer> res = getMapObjectsX(array);
//		System.out.println(res);
		
//		//Scenario #3 - get object of the class having String with the class name
//		HashMap<String,Integer> map = new HashMap<String, Integer>();
//		map.put("X", 3);
//		map.put("Y", 2);
//		map.put("Z", 1);
//		
//		ArrayList<X> array = getArrayObjects(map);
//		action(array);
		
		//Scenario #4 - get 
		Object obj = new X1();
		proceed(obj,"f1",null);
		proceed(obj,"f2",null);
		proceed(obj,"f1","test");
	}

	private static void proceed(Object obj, String methodName, String parameter) {
		Class objClass = obj.getClass();
		Method method = null;
		try {
			method = parameter ==null ? objClass.getDeclaredMethod(methodName):objClass.getDeclaredMethod(methodName, String.class);
			if(parameter == null)
				method.invoke(obj);
			else {
				method.setAccessible(true);
				method.invoke(obj, parameter);
			}
				
		} catch (Exception e) {
			
		}
		
		
	}

	private static void action(ArrayList<X> array) {
		for (X x : array) {
			x.action();
		}
		
	}

	private static ArrayList<X> getArrayObjects(HashMap<String, Integer> map) {
		ArrayList<X> res = new ArrayList<>();
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			createObj(entry.getKey(),entry.getValue(), res);
		}
		return res;
	}

	private static void createObj(String className, int count, ArrayList<X> res) {
		
		while(count>0) {
			try {
				X x = (X) Class.forName(PACKAGE_NAME + "." + className).newInstance();
				res.add(x);
				count--;
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	private static HashMap<String, Integer> getMapObjectsX(X[] array) {
		HashMap<String, Integer> res = new HashMap<>();
		for (X x : array) {
			String className = x.getClass().getName();
			Integer count = res.get(className);
			if(count == null) {
				count = 0;
			}
			count++;
			res.put(className, count);
		}
		
		return res;
	}

	

	private static Collection<Integer> getEvenNumbers(Collection<Integer> collection) {
		@SuppressWarnings("rawtypes")
		Class objClass = collection.getClass();
		try {
			@SuppressWarnings("unchecked")
			Collection<Integer> res = (Collection<Integer>) objClass.newInstance();
			for (Integer integer : collection) {
				if(integer % 2 ==0)
					res.add(integer);
			}
			return res;
		} catch (InstantiationException | IllegalAccessException e) {
			
		}
		return null;
	}

}
