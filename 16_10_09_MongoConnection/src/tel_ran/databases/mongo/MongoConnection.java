package tel_ran.databases.mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import java.util.*;

public class MongoConnection {
//	private static final String URI = "mongodb://igsoft:igsoft@ds021166.mlab.com:21166/igsoft";
	static Map<String, MongoConnection> mongoConnections = new LinkedHashMap<>();
	MongoDatabase dataBase;
	MongoClient client;

	/**
	 * 
	 * @param uriwith   username and password but with no database
	 * @param database
	 */
	private MongoConnection(String uriStr, String database) {
		MongoClientURI uri = new MongoClientURI(uriStr + database);
		client = new MongoClient(uri);
		dataBase = client.getDatabase(database);
	}

	synchronized public static MongoConnection getMongoConnection(String uriStr, String database) {
		MongoConnection res = mongoConnections.get(database);
		if (res==null) {
			res = new MongoConnection(uriStr, database);
			mongoConnections.put(database, res);
		}
		return res;
	}
	
	public MongoDatabase getDataBase() {
		
		return dataBase;
	}

}