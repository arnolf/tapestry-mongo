package org.arnolf.tapestry.mongo.services.impl;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.apache.tapestry5.ioc.annotations.Symbol;
import org.arnolf.tapestry.mongo.constants.MongoSymbolConstants;
import org.arnolf.tapestry.mongo.services.MongoConnection;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.ReadPreference;
import com.mongodb.ServerAddress;

public class MongoConnectionImpl implements MongoConnection {

	private DB db;
	
	public MongoConnectionImpl(@Symbol(MongoSymbolConstants.MONGO_HOSTS) String hosts,
			@Symbol(MongoSymbolConstants.READ_PREFERENCE) String readPreference,
			@Symbol(MongoSymbolConstants.MONGO_DB) String db) throws UnknownHostException {
		List<ServerAddress> addresses = new ArrayList<ServerAddress>();
		if (hosts != null && !hosts.isEmpty()) {
			for (String value : hosts.split(",")) {
				addresses.add(new ServerAddress(value));
			}
		}
		MongoClient mongo = new MongoClient(addresses);
		if (readPreference != null) {
			mongo.setReadPreference(ReadPreference.valueOf(readPreference));
		}
		this.db = mongo.getDB(db);
	}
	
	@Override
	public DB getDB() {
		return this.db;
	}

}
