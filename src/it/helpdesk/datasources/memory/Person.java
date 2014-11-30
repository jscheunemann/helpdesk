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

import it.helpdesk.ui.interfaces.models.IPerson;

/**
 * Model class to handle the communication between the application and the database.
 * 
 * @author	Helpdesk Tracker Team
 * @version	1.0
 * @since	2014-11-29
 */
public class Person implements IPerson {
	
	/**
	 * Contains a long value of the current user's ID
	 */
	private long id;
	
	/**
	 * Contains a String value of the current user's first name
	 */
	private String firstName;
	
	/**
	 * Contains a String value of the current user's last name
	 */
	private String lastName;
	
	/**
	 * Contains a String value of the current user's phone number
	 */
	private String phoneNumber;
	
	/**
	 * Contains a String value of the current user's email address
	 */
	private String emailAddress;

	/**
	 * Method to retrieve the current user's ID
	 * 
	 * @return a long value containing the user's ID
	 */
	public long getId() {
		return this.id;
	}

	/**
	 * Method to set the current user's ID
	 * 
	 * @param id a long value containing the user's ID
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Method to retrieve the current user's first name
	 * 
	 * @return a String value containing the user's first name
	 */
	public String getFirstName() {
		return this.firstName;
	}

	/**
	 * Method to set the current user's first name
	 * 
	 * @param firstName a String value containing the user's first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Method to retrieve the current user's last name
	 * 
	 * @return a String value containing the user's last name
	 */
	public String getLastName() {
		return this.lastName;
	}

	/**
	 * Method to set the current user's last name
	 * 
	 * @param lastName a String value containing the user's last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Method to retrieve the current user's phone number
	 * 
	 * @return a String value containing the user's phone number
	 */
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	/**
	 * Method to set the current user's phone number
	 * 
	 * @param phoneNumber a String value containing the user's phone number
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Method to retrieve the current user's email address
	 * 
	 * @return a String value containing the user's email address
	 */
	public String getEmailAddress() {
		return this.emailAddress;
	}

	/**
	 * Method to set the current user's email address
	 * 
	 * @param emailAddress a String value containing the user's email address
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
}
