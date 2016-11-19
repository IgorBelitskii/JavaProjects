package tel_ran.databases.mongo.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import tel_ran.databases.mongo.MongoConnection;

public class MongoConnectionTests {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testMongoConnection() {
		MongoConnection connection1 = MongoConnection.getMongoConnection
				("mongodb://igsoft:igsoft@ds021166.mlab.com:21166/", "igsoft");
		MongoConnection connection2 = MongoConnection.getMongoConnection
				("mongodb://igsoft:igsoft@ds021166.mlab.com:21166/", "igsoft");
		assertTrue(connection1==connection2);
	}

}
