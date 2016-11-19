package tel_ran.persons.dao;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import tel_ran.persons.entities.TestClass;

public class JDBCTemplate {
	private static final String TYPE = "_class";
	static ObjectMapper mapper = new ObjectMapper();

	public static void main(String[] args) throws Exception {
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		TestClass test = new TestClass(10, "Number1", 1000);
		System.out.println(test);
		Map<String, Object> result = getMap(test);
		System.out.println("converted to MAP:");
		System.out.println(result);
		System.out.println("converted from MAP to object:");
		Object test2 = getX(result);
		System.out.println(test2);
		System.out.println("String for Insert Statement JDBC:");
		System.out.println(getInsertStatement(test));
		// PersonsJdbc personsJdbc = new PersonsJdbc();
	}

	public static String getInsertStatement(Object obj) throws IOException {
		Map<String, Object> res = getMap(obj);
		String result = "("; // (id,name,birthYear) Values(%d,'%s',%d)
		int k = 0;
		for (String str : res.keySet()) {
			if (k == 1)
				result += ",";
			result += str;
			k = 1;
		}
		result += ") Values (";
		k = 0;
		for (Object str : res.values()) {
			// System.out.println(str.getClass().getName());

			if (k == 1)
				result += ",";
			if (str.getClass().getName().equals("java.lang.String")) {
				result += "\"";
			}
			result += str;
			k = 1;
			if (str.getClass().getName().equals("java.lang.String")) {
				result += "\"";
			}
		}
		result += ")";
		return result;

	}

	public static Object getObject(ResultSet rs) throws ClassNotFoundException, IOException, SQLException {
		Map<String, Object> map = getMapfromRS(rs);
		Object result = getX(map);
		return result;
	}

	private static Object getX(Map<String, Object> mapJson) throws ClassNotFoundException, IOException {
		String json = mapper.writeValueAsString(mapJson);

		return (Object) mapper.readValue(json, Class.forName((String) mapJson.get(TYPE)));
	}

	private static Map<String, Object> getMap(Object x) throws IOException {
		String json = mapper.writeValueAsString(x);
		Map<String, Object> result = mapper.readValue(json, Map.class);
		result.put(TYPE, x.getClass().getName());
		return result;
	}

	public static Map<String, Object> getMapfromRS(ResultSet rs) throws SQLException {
		ResultSetMetaData meta = rs.getMetaData();
		Map<String, Object> map = new HashMap<>();
		for (int i = 1; i <= meta.getColumnCount(); i++) {
			String key = meta.getColumnName(i);
			String value = rs.getString(key);
			map.put(key, value);
		}
		return map;
	}

}