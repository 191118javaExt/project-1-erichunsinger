package com.revature.models;

import java.io.Serializable;

public class UserModel implements Serializable {

	long Id;
	String username;
	String password;
	String firstName;
	String lastName;
	String email;
	String roleId;

	public UserModel() {

		super();
	}
	
	

	public UserModel(String username, String password, String firstName, String lastName, String email,
			String roleId) {
		super();
		
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.roleId = roleId;
	}



	public UserModel(long id, String username, String password, String firstName, String lastName, String email,
			String roleId) {
		super();
		Id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.roleId = roleId;
	}



	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}



	@Override
	public String toString() {
		return "UserModel [Id=" + Id + ", username=" + username + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", roleId=" + roleId + "]";
	}

	
}
