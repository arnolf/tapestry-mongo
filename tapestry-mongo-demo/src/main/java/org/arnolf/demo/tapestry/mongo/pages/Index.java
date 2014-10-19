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
	
	@Property
	private boolean separateShipTo;
	
	private long userId;
	
	public void onActivate(long userId) {
		this.userId = userId;
	}
	
	public long onPassivate() {
		return this.userId;
	}
	
	@SetupRender
	public void init() {
		DB db = this.mongoConnection.getDB();
		this.document = db.getCollection("person").
				findAndModify(new BasicDBObject("_id", userId), null, null, false, new BasicDBObject("$set", new BasicDBObject("_id", userId)), true, true);
	}
	
	public void onSubmit() {
		this.mongoConnection.getDB().getCollection("person").save(document);
	}
}
