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


###MongoTextArea


###MongoSelect


###MongoCheckbox


###MongoRadioGroup


###MongoLabel


###MongoFormFragment

Mixins
=============

###MongoTriggerFragment
