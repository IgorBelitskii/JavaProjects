import java.io.IOException;
import java.util.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;



public class JsonTest {
 private static final String TYPE = "_class";
static ObjectMapper mapper = new ObjectMapper();
 public static void main(String[] args) throws IOException, ClassNotFoundException {
/*  int[] ar = {1,4,-4,20};
  String json = mapper.writeValueAsString(ar); 
  int[][] ar1 = mapper.readValue("[[1,1],[2,3]],[[2,1],[1]", int[][].class);
  
  System.out.println(ar1.length +"; "+(ar1[0][0]));*/
	/* X x = new X();
	 x.setXarf(new float[]{2.4f,3.7f});
	 x.setXs("Hello");
	 x.setXi(10);
	 String json = mapper.writeValueAsString(x);
	 System.out.println(json);*/
	 mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	 X ar[] = {new X(10, new float[] {2.5f,6,7.8f},"abc"),
			 new X(2, new float[] {5}, "xs"), 
			 new Y(7, new float[] {4.5f, 4}, "xs", "ys",5)};
	List<Map<String,Object>> listMaps=getListMaps(ar);
	String json=mapper.writeValueAsString(listMaps);
	 // String json=mapper.writeValueAsString(ar);
	 
	 System.out.println(json);
/*	 X[]ar1=mapper.readValue(json, X[].class);
	 System.out.println(Arrays.deepToString(ar1));*/
	 List<Map<String,Object>> listMapsJson=mapper.readValue(json, List.class);
	 
	 X [] ar1=getArrayX(listMapsJson);
	 System.out.println(Arrays.toString(ar1));
	 
	 
	 
 }
private static X[] getArrayX(List<Map<String, Object>> listMapsJson) throws ClassNotFoundException, IOException {
	X[] res = new X[listMapsJson.size()];
	int ind=0; 
	for (Map<String,Object> mapJson : listMapsJson) {
		res[ind++]=getX(mapJson);
	}
	return res;
}
private static X getX(Map<String, Object> mapJson) throws ClassNotFoundException, IOException {
	String json=mapper.writeValueAsString(mapJson);
	
	return (X) mapper.readValue(json, Class.forName((String) mapJson.get(TYPE)));
}
private static List<Map<String, Object>> getListMaps(X[] ar) throws IOException {
	List<Map<String,Object>> result = new ArrayList<>();
	for (X x: ar) {
		result.add(getMap(x));
	}
	return result;
}
private static Map<String, Object> getMap(X x) throws IOException {
	String json = mapper.writeValueAsString(x);
	Map<String,Object> result = mapper.readValue(json, Map.class);
	result.put(TYPE, x.getClass().getName());
	return result;
}

}