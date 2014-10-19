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
        
        
Demo
=============        

See Index.java and Index.tml in tapestry-mongo-demo

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
                t:document="document" t:validate="none" t:property="address.country"/>

###MongoCheckbox

        <m:MongoCheckbox t:id="car" t:label="car"
                t:document="document" t:property="car"/>

###MongoRadioGroup
        
        <m:MongoRadioGroup t:id="gender" t:label="Gender" t:default="FEMALE" t:document="document" t:validate="required" t:property="user.gender">
			<t:Radio autocomplete="off" t:id="men" value="literal:MALE"/>
			<t:Radio autocomplete="off" t:id="female" value="literal:FEMALE"/>
        </m:MongoRadioGroup>

###MongoLabel
	
	<m:mongoLabel t:for="age"/>
        <m:MongoTextField class="form-control" autocomplete="off" t:id="age" t:label="Age"
                t:document="document" t:translate="integer" t:validate="required" t:property="user.age"/>

###MongoFormFragment

To use with MongoTriggerFragmentMixin

	<m:mongoformfragment class="row" t:id="maidenNameFragment" t:document="document" t:property="user.gender" t:visible="[null,'FEMALE']"/>
		[...other fields...]
	</m:mongoformfragment>



Mixins
=============

###MongoTriggerFragment

	<t:Radio autocomplete="off" t:id="female" value="literal:FEMALE" t:mixins="mongo/mongotriggerfragment" t:fragment="maidenNameFragment"/>

	<t:Radio autocomplete="off" t:id="men" value="literal:MALE" t:mixins="mongo/mongotriggerfragment" t:fragment="maidenNameFragment" t:invert="true"/>
