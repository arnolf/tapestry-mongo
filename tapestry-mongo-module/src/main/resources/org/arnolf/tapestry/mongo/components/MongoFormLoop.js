Tapestry.Initializer.MongoFormLoop = function(spec) {
    new MongoFormLoop(spec);
}

MongoFormLoop = Class.create( {

    initialize : function(spec) {
    	var position = spec.position;
    	
    	jQuery('#' + spec.add).click(function() {
    		if (position < spec.injectors.length) {
    			$(spec.injectors[position]).trigger();
	    		position = position + 1;
    		}
    	});
    	jQuery('#' + spec.remove).click(function() {
    		if (position > 0) {
    			position = position - 1;
    			var container = $(spec.injectors[position]).next();
    			Tapestry.ElementEffect.hide(container);
    			Tapestry.remove(container); 
    		}
    	});
    }
    
})