/*
 * 
 * Copyright (C) 2014  Helpdesk Tracker Group, Fall Semester, UMUC
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 * 
 */

package it.helpdesk.datasources.hibernate;

import it.helpdesk.ui.interfaces.models.ITechnician;

import javax.persistence.*;

/**
 * Model class to handle the communication between the application and the database.
 * 
 * @author	Helpdesk Tracker Team
 * @version	1.0
 * @since	2014-11-29
 */
@Entity
@PrimaryKeyJoinColumn(name="person_id")
@Table(name="Technician")
public class Technician extends Person implements ITechnician {
	
	/**
	 * Contains a String value of the current user's username
	 */
	private String Username;
	
	/**
	 * Contains a String value of the current user's password
	 */
	private String Password;
	
	/**
	 * Class constructor to instantiate a new Technician object
	 * 
	 * @param id contains the ID of the current user's record
	 * @param firstName contains the first name of the current user's record
	 * @param lastName contains the last name of the current user's record
	 * @param username contains the username of the current user's record
	 * @param password contains the password of the current user's record
	 * @param phoneNumber contains the phone number of the current user's record
	 * @param emailAddress contains the email address of the current user's record
	 */
	public Technician(long id, String firstName, String lastName, String username, String password, String phoneNumber, String emailAddress) {
		this.setId(id);
		this.setUsername(username);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setPhoneNumber(phoneNumber);
		this.setPassword(password);
		this.setEmailAddress(emailAddress);
	}

	/**
	 * Default class constructor
	 */
	public Technician() { }

	/**
	 * Method to retrieve the username from the current local variable
	 * 
	 * @return a String value containing the current local variable
	 */
	public String getUsername() {
		return this.Username;
	}

	/**
	 * Method to set the local username variable
	 * 
	 * @param username contains a String value containing the new username
	 */
	public void setUsername(String username) {
		this.Username = username;
	}

	/**
	 * Method to retrieve the password from the current local variable
	 * 
	 * @return a String value containing the current local variable
	 */
	public String getPassword() {
		return this.Password;
	}

	/**
	 * Method to set the local password variable
	 * 
	 * @param password contains a String value containing the new password
	 */
	public void setPassword(String password) {
		this.Password = password;
	}
}
