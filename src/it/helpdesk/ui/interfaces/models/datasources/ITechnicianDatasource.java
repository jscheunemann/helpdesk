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

package it.helpdesk.ui.interfaces.models.datasources;

import it.helpdesk.ui.interfaces.models.*;

import java.util.List;

/**
 * Model class to handle the communication between the application and the database.
 * 
 * @author	Helpdesk Tracker Team
 * @version	1.0
 * @since	2014-11-29
 */
public interface ITechnicianDatasource {
	
	/**
	 * Method to retrieve an array of ITechnician objects for all technicians
	 * 
	 * @return an array of ITechnician objects for all technicians
	 */
	public List<ITechnician> getTechnicians();
	
	/**
	 * Method to save the technician information to the datasource.
	 * 
	 * @param technician contains an ITechnician object for the new user
	 * @param username contains a String value of the new username
	 * @param password contains a String value of the new password
	 * @param firstName contains a String value of the new firstName
	 * @param lastName contains a String value of the new lastName
	 * @param phoneNumber contains a String value of the new phoneNumber
	 * @param emailAddress contains a String value of the new emailAddress
	 */
	public void saveTechnician(ITechnician technician, String username, String password, String firstName, String lastName, String phoneNumber, String emailAddress);
	
	/**
	 * Method to retrieve an ITechnician object for the user passed to the method
	 * 
	 * @return an ITechnician object for current user
	 */
	public ITechnician getTechnicianByUsername(String username);
	
	/**
	 * Method to show whether the username is available
	 * 
	 * @param username contains a String value of the requested new username
	 * @return         a boolean value, showing whether the username is still available
	 */
	public boolean usernameAvailable(String username);
	
	/**
	 * Method to compare the username/password combination with the datasource and determine if they match
	 * 
	 * @param username contains a String value of the username
	 * @param password contains a String value of the password
	 * @return         a boolean value, showing whether the username/password combination matches the datasource
	 */
	public boolean checkPassword(String username, String password);
}
