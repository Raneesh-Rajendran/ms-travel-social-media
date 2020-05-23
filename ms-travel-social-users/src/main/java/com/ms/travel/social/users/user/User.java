package com.ms.travel.social.users.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "users")
public class User {
	@Id
	@GeneratedValue
	private Long id;
	private String dateOfBirth;
	private Integer age;
	private String firstName;
	private String lastName;
	private String emailId;
	private String gender;
	private String userName;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
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
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "Traveller [id=" + id + ", dateOfBirth=" + dateOfBirth + ", age=" + age + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", emailId=" + emailId + ", gender=" + gender + ", userName=" + userName
				+ "]";
	}
	
	
	public User() {
		
	}
	
	public User(Long id, String dateOfBirth, Integer age, String firstName, String lastName, String emailId,
			String gender, String userName) {
		this.id = id;
		this.dateOfBirth = dateOfBirth;
		this.age = age;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.gender = gender;
		this.userName = userName;
	}
	
	
	
}
	