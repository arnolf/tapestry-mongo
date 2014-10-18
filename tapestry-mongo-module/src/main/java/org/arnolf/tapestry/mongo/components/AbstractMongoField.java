package org.arnolf.tapestry.mongo.components;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.Field;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.arnolf.tapestry.mongo.services.MongoService;

import com.mongodb.DBObject;

public abstract class AbstractMongoField {

	@Parameter(allowNull = false, required = true)
	private DBObject document;
	
	@Parameter(allowNull = false, required = true, defaultPrefix = BindingConstants.LITERAL)
	private String property;
	
	@Inject
	private MongoService mongoService;
	
	public Object getValue() {
		return mongoService.getProperty(document, property);		
	}
	
	public void setValue(Object value) {
		mongoService.addProperty(document, property, value);
	}
	
	public abstract Field getField();
}
