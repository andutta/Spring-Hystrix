Spring/Hystrix Example
====================

Simple example to illustrate integrating Hystrix into a spring application.  This example also illustrates the power (and lack of code) of Spring Data Repositori

The app requires a running Couchbase server on the localhost and it runs an embedded Solr instance (no installation required).

Running
=======

Couchbase
---------

Download Couchbase [here](http://www.couchbase.com/download?gclid=CKz2hLXoj70CFQsSMwodhDgApA) and follow the appropriate installation guide for your OS.  Use Red

Application
-----------

The application can be run via gradle from the root of the repo with ```./gradlew run```.  The application will run forever until you stop it.  You can view the
