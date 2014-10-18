package org.arnolf.tapestry.mongo.components;

import org.apache.tapestry5.Field;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.corelib.components.Checkbox;

public class MongoCheckbox extends AbstractMongoField {

	@Component(id = "mongoField", inheritInformalParameters = true, publishParameters = "disabled,label,clientId")
	private Checkbox mongoField;
	
	@Override
	public Field getField() {
		return this.mongoField;
	}

}
