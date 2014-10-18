package org.arnolf.demo.tapestry.mongo.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.tapestry5.Asset;
import org.apache.tapestry5.services.AssetSource;
import org.apache.tapestry5.services.javascript.JavaScriptStack;
import org.apache.tapestry5.services.javascript.StylesheetLink;

public class BoostrapStack implements JavaScriptStack {

    private final AssetSource assetSource;
    
    public BoostrapStack(AssetSource assetSource) {
    	this.assetSource = assetSource;
    }

	@Override
	public List<String> getStacks() {
		return Collections.emptyList();
	}

	@Override
	public List<Asset> getJavaScriptLibraries() {
		List<Asset> ret = new ArrayList<Asset>(); 
	    ret.add(assetSource.getContextAsset("context:bootstrap/js/bootstrap.min.js", null));
	    return ret;
	}

	@Override
	public List<StylesheetLink> getStylesheets() {
		List<StylesheetLink> ret = new ArrayList<StylesheetLink>(); 
        ret.add(new StylesheetLink(assetSource.getContextAsset("context:bootstrap/css/bootstrap.min.css", null)));
        ret.add(new StylesheetLink(assetSource.getContextAsset("context:bootstrap/css/bootstrap-theme.min.css", null)));
        return ret;
	}

	@Override
	public String getInitialization() {
		return null;
	}

}
