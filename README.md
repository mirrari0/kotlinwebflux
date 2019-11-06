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
There is a post endpoint to create and add an employee to the repository with the provided id and name

This endpoint is protected by a username 'admin' and password 'password'

*note:* The username and password need passed in as headers, with the password being encrypted from the auth endpoint below

### ```/auth/{password}```
#### HTTP.GET
This is an endpoint that take in a password and returns an encrypted password. 

### MVC vs WebFlux
https://www.journaldev.com/20763/spring-webflux-reactive-programming

### Outstanding Items
1. Webflux expects to see a 'Reactive' repository, need to figure out what it means to create and interface with a reactive repository
2. Other... things?
3. Should be easy, but example of using a body to pass in data
