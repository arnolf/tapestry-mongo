package org.arnolf.tapestry.mongo.components;

import java.util.List;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.corelib.components.FormFragment;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.arnolf.tapestry.mongo.services.MongoService;

import com.mongodb.DBObject;

@Import(library = "classpath:org/arnolf/tapestry/mongo/components/MongoFormFragment.js")
public class MongoFormFragment {

	@Component(id = "fragment", inheritInformalParameters = true, publishParameters = "alwaysSubmit,element,visibleBound")
	private FormFragment fragment;
	
	@Parameter(allowNull = false, required = true, defaultPrefix = BindingConstants.LITERAL)
	private String property;
	
	@Parameter(allowNull = false, required = true, defaultPrefix = BindingConstants.PROP)
	private List<Object> visible;
	
	@Parameter(allowNull = false, required = true)
	private DBObject document;
	
	@Inject
	private MongoService mongoService;
	
	public Object getVisible() {
		Object result = mongoService.getProperty(document, property);
		return visible.contains(result);
	}
	
	public FormFragment getFragment() {
		return this.fragment;
	}
}
