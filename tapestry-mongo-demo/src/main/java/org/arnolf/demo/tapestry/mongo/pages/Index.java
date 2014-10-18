package org.arnolf.demo.tapestry.mongo.pages;

import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SetupRender;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.arnolf.tapestry.mongo.services.MongoConnection;

import com.mongodb.BasicDBObject;
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
		this.document = new BasicDBObject();
	}
	
	public void onSubmit() {
		System.out.println("submit" + document);
	}
}
