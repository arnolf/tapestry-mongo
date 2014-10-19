package org.arnolf.tapestry.mongo.mixins;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.Field;
import org.apache.tapestry5.annotations.Environmental;
import org.apache.tapestry5.annotations.HeartbeatDeferred;
import org.apache.tapestry5.annotations.InjectContainer;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.json.JSONObject;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;
import org.arnolf.tapestry.mongo.components.MongoFormFragment;

public class MongoTriggerFragment {
	
	@InjectContainer
	private Field container;

	@Parameter(required = true, defaultPrefix = BindingConstants.COMPONENT, allowNull = false)
	private MongoFormFragment fragment;

	@Parameter
	private boolean invert;

	@Environmental
	private JavaScriptSupport javascriptSupport;

	@HeartbeatDeferred
	void beginRender() {
		JSONObject spec = new JSONObject("triggerId", container.getClientId(),
				"fragmentId", fragment.getFragment().getClientId()).put("invert", invert);

		javascriptSupport.addInitializerCall("linkTriggerToFormFragment", spec);
	}
}
