# Java Backend Assessment (SpringBoot)
## Prerequisites
- Docker Desktop: https://www.docker.com/products/docker-desktop/
- Java 17
- Maven 
- IDE (e.g. IntelliJ)
- Postman (REST client)
- DB-Tool (e.g DBeaver)

### Demo Project
The provided SpringBoot demo application is part of the bootcamp assessment. 
Please have look at it and try to get it running and to understand how everything fits together.

- fork the [GIT repo](https://github.com/msedd/mms-demo-app) into your own public space on GitHub
- clone this fork locally
- provide at the end of your assessment your code in your own fork

### Postgres Database 
* start the docker db container
```
 docker compose -f db/docker-compose.yml up -d
```

* stop the docker db container
```
 docker compose -f db/docker-compose.yml stop
```

* stop and delete the docker db container
```
 docker compose -f db/docker-compose.yml down
```


### Build and Start the Application

* build the application
```
 mvn clean install
```
* start the application
```
 java -jar target/demo-app-0.0.1-SNAPSHOT.jar
```
* test the application http://localhost:8080/api/v1.0/user

## Exam Tasks

* check in your code in a git repo
* create a commit for each task with the task number (e.g. Task 1: ...)

### 1:
* extend the existing user endpoint (http://localhost:8080/api/v1.0/user) to have full-featured REST endpoint:
    * GET (ID)
    * POST // create a new user
    * PUT (ID) // modify a user
    * DELETE (ID) // delete a user

### 2:
* extend the existing user entity (DemoUser) with first, surname and gender
* this attributes have to be not 'null'
* the gender types should be an 'enum'

### 3:
* validate the syntactic correctness email address in the service
* implement a JUnit test to show that your validation works properly

### 4:
* implement a new entity 'organisational unit'
    * a user is part of one 'organisational unit' but
    * an 'organisational unit' can have multiple users
    * add some organisational units static via liquibase to the database

### 5:
* extend the existing user endpoint to assign the 'organisational unit'

Good Luck!
