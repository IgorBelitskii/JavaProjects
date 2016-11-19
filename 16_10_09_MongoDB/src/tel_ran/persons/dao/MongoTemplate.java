package tel_ran.persons.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.bson.Document;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

import tel_ran.databases.mongo.MongoConnection;
import tel_ran.persons.entities.Person;

/**
 * ������ - ����������� ���������� ���� ������ MongoDB
 * 
 * @author Igor
 *
 * @param <T>
 *            ���� keyFieldName ������ _id ��������� ����� ���� _class �������
 *            ����� ��������� ��� ������ .getClass.getName           
 *            ID - ��� ����
 *            
 *            �������� ��� ���������
 *            ������ 
 *            � �������� ���� ��� �� ���� (������������)
 *            Method unique of the IndexOptions gets string with
				either �true� or �false�
				<collection>.createIndex(new Document(<field
				name>, new IndexOptions().unique(�true�|�false�))
				
				���� ���� ���������. 
				�� ��� ���������� 
				ID � Index
				
 *            
 */
public class MongoTemplate<T, ID> {
	private static final String TYPE = "_class";
	static ObjectMapper mapper = new ObjectMapper();
	String uriStr, databaseName, keyFieldName, collectionName;
	MongoConnection connection;
	MongoCollection<Document> collection;

	public MongoTemplate(String uriStr, String databaseName, String keyFieldName, String collectionName)
			throws Exception {
		this.uriStr = uriStr;
		this.databaseName = databaseName;
		this.keyFieldName = keyFieldName;
		this.collectionName = collectionName;

		connection = MongoConnection.getMongoConnection(uriStr, databaseName);
		collection = connection.getDataBase().getCollection(collectionName);

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

	public T findOne(ID id) throws JsonParseException, JsonMappingException, ClassNotFoundException, IOException {
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
}
