package day5Homework.entities.concretes;

import day5Homework.entities.abstracts.Entity;

public class User implements Entity{

	private int id;
	private String firstName; //Ad ve soyad en az iki karakterden oluþmalýdýr.
	private String lastName;
	private String password; //Parola en az 6 karakterden oluþmalýdýr.
	private String email;
	public int userVerificationCode = (int)(Math.random()*1000000);
	
	public User() {
		
	}
	
	public User(int id, String firstName, String lastName, String password, String email, int UserVerificationCode) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.userVerificationCode = userVerificationCode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getUserVerificationCode() {
		return userVerificationCode;
	}

	public void setUserVerificationCode(int userVerificationCode) {
		this.userVerificationCode = userVerificationCode;
	}

}
