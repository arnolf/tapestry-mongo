tapestry-mongo
==============

Tapestry5 form components with Mongo storage.

Setup
=============

In your AppModule, configure Mongo connection with symbols :

        public static void contributeApplicationDefaults(MappedConfiguration<String, String> configuration) {
                configuration.add(MongoSymbolConstants.MONGO_DB, "test");
                configuration.add(MongoSymbolConstants.MONGO_HOSTS, "localhost:27017");
                configuration.add(MongoSymbolConstants.READ_PREFERENCE, ReadPreference.primaryPreferred().toString());
        }
        
Components
=============

###MongoTextField

        <m:MongoTextField autocomplete="off" t:id="age" t:label="Age"
                t:document="document" t:translate="integer" t:validate="required" t:property="user.age"/>

###MongoTextArea

        <m:MongoTextArea t:id="comments" t:label="Comments"
                t:document="document" t:translate="string" t:validate="required" t:property="user.comments"/>
     
###MongoSelect

        <m:MongoSelect t:id="country" t:label="country" t:blankLabel="country"                                                          t:model="literal:FR=france,IT=italy"
                t:document="document" t:validate="none" t:property="country"/>

###MongoCheckbox

        <m:MongoCheckbox t:id="car" t:label="car"
                t:document="document" t:property="user.car"/>

###MongoRadioGroup


###MongoLabel


###MongoFormFragment

Mixins
=============

###MongoTriggerFragment
