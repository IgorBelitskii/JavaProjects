package tel_ran.databases.jdbc.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import tel_ran.databases.jdbc.DatabaseConnection;

public class DatabaseConnectionTest {

	@Test
	public void testConnection() throws Exception {
		DatabaseConnection databaseConnection = DatabaseConnection.getDatabaseConnection("root", "root", null, null);
		DatabaseConnection databaseConnection2 = DatabaseConnection.getDatabaseConnection("root", "root", null, null);
		assertTrue(databaseConnection==databaseConnection2);
		assertTrue(databaseConnection.getConnection()!=null);
	}

}
