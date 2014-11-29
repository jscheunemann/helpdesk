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

package it.helpdesk.ui.interfaces.models;

/**
 * Model class to handle the communication between the application and the database.
 * 
 * @author	Helpdesk Tracker Team
 * @version	1.0
 * @since	2014-11-29
 */
public interface IPerson {
	/**
	 * Method to retrieve the current ID value of the user.
	 * 
	 * @return a long value with the current user ID
	 */
	public long getId();
	
	/**
	 * Method to set the current user ID value.
	 * 
	 * @param id contains the user user ID
	 */
	public void setId(long id);
	
	/**
	 * Method to retrieve the current first name value of the user.
	 * 
	 * @return a String value with the current user first name
	 */
	public String getFirstName();
	
	/**
	 * Method to set the current user first name value.
	 * 
	 * @param firstName contains the user user first name
	 */
	public void setFirstName(String firstName);
	
	/**
	 * Method to retrieve the current last name value of the user.
	 * 
	 * @return a String value with the current user last name
	 */
	public String getLastName();
	
	/**
	 * Method to set the current user last name value.
	 * 
	 * @param lastName contains the user user last name
	 */
	public void setLastName(String lastName);
	
	/**
	 * Method to retrieve the current phone number value of the user.
	 * 
	 * @return a String value with the current user phone number
	 */
	public String getPhoneNumber();
	
	/**
	 * Method to set the current user phone number value.
	 * 
	 * @param phoneNumber contains the user user phone number
	 */
	public void setPhoneNumber(String phoneNumber);
	
	/**
	 * Method to retrieve the current email value of the user.
	 * 
	 * @return a String value with the current user email
	 */
	public String getEmailAddress();
	
	/**
	 * Method to set the current user email value.
	 * 
	 * @param emailAddress contains the user user email
	 */
	public void setEmailAddress(String emailAddress);
}
