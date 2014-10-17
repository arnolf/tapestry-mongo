package org.arnolf.demo.tapestry.mongo.pages;

import java.util.Set;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SetupRender;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.arnolf.tapestry.mongo.services.MongoConnection;

public class Index {

	@Inject
	private MongoConnection mongoConnection;
	
	@Property
	private Set<String> collectionNames;
	
	@SetupRender
	public void init() {
		this.collectionNames = mongoConnection.getDB().getCollectionNames();
	}
}
