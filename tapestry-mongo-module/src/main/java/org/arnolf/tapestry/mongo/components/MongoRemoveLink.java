package org.arnolf.tapestry.mongo.components;

import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.corelib.components.Any;

public class MongoRemoveLink {
	
	@InjectComponent
	private Any remove;
	
	public Any getAddLink() {
		return this.remove;
	}
}
