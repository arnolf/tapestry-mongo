package org.arnolf.tapestry.mongo.components;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.Block;
import org.apache.tapestry5.ComponentAction;
import org.apache.tapestry5.annotations.AfterRender;
import org.apache.tapestry5.annotations.AfterRenderBody;
import org.apache.tapestry5.annotations.AfterRenderTemplate;
import org.apache.tapestry5.annotations.BeforeRenderTemplate;
import org.apache.tapestry5.annotations.HeartbeatDeferred;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SetupRender;
import org.apache.tapestry5.corelib.components.FormInjector;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.json.JSONArray;
import org.apache.tapestry5.json.JSONObject;
import org.apache.tapestry5.services.FormSupport;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;
import org.arnolf.tapestry.mongo.services.MongoService;

import com.mongodb.DBObject;

@Import(library = "classpath:org/arnolf/tapestry/mongo/components/MongoFormLoop.js")
public class MongoFormLoop {

	@Parameter(defaultPrefix = BindingConstants.LITERAL)
	private String element;
	
	@Parameter
	@Property
	private int index;
	
	@Parameter
	@Property
	private int max;
	
	@Parameter(defaultPrefix = BindingConstants.COMPONENT)
	private MongoAddLink add;
	
	@Parameter(defaultPrefix = BindingConstants.COMPONENT)
	private MongoRemoveLink remove;
	
	private int counter;
	
	@InjectComponent
	private FormInjector injector;
	
	@Parameter
	private DBObject document;
	
	@Parameter(defaultPrefix = BindingConstants.LITERAL)
	@Property
	private String property;
	
	@Inject
	private Block mainBlock;
	
	@Inject
	private JavaScriptSupport javaScriptSupport;
	
	private List<String> injectorIds;
	
	@Inject
	private FormSupport formSupport;
	
	@Inject
	private MongoService mongoService;
	
	static class RemoveProperty implements ComponentAction<MongoFormLoop>, Serializable {
		
		private static final long serialVersionUID = -4346426414137434418L;

		private String property;

		public RemoveProperty(String property) {
			this.property = property;
		}

		public void execute(MongoFormLoop component) {
			component.remove(property);
		}

	}
	
	@SetupRender
	public void init() {
		this.index = 0;
		this.injectorIds = new ArrayList<String>();
	}
	
	public void remove(String propertyToRemove) {
		mongoService.addProperty(document, propertyToRemove, null);
	}

	@BeforeRenderTemplate
	public void beforeRenderTemplate() {
		this.index = this.index + 1;
		formSupport.store(this, new RemoveProperty(property.concat(String.valueOf(index))));
	}
	
	@AfterRenderBody
	public void incrementCounter() {
		this.counter = this.counter + 1;
	}
	
	@AfterRenderTemplate
	public void retrieveInjectorId() {
		this.injectorIds.add(injector.getClientId());
	}
	
	public Block onInject(int i) {
		this.index = i;
		return mainBlock;
	}
	
	@AfterRenderTemplate
	public boolean afterRenderTemplate() {
		return this.max < this.index;
	}
	
	@AfterRender
	@HeartbeatDeferred
	public void afterRender() {
		JSONObject json = new JSONObject();
		json.put("position", this.counter);
		JSONArray injectors = new JSONArray();
		for (String injectorId : this.injectorIds) {
			injectors.put(injectorId);
		}
		json.put("injectors", injectors);
		json.put("add", this.add.getAddLink().getClientId());
		json.put("remove", this.remove.getAddLink().getClientId());
		javaScriptSupport.addInitializerCall("MongoFormLoop", json);
	}
}
