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

        <m:MongoTextField class="form-control" autocomplete="off" t:id="age" t:label="Age"
                t:document="document" t:translate="integer" t:validate="required" t:property="user.age"/>

###MongoTextArea

        <m:MongoTextArea t:id="comments" t:label="Comments"
                t:document="document" t:translate="string" t:validate="required" t:property="user.comments"/>
     
###MongoSelect

        <m:MongoSelect class="form-control" t:id="country" t:label="country" t:blankLabel="country"                                     t:model="literal:FR=france,IT=italy"
                t:document="document" t:validate="none" t:property="address.country"/>operty="country"/>

###MongoCheckbox

        <m:MongoCheckbox t:id="car" t:label="car"
                t:document="document" t:property="car"/>

###MongoRadioGroup
        
        <m:MongoRadioGroup t:id="gender" t:label="Gender" t:default="FEMALE" t:document="document" t:validate="required" t:property="user.gender">

        </m:MongoRadioGroup>

###MongoLabel


###MongoFormFragment

Mixins
=============

###MongoTriggerFragment
