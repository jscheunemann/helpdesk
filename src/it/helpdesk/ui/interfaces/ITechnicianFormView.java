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

package it.helpdesk.ui.interfaces;

/**
 * Controller class to handle the communication between the model and the view classes.
 * 
 * @author	Helpdesk Tracker Team
 * @version	1.0
 * @since	2014-11-29
 */
public interface ITechnicianFormView {
	
	/**
	 * Method to set the current controller to the object passed to the method.
	 * 
	 * @param controller contains an ITechnicianFormController object
	 */
	public void setController(ITechnicianFormController controller);
	
	/**
	 * Method to open the technician form.
	 */
	public void open();
	
	/**
	 * Method to close the technician form.
	 */
	public void close();
	
	/**
	 * Method to retrieve the current username
	 * 
	 * @return a String value containing the current user's username
	 */
	public String getUsername();
	
	/**
	 * Method to set the current username to the value passed to the method
	 * 
	 * @param username contains the username for the current user
	 */
	public void setUsername(String username);
	
	/**
	 * Method to retrieve the current password
	 * 
	 * @return a String value containing the current user's password
	 */
	public String getPassword();
	
	/**
	 * Method to retrieve the current password confirmation
	 * 
	 * @return a String value containing the current user's password confirmation
	 */
	public String getPasswordConfirmation();
	
	/**
	 * Method to retrieve the current first name
	 * 
	 * @return a String value containing the current user's first name
	 */
	public String getFirstName();
	
	/**
	 * Method to set the current first name to the value passed to the method
	 * 
	 * @param firstName contains the first name for the current user
	 */
	public void setFirstName(String firstName);
	
	/**
	 * Method to retrieve the current last name
	 * 
	 * @return a String value containing the current user's last name
	 */
	public String getLastName();
	
	/**
	 * Method to set the current last name to the value passed to the method
	 * 
	 * @param lastName contains the last name for the current user
	 */
	public void setLastName(String lastName);
	
	/**
	 * Method to retrieve the current phone number
	 * 
	 * @return a String value containing the current user's phone number
	 */
	public String getPhoneNumber();
	
	/**
	 * Method to set the current phone number to the value passed to the method
	 * 
	 * @param phoneNumber contains the phone number for the current user
	 */
	public void setPhoneNumber(String phoneNumber);
	
	/**
	 * Method to retrieve the current email
	 * 
	 * @return a String value containing the current user's email address
	 */
	public String getEmailAddress();
	
	/**
	 * Method to set the current email to the value passed to the method
	 * 
	 * @param emailAddress contains the email for the current user
	 */
	public void setEmailAddress(String emailAddress);
	
	/**
	 * Method to display the authentication error message, if one exists.
	 */
	public void showValidationErrorDialog(String title, String message);
}
