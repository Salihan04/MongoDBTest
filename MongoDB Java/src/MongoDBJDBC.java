import com.mongodb.DBCollection;

import utilities.Utilities;

public class MongoDBJDBC {
	private static String hostName;
	private static int port;
	private static String database;
	private static String collectionName;
	
	private static DBCollection collection;
	
	public static void main(String args[]) {
		hostName = "localhost";
		port = 27017;
		database = "test";
		collectionName = "people";
		
		try {
			Utilities.connectToDB(hostName, port, database);
			
			collection = Utilities.getDatabase().getCollection(collectionName);
			if(collection == null) {
				Utilities.createCollection(collectionName);
			}
			else {
				System.out.println("Collection '" + collectionName + "' selected successfully");
			}
						
			
		}catch(Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}
}
