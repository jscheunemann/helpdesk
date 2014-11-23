package it.helpdesk.datasources.memory;

import it.helpdesk.ui.interfaces.IUser;

public class User implements IUser {
	private long id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String emailAddress;
	
	public User() { }
	
	public User(long id, String username, String password, String firstName, String lastName, String emailAddress) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
	}
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * @return the username
	 */
	@Override
	public String getUsername() {
		return this.username;
	}
	
	/**
	 * @param username the username to set
	 */
	@Override
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * @return the password
	 */
	@Override
	public String getPassword() {
		return this.password;
	}
	
	/**
	 * @param password the password to set
	 */
	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
}