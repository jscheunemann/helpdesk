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

package it.helpdesk.datasources.memory;

import it.helpdesk.ui.interfaces.models.ITechnician;

/**
 * Model class to handle the communication between the application and the database.
 * 
 * @author	Helpdesk Tracker Team
 * @version	1.0
 * @since	2014-11-29
 */
public class Technician extends Person implements ITechnician {
	
	/**
	 * Contains the username of the current technician object
	 */
	private String username;
	
	/**
	 * Contains the password of the current technician object
	 */
	private String password;
	
	/**
	 * Default class constructor.
	 */
	public Technician() { }
	
	/**
	 * Class construnctor to build ITechnician object
	 * 
	 * @param id contains the technician ID
	 * @param firstName contains the technician's first name
	 * @param lastName contains the technician's last name
	 * @param username contains the technician's username
	 * @param password contains the technician's password
	 * @param phoneNumber contains the technician's phone number
	 * @param emailAddress contains the technician's email address
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
	 * Method to retrieve the username from the current ITechnician object.
	 * 
	 * @return a String value containing the username
	 */
	public String getUsername() {
		return this.username;
	}
	
	/**
	 * Method to set the username for the current ITechnician object.
	 * 
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * Method to retrieve the password from the current ITechnician object.
	 * 
	 * @return a String value containing the password
	 */
	public String getPassword() {
		return this.password;
	}
	
	/**
	 * Methos to set the password for the current ITechnician object.
	 * 
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
