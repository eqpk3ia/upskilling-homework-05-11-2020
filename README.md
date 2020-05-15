# upskilling-homework-05-11-2020
05/11/2020 Homework as part of upskilling

#### Completed Tasks:
- Build a Spring Boot app that runs inside of a container.
When the container is run, the app should start and be a LRP
- Create an endpoint /coal-mine with a String response of Tweet
- Run the container on any port but 8080 (Spring default).
    - Utilize EXPOSE with random port mapping
- Create an endpoint /hello with a response of { "value" : "Hello World" }
Update this endpoint to respond with <value>Hello World</value> when my Accept Header is application/xml
Be sure when the Accept header is */* or application/json it returns the JSON object.
- Make an endpoint of /hello/{name}
    - Respond with the JSON equivalent of "Hello {name}"

-Build out a User object
	- Users include first/last name, email and phone
	- Create full CRUD support (including get all and delete all)
	- Store users in your datastore
	- Build everything in a TDD fashion
	
##### build Project
mvn clean install
##### Add jar to image
docker build -t spring-boot .

WIP...