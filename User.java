package projectpart1;

public class User {
	private int id;
	private String email;
	private String password;
	private String passwordConfirmed;
	private String firstname;
	private String lastname;
	private int age;

public User() {
	
}

public User(int id) {
	this.id=id;
}

public User(int id, String email, String password, String passwordConfirmed, String firstname, String lastname, int age) {
    this(email, password, passwordConfirmed, firstname, lastname, age);
    this.id = id;
}

public User(String email, String password, String passwordConfirmed, String firstname, String lastname, int age) {
	this.email=email;
	this.password=password;
	this.passwordConfirmed=passwordConfirmed;
	this.firstname=firstname;
	this.lastname=lastname;
	this.age=age;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id=id;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password=password;
}

public String getPasswordConfirmed() {
	return passwordConfirmed;
}

public void setPasswordConfirmed(String passwordConfirmed) {
	this.passwordConfirmed=passwordConfirmed;
}

public String getFirstname() {
	return firstname;
}

public void setFirstname(String firstname) {
	this.firstname=firstname;
}

public String getLastname() {
	return lastname;
}

public void setLastname(String lastname) {
	this.lastname=lastname;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email=email;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age=age;
}
}