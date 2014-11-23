package it.helpdesk.datasources.hibernate;

import it.helpdesk.ui.interfaces.IUser;

import javax.persistence.*;

@Entity
@Table(name="HelpDesk_User")
public class User implements IUser {

	@Id
	@GeneratedValue
	private Long User_Id;
	
	private String Username;
	private String Password;
	private String First_Name;
	private String Last_Name;
	private String Email;

	@Override
	public long getId() {
		return this.User_Id;
	}

	@Override
	public void setId(long id) {
		this.User_Id = id;
	}

	@Override
	public String getUsername() {
		return this.Username;
	}

	@Override
	public void setUsername(String username) {
		this.Username = username;
	}

	@Override
	public String getPassword() {
		return this.Password;
	}

	@Override
	public void setPassword(String password) {
		this.Password = password;
	}

	@Override
	public String getFirstName() {
		return this.First_Name;
	}

	@Override
	public void setFirstName(String firstName) {
		this.First_Name = firstName;
	}

	@Override
	public String getLastName() {
		return this.Last_Name;
	}

	@Override
	public void setLastName(String lastName) {
		this.Last_Name = lastName;
	}

	@Override
	public String getEmailAddress() {
		return this.Email;
	}

	@Override
	public void setEmailAddress(String emailAddress) {
		this.Email = emailAddress;
	}
}
