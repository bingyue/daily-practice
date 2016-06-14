package me.bingyue.daily.mongo;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.mongodb.util.JSON;

public class ClientTest {

	public static String host="10.0.0.162";
	public static int port=38092;
	public static String username="test";
	public static String password="test";

	public static void main(String[] args){
		Mongo mongo=new Mongo(host, port);
//		MongoOptions options= mongo.getMongoOptions();
		
		//查询所有的Database
        for (String name : mongo.getDatabaseNames()) {
            System.out.println("dbName: " + name);
        }
        
        DB db = mongo.getDB("test");
        //查询所有的聚集集合
        for (String name : db.getCollectionNames()) {
            System.out.println("collectionName: " + name);
        }
        
        DBCollection users = db.getCollection("users");
        //查询所有的数据
        DBCursor cur = users.find();
        while (cur.hasNext()) {
            System.out.println(cur.next());
        }
        System.out.println(cur.count());
        System.out.println(cur.getCursorId());
        System.out.println(JSON.serialize(cur));
	}
}
