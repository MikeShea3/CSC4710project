



public class People {
	
	// OLD DATA - TO DELETE
    protected int id;
    protected String name;
    protected String address;
    protected String status;
    
    // New Data
    protected String email;
    protected String password;
    protected String passwordConfirmed;
    protected String firstname;
    protected String lastname;
    protected int age;
  
 
    // Methods
    public People() {
    }
    
    // New Constructor
    public People(String email, String password, String passwordConfirmed, String firstname, String lastname, int age) {
    	this.email = email;
    	this.password = password;
    	this.passwordConfirmed = passwordConfirmed;
    	this.firstname = firstname;
    	this.lastname = lastname;
    	this.age = age;
    }
    
    // Getters and Setters
    public void setEmail(String email) {
    	this.email = email;
    }
    
    public String getEmail() {
    	return this.email;
    }
    
    public void setPassword(String password) {
    	this.password = password;
    }
    
    public String getPassword() {
    	return this.password;
    }
    
    public void setPasswordConfirmed(String passwordConfirmed) {
    	this.passwordConfirmed = passwordConfirmed;
    }
    
    public String getPasswordConfirmed() {
    	return this.passwordConfirmed;
    }
    
    public void setFirstname(String firstname) {
    	this.firstname = firstname;
    }
    
    public String getFirstname() {
    	return this.firstname;
    }
    
    public void setLastname(String lastname) {
    	this.lastname = lastname;
    }
    
    public String getLastname() {
    	return this.lastname;
    }
    
    public void setAge(int age) {
    	this.age = age;
    }
    
    public Integer getAge() {
    	return this.age;
    }
    
    
    // OLD METHODS - TO DELETE
    public People(int id, String name, String address, String status, String email, String password, String passwordConfirmed, String firstname, String lastname, int age) {
    	this.id = id;
    	this.name = name;
    	this.address = address;
    	this.status = status;
    
    	// new
    	this.email = email;
    	this.password = password;
    	this.passwordConfirmed = passwordConfirmed;
    	this.firstname = firstname;
    	this.lastname = lastname;
    	this.age = age;
    }
    
    public People(int id) {
        this.id = id;
    }
 
    public People(int id, String name, String address, String status) {
        this(name, address, status);
        this.id = id;
    }
     
    public People(String name, String address, String status) {
        this.name = name;
        this.address = address;
        this.status = status;
    }
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getAddress() {
        return address;
    }
 
    public void setAddress(String address) {
        this.address = address;
    }
 
    public String getStatus() {
        return status;
    }
 
    public void setStatus(String status) {
        this.status = status;
    }
}