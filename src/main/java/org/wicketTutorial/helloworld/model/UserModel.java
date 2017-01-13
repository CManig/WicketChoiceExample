package org.wicketTutorial.helloworld.model;

import java.io.Serializable;
import java.util.List;



/**
 * Represents the form fields of the user management page.
 * 
 * @author cmanig
 */
public class UserModel implements Serializable{

	/** serialVersionUID */
	private static final long serialVersionUID = -6411316673601688928L;
	
	/** The ID of the user. */
	private int userID;
	/** The first name of the user. */
	private String firstname;
	/** The last name of the user. */
	private String lastname;
	/** The phone number of the user. */
	private String phoneNumber;
	/** The username of the user. */
	private String username;
	/** The password of the user. */
	private String password;
	/** Salt for encrypting password. */
	private String salt;
	/** The e-mail address of the user. */
	private String eMailaddress;
	/** A flag which says the should change his password after first login. */
	private boolean changePasswordForce;
	/** The groups which belongs to the user. */
	private List<Group> groups;
	
	
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String nachName) {
		this.lastname = nachName;
	}	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String geteMailaddress() {
		return eMailaddress;
	}
	public void seteMailaddress(String eMailaddress) {
		this.eMailaddress = eMailaddress;
	}
	public boolean isChangePasswordForce() {
		return changePasswordForce;
	}
	public void setChangePasswordForce(boolean changePasswordForce) {
		this.changePasswordForce = changePasswordForce;
	}
	public List<Group> getGroups() {
		return groups;
	}
	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}
}
