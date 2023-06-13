package com.app.main.pojo;

import javax.persistence.*;

@Entity
@Table(name = "user_table")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	@Column(name = "user_name")
	private String userName;
	@Column(unique = true)
	private String email;
	private String password;
	private String address;
	@Column(name="contact_number")
	private long contactNumber;
	@Enumerated(EnumType.STRING)
	@Column(name="user_type")
	Category userType;
	
	
	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Category getUserType() {
		return userType;
	}


	public void setUserType(Category userType) {
		this.userType = userType;
	}
	
	
	public long getContactNumber() {
		return contactNumber;
	}


	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}


	public User() {
		
	}
	

	public User(String userName, String email, String password, String address, long contactNumber, Category userType) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.address = address;
		this.contactNumber = contactNumber;
		this.userType = userType;
	}


	@Override
	public String toString() {
		return userName ;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + (int) (contactNumber ^ (contactNumber >>> 32));
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + userId;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((userType == null) ? 0 : userType.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (contactNumber != other.contactNumber)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userId != other.userId)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (userType != other.userType)
			return false;
		return true;
	}


	
	


	
	
	
	
	

}
