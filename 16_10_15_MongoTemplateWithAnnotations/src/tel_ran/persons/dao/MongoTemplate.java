package tel_ran.persons.dao;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.bson.Document;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.IndexOptions;
import tel_ran.databases.mongo.MongoConnection;
import tel_ran.persons.entities.Id;
import tel_ran.persons.entities.Index;

/**
 * «адача - обеспечение построени€ базы данных MongoDB
 * 
 * @author Igor
 *
 * @param <T>
 *            поле keyFieldName станет _id добавл€ем новое поле _class которое
 *            будет содержать им€ класса .getClass.getName           
 *            ID - тип пол€
 *            
 *            добавить две аннотации
 *            »ндекс 
 *            и параметр юник или не юник (уникальность)
 *            Method unique of the IndexOptions gets string with
				either УtrueФ or УfalseФ
				<collection>.createIndex(new Document(<field
				name>, new IndexOptions().unique(УtrueФ|ФfalseФ))
				
				≈сли есть аннотации. 
				ќн сам определе€т 
				ID и Index
 * @param <ID>
				
 *            
 */
public class MongoTemplate<T> {
	private static final String TYPE = "_class";
	static ObjectMapper mapper = new ObjectMapper();
	String uriStr, databaseName, keyFieldName, collectionName;
	MongoConnection connection;
	MongoCollection<Document> collection;
	private T value;
	Class clazz;
	Class ID;
	public MongoTemplate(String uriStr, String databaseName, String keyFieldName, String collectionName, Class TClass)
			throws Exception {
		this.uriStr = uriStr;
		this.databaseName = databaseName;
		this.keyFieldName = keyFieldName;
		this.collectionName = collectionName;
		this.clazz=TClass;
		System.out.println("MongoTemplateStarted");
		connection = MongoConnection.getMongoConnection(uriStr, databaseName);
		collection = connection.getDataBase().getCollection(collectionName);
		System.out.println("Type" + clazz.getName());
		Field[] fields=clazz.getDeclaredFields();//getDeclaredFields();
		int k=0;
		for (Field field : fields) {
			
			if (field.isAnnotationPresent(Id.class)){
					System.out.print("Annotation id found in field "+field.getName());
				//	ID= Integer.class;
					switch (field.getAnnotation(Id.class).value()) {
		            case "Integer":  ID=Integer.class;
		                     break;
		            case "String":  ID=String.class;
		                     break;
		            default:  ID=Integer.class;;
		                     break;
		        }
					k++;
			//	String path = field.getAnnotation(Id.class).value();
			//		System.out.println(", ID - " +path);
			}
			if (field.isAnnotationPresent(Index.class)) {
					System.out.println();
					System.out.print("Annotation index found in field "+field.getName());
					String p2 = field.getAnnotation(Index.class).value();
				System.out.println(", INDEX value - "+p2);
				
				// collection.createIndex(new BasicDBObject(field.getName(), 1).append("unique", true));
				collection.createIndex(new Document(field.getName(),1), new IndexOptions().unique(true));
				}
		}
		if (k==0) ID=Integer.class;
	}

	public void saveOne(T obj) throws IOException {
		collection.insertOne(createDocument(obj));
	}

	@SuppressWarnings("unchecked")
	private Document createDocument(T obj) throws IOException {
		Document res = new Document(getMap(obj));
		if (res.containsKey(keyFieldName)) {
			T obj1 = (T) res.remove(keyFieldName);
			res.put("_id", obj1);
		}
		return res;
	}

	public void saveMany(List<T> objects) throws IOException {
		List<Document> listDocs = new LinkedList<>();
		for (T obj : objects) {
			listDocs.add(createDocument(obj));
		}
		collection.insertMany(listDocs);
	}

	private static Map<String, Object> getMap(Object x) throws IOException {
		Map<String, Object> result = mapper.convertValue(x, Map.class);
		/*
		 * String json = mapper.writeValueAsString(x); Map<String, Object>
		 * result = mapper.readValue(json, Map.class);
		 */
		result.put(TYPE, x.getClass().getName());
		return result;
	}
	public T findOne(Object id) throws JsonParseException, JsonMappingException, ClassNotFoundException, IOException {
		Document query = new Document("_id",id);
		FindIterable<Document> resIterable = collection.find(query);
		if (resIterable == null)
			return null;
		Document resDocument = resIterable.first();
		if (resDocument==null)
			return null;
		return getObjectFromDocument(resDocument);
	}

	public Iterable<T> findMany(Document query) throws JsonParseException, JsonMappingException, ClassNotFoundException, IOException {
		FindIterable<Document> resIterable = collection.find(query);
		List<T> listObjects = new ArrayList<>(); 
		for (Iterator iterator = resIterable.iterator(); iterator.hasNext();) {
			Document doc = (Document) iterator.next();
			listObjects.add(getObjectFromDocument(doc));
		}
		return listObjects;
	}

	private List<Document> getQueriesList(String[] names) {
		List<Document> queriesList=new LinkedList<>();
		for (int i = 0; i < names.length; i++) {
			queriesList.add(new Document("name", names[i]));
			}
		return queriesList;
	}

	@SuppressWarnings("unchecked")
	private T getObjectFromDocument(Document resDocument) throws JsonParseException, JsonMappingException, ClassNotFoundException, IOException {
		if (resDocument.containsKey("_id")) {
			T obj1 = (T) resDocument.remove("_id");
			resDocument.put(keyFieldName, obj1);
		}
		String class1 = (String) resDocument.get(TYPE);
		resDocument.remove(TYPE);
		String json = mapper.writeValueAsString(resDocument);
		
		return (T) mapper.readValue(json, Class.forName(class1));
	}
	
	public void createIndex(String on, int type){
        collection.createIndex(new BasicDBObject(on, type).append("unique", true));
    }

	public void drop() {
		collection.drop();
		
	}
}
