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

package it.helpdesk.datasources.hibernate.models;

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
