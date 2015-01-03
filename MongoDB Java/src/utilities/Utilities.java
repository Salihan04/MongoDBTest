package utilities;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class Utilities {
	
	public static void connectToDB(String hostName, int port, String database) {
		
		try {
			//to connect to mongoDB server
			MongoClient mongoClient = new MongoClient(hostName, port);
			
			//now connect to your database
			DB db = mongoClient.getDB(database);
			System.out.println("Connect to database successfully");
						
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}
}
