package com.apps.rasmi.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 2287703267381993294L;

	@Id
	@GeneratedValue
	private long id;

	@Column(nullable = false, length = 50)
	private String firstName;

	@Column(nullable = false, length = 50)
	private String userId;

	@Column(nullable = false, length = 50)
	private String lastName;
	
	@Column(nullable = false)
	private String password;

	@Column(nullable = false, length = 50)
	private String email;

	@Column(nullable = false)
	private String enCryptedPassword;

	@Column(nullable = true)
	private String emailVerificationToken;

	@Column
	private boolean emailVerificationStatus=false;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getEnCryptedPassword() {
		return enCryptedPassword;
	}

	public void setEnCryptedPassword(String enCryptedPassword) {
		this.enCryptedPassword = enCryptedPassword;
	}

	public String getEmailVerificationToken() {
		return emailVerificationToken;
	}

	public void setEmailVerificationToken(String emailVerificationToken) {
		this.emailVerificationToken = emailVerificationToken;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public boolean isEmailVerificationStatus() {
		return emailVerificationStatus;
	}

	public void setEmailVerificationStatus(boolean emailVerificationStatus) {
		this.emailVerificationStatus = emailVerificationStatus;
	}

}
