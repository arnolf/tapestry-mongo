package org.arnolf.tapestry.mongo.components;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.Field;
import org.apache.tapestry5.annotations.Parameter;

public class MongoLabel {
	
    @Parameter(name = "for", required = true, allowNull = false, defaultPrefix = BindingConstants.COMPONENT)
    private AbstractMongoField field;
    
    public Field getField() {
    	return field.getField();
    }

}
