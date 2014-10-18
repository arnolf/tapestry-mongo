package org.arnolf.tapestry.mongo.components;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.FieldTranslator;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.corelib.components.TextField;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.FieldTranslatorSource;

public class MongoTextField extends AbstractMongoField {

	@Component(id = "mongoField", publishParameters = "disabled")
	private TextField mongoField;
	
	@Inject
	private FieldTranslatorSource fieldTranslatorSource;
	
	@Inject
	private ComponentResources componentResources;
	
	@Parameter(allowNull = false, required = true, defaultPrefix = BindingConstants.LITERAL)
	private String translate;
	
	public FieldTranslator<?> getTranslate() {	
		return fieldTranslatorSource.createTranslator(((org.apache.tapestry5.runtime.Component)mongoField).getComponentResources(), translate);
	}
}
