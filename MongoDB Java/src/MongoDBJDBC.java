import java.io.Writer;
import java.util.ArrayList;

import model.Person;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;

import utilities.Utilities;

public class MongoDBJDBC {
	private static String hostName;
	private static int port;
	private static String database;
	private static String collectionName;
	private static DBCollection collection;

	public static void insertDocument(Person person) {
		int i;
		ArrayList<String> personParams = Person.getPersonParams();
		int numParams = Person.getNumOfPersonParams();
		ArrayList<Object> paramValues = person.getParamValues();

		//Inserting document
		BasicDBObject doc = new BasicDBObject();
		for(i = 0; i < numParams; i ++) {
			doc.append(personParams.get(i), paramValues.get(i));
		}
		collection.insert(doc);
		System.out.println("Document inserted successfully");
	}

	public static void updateDocument(BasicDBObject query) {
		DBObject update = new BasicDBObject();
		update.put("$set", new BasicDBObject("age","20"));
		WriteResult result = collection.update(query, update); 
        System.out.println("Document updated successfully");
	}

	public static void deleteDocument() {
		//find the first document from the collection
		DBObject myDoc = collection.findOne();
		collection.remove(myDoc);
		System.out.println("Document deleted successfully");
	}
	
	public static void queryCollection(BasicDBObject query) {
		DBCursor cursor = collection.find();
		cursor = collection.find(query);

		try {
		   while(cursor.hasNext()) {
		       System.out.println(cursor.next());
		   }
		} finally {
		   cursor.close();
		}
	}

	public static void retrieveAllDocs() {
		DBCursor cursor = collection.find();
		int j=1;
		try {
			while (cursor.hasNext()) { 
				System.out.println("Document: "+ j); 
				System.out.println(cursor.next()); 
				j++;
			}
		} finally {
			cursor.close();
		}
	}

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

//			Person person = new Person("Tom", "male", 24);			
//			insertDocument(person);
			
//			deleteDocument();

			//querying the collection for a document
			BasicDBObject query = new BasicDBObject("name", "Tom");
//			queryCollection(query);
			//updateDocument(query);
			
			//display all documents
			retrieveAllDocs();

		}catch(Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}
}
