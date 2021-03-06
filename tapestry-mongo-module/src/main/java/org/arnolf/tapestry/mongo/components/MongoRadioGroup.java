package org.arnolf.tapestry.mongo.components;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.Field;
import org.apache.tapestry5.FieldValidator;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.corelib.components.RadioGroup;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.FieldValidatorSource;

public class MongoRadioGroup extends AbstractMongoField {

	@Component(id = "mongoField", inheritInformalParameters = true, publishParameters = "disabled,label,clientId")
	private RadioGroup mongoField;
	
	@Parameter(allowNull = false, required = true, defaultPrefix = BindingConstants.LITERAL)
	private String validate;
	
	@Parameter(name = "default", allowNull = false, required = false, defaultPrefix = BindingConstants.LITERAL)
	private String defaultValue;
	
	@Inject
	private FieldValidatorSource fieldValidatorSource;
	
	public Object getValue() {
		Object result = super.getValue();
		if (defaultValue != null && result == null) {
			result = defaultValue;
		}
		return result;
	}
	
	public FieldValidator<?> getValidate() {
		return fieldValidatorSource.createValidators(mongoField, validate);
	}
	
	@Override
	public Field getField() {
		return this.mongoField;
	}
}
