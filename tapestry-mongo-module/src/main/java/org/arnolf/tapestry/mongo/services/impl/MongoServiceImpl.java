package org.arnolf.tapestry.mongo.services.impl;

import java.util.StringTokenizer;

import org.arnolf.tapestry.mongo.services.MongoService;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class MongoServiceImpl implements MongoService {

	@Override
	public void addProperty(DBObject object, String property, Object value) {
		StringTokenizer tokenizer = new StringTokenizer(property, ".");
		DBObject current = object;
		while (tokenizer.hasMoreTokens()) {
			String name = tokenizer.nextToken();
			if (tokenizer.hasMoreTokens()) {
				if (current.get(name) != null && current.get(name) instanceof DBObject) {
					current = (DBObject) current.get(name);
				} else {
					DBObject nextCurrent = new BasicDBObject();
					current.put(name, nextCurrent);
					current = nextCurrent;
				}
			} else {
				current.put(name, value);
			}
		}
	}

	@Override
	public Object getProperty(DBObject object, String property) {
		StringTokenizer tokenizer = new StringTokenizer(property, ".");
		Object value = null;
		DBObject current = object;
		while (tokenizer.hasMoreTokens()) {
			String name = tokenizer.nextToken();
			if (tokenizer.hasMoreTokens()) {
				if (current.get(name) != null && current.get(name) instanceof DBObject) {
					current = (DBObject) current.get(name);
				} else {
					value = null;
					break;
				}
			} else {
				value = current.get(name);
			}
		}
		return value;
	}
	
	public boolean hasProperty(DBObject object, String property) {
		StringTokenizer tokenizer = new StringTokenizer(property, ".");
		boolean value = true;
		DBObject current = object;
		while (tokenizer.hasMoreTokens()) {
			String name = tokenizer.nextToken();
			if (tokenizer.hasMoreTokens()) {
				if (current.containsField(name) && current.get(name) != null && current.get(name) instanceof DBObject) {
					current = (DBObject) current.get(name);
				} else {
					value = false;
					break;
				}
			} else {
				value = current.containsField(name);
			}
		}
		return value;
	}

}
