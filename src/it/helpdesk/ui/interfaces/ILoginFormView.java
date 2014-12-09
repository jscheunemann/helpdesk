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
public interface ILoginFormView {
	
	/**
	 * Method to set the login form controller to the object passed to the method.
	 * 
	 * @param controller contains an ILoginFormController object
	 */
	public void setController(ILoginFormController controller);
	
	/**
	 * Method to open the login form view.
	 */
	public void open();
	
	/**
	 * Method to close the login form view.
	 */
	public void close();
	
	/**
	 * Method to retrieve the username for the current user from the database.
	 * 
	 * @return a String value of the current user's username
	 */
	public String getUsername();
	
	/**
	 * Method to retrieve the password for the current user from the database.
	 * 
	 * @return a String value of the current user's password
	 */
	public String getPassword();
	
	/**
	 * Method to display the authentication error message, if one exists.
	 */
	public void showValidationErrorDialog(String title, String message);
}
