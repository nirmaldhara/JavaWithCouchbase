package com.cuchbase.java;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonObject;

public class CouchbaseJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try{
		////////Create the cluster
		Cluster cluster = CouchbaseCluster.create();
		////////////Open the bucket on that cluster
		Bucket bucket = cluster.openBucket("javaant", "javaant");
		
		///////////////////////Make a Json File
		JsonObject object = JsonObject.empty()
			    .put("firstname", "Java")
			    .put("lastname", "Ant")
			    .put("type", "blog");
		///////// create json object
		JsonDocument doc = JsonDocument.create("myFirstDoc", object);
		
		/////////insert the json object to bucket
		JsonDocument response = bucket.upsert(doc);
		System.out.println("Done");
		}
		catch(Exception e){
			e.printStackTrace();
		}
			   

	}

}
