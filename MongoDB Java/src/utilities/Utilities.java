package utilities;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class Utilities {
	private static MongoClient mongoClient;
	private static DB db;
	private static DBCollection collection;
	
	public static void connectToDB(String hostName, int port, String database) {
		try {
			//to connect to mongoDB server
			mongoClient = new MongoClient(hostName, port);
			
			//now connect to your database
			db = mongoClient.getDB(database);
			System.out.println("Connect to database successfully");
						
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}
	
	public static void createCollection(String collectionName) {
		collection = db.createCollection(collectionName, null);
		System.out.println("Collection created successfully");
	}
	
	public static MongoClient getMongoClient() {
		return mongoClient;
	}
	
	public static DB getDatabase() {
		return db;
	}
}
