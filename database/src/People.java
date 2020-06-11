

public class People {
	protected String email;
	protected String password;
	protected String passwordConfirmed;
	protected String firstname;
	protected String lastname;
	protected int age;
 
    public People() {
    	
    }
 
    
    // Constructor
    public People(String email, String password, String passwordConfirmed, String firstname, String lastname, int age) {
    	this.email = email;
    	this.password = password;
    	this.passwordConfirmed = passwordConfirmed;
    	this.firstname = firstname;
    	this.lastname = lastname;
    	this.age = age;
    }
     
 
    public String getEmail() {
        return this.email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
    	return this.password;
    }
    
    public void setPassword(String password) {
    	this.password = password;
    }
    
    public String getPasswordConfirmed() {
    	return this.passwordConfirmed;
    }
    
    public void setPasswordConfirmed(String passwordConfirmed) {
    	this.passwordConfirmed = passwordConfirmed;
    }
 
    public String getFirstName() {
        return this.firstname;
    }
 
    public void setFirstName(String firstName) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return this.lastname;
    }
 
    public void setLastName(String lastname) {
        this.lastname = lastname;
    }
    
}