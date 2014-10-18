package org.arnolf.demo.tapestry.mongo.pages;

import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SetupRender;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.arnolf.tapestry.mongo.services.MongoConnection;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBObject;

@Import(stack = { "boostrap" })
public class Index {

	@Inject
	private MongoConnection mongoConnection;
	
	@Property
	@Persist
	private DBObject document;
	
	@SetupRender
	public void init() {
		DB db = this.mongoConnection.getDB();
		this.document = db.getCollection("person").findOne(new BasicDBObject("id", 12432));
		if (this.document == null) {
			this.document = new BasicDBObject("id", 12432);
		}
	}
	
	public void onSubmit() {
		this.mongoConnection.getDB().getCollection("person").save(document);
	}
}
