# kotlinwebflux
Simple Kotlin Spring Webflux Example w/ some Spring Security

### Startup 
In the root directory you can run ```./gradlew bootRun``` to spin up the spring server

### End Points
There are four endpoints available

### ```/employees```
#### HTTP.GET
This endpoint returns all entries in the in-memory employee repository

### ```/employees/{id}```
#### HTTP.GET
Passing in an id of an employee will cause the employee object to be returned 

*note:* default available ids are one to ten

### ```/employees/{id}/{name}```
#### HTTP.POST
There is a 
