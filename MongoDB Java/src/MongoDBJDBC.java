import utilities.Utilities;


public class MongoDBJDBC {
	private static String hostName;
	private static int port;
	private static String database;
	
	public static void main(String args[]) {
		hostName = "localhost";
		port = 27017;
		database = "test";
		
		try {
			Utilities.connectToDB(hostName, port, database);
			
			
		}catch(Exception e) {
			
		}
	}
}
