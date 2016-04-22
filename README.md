Spring MVC Showcase
-------------------
Demonstrates a currency converter using http://openechangerates.org API.

In this showcase you'll see the following in action:
* subscribe new members (sign-up)
* login (sign-in)
* logout (sign-out)
* query latest currency rate
* query historical currency rate
* list showing last 10 queries
* external request will be cached with a ttl of 20 sec

To get the code:
-------------------
Clone the repository:

    $ git clone git://github.com/ktn-de/kt-demo.git

If this is your first time using Github, review http://help.github.com to learn the basics.

To build the war file:
-------------------	
From the command line with Maven:

    $ cd kt-demo
    $ mvn clean install

To run the application local:
-------------------	
    $ java -jar target/dependency/jetty-runner.jar target/*.war
Access the deployed web application at: http://localhost:8080/

or

Access the deployed web application at: http://demo-ktnplus.rhcloud.com/

Note:
-------------------

* This showcase was created using maven archetype from https://github.com/kolorobot/spring-mvc-quickstart-archetype
* sometimes the the initial request takes quite long or will timeout due to https://developers.openshift.com/managing-your-applications/idling.html
