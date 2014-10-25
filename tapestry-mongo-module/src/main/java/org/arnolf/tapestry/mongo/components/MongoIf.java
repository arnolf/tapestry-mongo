package org.arnolf.tapestry.mongo.components;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.arnolf.tapestry.mongo.services.MongoService;

import com.mongodb.DBObject;

public class MongoIf {

	@Parameter(allowNull = false, required = true)
	private DBObject document;
	
	@Parameter(allowNull = false, required = true, defaultPrefix = BindingConstants.LITERAL)
	private String property;
	
	@Inject
	private MongoService mongoService;
	
	public Object getTest() {
		return mongoService.getProperty(document, property);
	}
}
