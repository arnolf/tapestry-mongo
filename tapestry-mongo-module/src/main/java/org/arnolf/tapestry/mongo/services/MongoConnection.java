package org.arnolf.tapestry.mongo.services;

import com.mongodb.DB;

public interface MongoConnection {

	DB getDB();
}
