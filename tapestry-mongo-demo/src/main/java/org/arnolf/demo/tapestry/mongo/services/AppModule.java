package org.arnolf.demo.tapestry.mongo.services;

import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.annotations.SubModule;
import org.arnolf.tapestry.mongo.constants.MongoSymbolConstants;
import org.arnolf.tapestry.mongo.services.MongoModule;

import com.mongodb.ReadPreference;

@SubModule(value = MongoModule.class)
public class AppModule {

	public static void contributeApplicationDefaults(MappedConfiguration<String, String> configuration) {
		configuration.add(MongoSymbolConstants.MONGO_DB, "test");
		configuration.add(MongoSymbolConstants.MONGO_HOSTS, "localhost:27017");
		configuration.add(MongoSymbolConstants.READ_PREFERENCE, ReadPreference.primaryPreferred().toString());
	}
}
