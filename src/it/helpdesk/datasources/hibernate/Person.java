package it.helpdesk.datasources.hibernate;

import javax.persistence.*;

import it.helpdesk.ui.interfaces.models.IPerson;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "Person", catalog = "catalog", schema = "")
public class Person implements IPerson {
	private long id;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String emailAddress;

	@Id
	@GeneratedValue
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
}
