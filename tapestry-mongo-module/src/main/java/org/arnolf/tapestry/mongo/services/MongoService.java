package org.arnolf.tapestry.mongo.services;

import com.mongodb.DBObject;

public interface MongoService {

	void addProperty(DBObject object, String property, Object value);
	
	Object getProperty(DBObject object, String property);
	
	boolean hasProperty(DBObject object, String property);

}
