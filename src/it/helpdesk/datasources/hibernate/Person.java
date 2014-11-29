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

import javax.persistence.*;

import it.helpdesk.ui.interfaces.models.IPerson;

/**
 * Model class to handle the communication between the application and the database.
 * 
 * @author	Helpdesk Tracker Team
 * @version	1.0
 * @since	2014-11-29
 */
 
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name = "Person")
public class Person implements IPerson {
	
	/**
	 * Contains the ID of the current person record 
	 */
	@Id
	@GeneratedValue
	private long id;
	
	/**
	 * Contains the first name of the current person record
	 */
	private String firstName;
	
	/**
	 * Contains the last name of the current person record
	 */ 
	private String lastName;
	
	/**
	 * Contains the phone number of the current person record
	 */
	private String phoneNumber;
	
	/**
	 * Contains the email address of the current person record
	 */
	private String emailAddress;
	
	/**
	 * Method to retrieve the ID of the current person record
	 * 
	 * @return a long value containing the ID of the current person record 
	 */
	public long getId() {
		return this.id;
	}

	/**
	 * Method to set the ID of the current person record
	 * 
	 * @param id a String value containing the ID of the current person record 
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Method to retrieve the first name of the current person record
	 * 
	 * @return a String value containing the first name of the current person record 
	 */
	public String getFirstName() {
		return this.firstName;
	}

	/**
	 * Method to set the first name of the current person record
	 * 
	 * @param firstName a String value containing the first name of the current person record 
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Method to retrieve the last name of the current person record
	 * 
	 * @return a String value containing the last name of the current person record 
	 */
	public String getLastName() {
		return this.lastName;
	}

	/**
	 * Method to set the last name of the current person record
	 * 
	 * @param lastName a String value containing the last name of the current person record 
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Method to retrieve the phone number of the current person record
	 * 
	 * @return a String value containing the phone number of the current person record 
	 */
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	/**
	 * Method to set the phone number of the current person record
	 * 
	 * @param phoneNumber a String value containing the phone number of the current person record 
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Method to retrieve the email address of the current person record
	 * 
	 * @return a String value containing the email address of the current person record 
	 */
	public String getEmailAddress() {
		return this.emailAddress;
	}

	/**
	 * Method to set the email address of the current person record
	 * 
	 * @param emailAddress a String value containing the email address of the current person record 
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
}
