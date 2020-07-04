# CSC4710project

This is a project made by students at Wayne State University for the Intro to Databases course. 

## Developers

- Frino Jais	(el6583)
- Michael Shea	(gl9411)

## Tools & Versions

Below are the required installations to run this project on your local machine. 
Versions prior to the ones listed cannot be guaranteed to perform successfully.

### Java
- java version "14.0.1" 2020-04-14
- Java(TM) SE Runtime Environment (build 14.0.1+7)
- Java HotSpot(TM) 64-Bit Server VM (build 14.0.1+7, mixed mode, sharing)

### Integrated Development Environment
Eclipse 2020-03 (4.15.0)

### Database Management System
MySQL Workbench 8.0

#### Database Configurations
This project requires a MySQL connection with the following configurations:
- <b>Hostname:</b> 127.0.0.1
- <b>Port:</b> 3306
- <b>Username:</b> john
- <b>Password:</b> pass1234

### Java Servlet Container
Tomcat v9.0

### RUNNING THE APPLICATION ###
Before running the application, you must run the following SQL query in your local MySQL server with the configurations specified above.

If the database is not yet initialized run the following code in your local mySQL server and then login to the root user (root, pass1234) and initialize the database. You may then log out and create an account with a unique email address.

	use testdb;
	CREATE TABLE user (
	email varchar (50),
	firstname varchar(50),
	lastname varchar(50), 
	password varchar(50), 
	passwordConfirmed varchar(50),
	age integer, 
	primary key (email), 
	UNIQUE(email), 
	CHECK(password=passwordConfirmed)
);

	INSERT INTO user VALUES('root', 'system', 'admin', 'pass1234', 'pass1234', 99);
