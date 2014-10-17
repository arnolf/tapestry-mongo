package org.arnolf.tapestry.mongo.services;

import org.apache.tapestry5.ioc.Configuration;
import org.apache.tapestry5.ioc.ServiceBinder;
import org.apache.tapestry5.services.LibraryMapping;
import org.arnolf.tapestry.mongo.services.impl.MongoConnectionImpl;
import org.arnolf.tapestry.mongo.services.impl.MongoServiceImpl;

public class MongoModule {

	public static void contributeComponentClassResolver(Configuration<LibraryMapping> configuration) {
		configuration.add(new LibraryMapping("mongo", "org.arnolf.tapestry.mongo"));
	}
	
	public static void bind(ServiceBinder binder) {
		binder.bind(MongoConnection.class, MongoConnectionImpl.class);
		binder.bind(MongoService.class, MongoServiceImpl.class);
	}

}
