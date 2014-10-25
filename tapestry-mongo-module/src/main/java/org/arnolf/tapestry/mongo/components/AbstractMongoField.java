package org.arnolf.tapestry.mongo.components;

import java.io.Serializable;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.ComponentAction;
import org.apache.tapestry5.Field;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.SetupRender;
import org.apache.tapestry5.annotations.SupportsInformalParameters;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.FormSupport;
import org.arnolf.tapestry.mongo.services.MongoService;

import com.mongodb.DBObject;

@SupportsInformalParameters
public abstract class AbstractMongoField {

	@Parameter(allowNull = false, required = true)
	private DBObject document;
	
	@Parameter(allowNull = false, required = true, defaultPrefix = BindingConstants.LITERAL)
	private String property;
	
	@Inject
	private MongoService mongoService;
	
	@Inject
	private FormSupport formSupport;
	
	private String restoredProperty;

	static class RestoreProperty implements ComponentAction<AbstractMongoField>, Serializable {
		private static final long serialVersionUID = -4346426414137434418L;

		private String property;

		public RestoreProperty(String property) {
			this.property = property;
		}

		public void execute(AbstractMongoField component) {
			component.restore(property);
		}

	}

    @SetupRender
    public void initFormAction() {
    	formSupport.store(this, new RestoreProperty(property));
    }
	
	public void restore(String propertyToRestore) {
		this.restoredProperty = propertyToRestore;
	}

	public Object getValue() {
		return mongoService.getProperty(document, property);		
	}
	
	public void setValue(Object value) {
		mongoService.addProperty(document, restoredProperty, value);
	}
	
	public abstract Field getField();
}
