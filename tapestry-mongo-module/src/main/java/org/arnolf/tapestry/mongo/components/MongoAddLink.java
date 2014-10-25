package org.arnolf.tapestry.mongo.components;

import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.corelib.components.Any;

public class MongoAddLink {

	@InjectComponent
	private Any add;
	
	public Any getAddLink() {
		return this.add;
	}
}
