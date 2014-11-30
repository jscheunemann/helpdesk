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

import java.util.*;

import it.helpdesk.ui.interfaces.models.*;
import it.helpdesk.ui.interfaces.models.datasources.*;

/**
 * Model class to handle the communication between the application and the database.
 * 
 * @author	Helpdesk Tracker Team
 * @version	1.0
 * @since	2014-11-29
 */
public class TechnicianDatasource implements ITechnicianDatasource {
	/**
	 * Contains an array of ITechnician objects.
	 */
	private List<ITechnician> technicians = null;
	
	/**
	 * Default class constructor that initializes the ITechnician object.
	 */
	public TechnicianDatasource() {
		technicians = new Vector<ITechnician>();
	}
	
	/**
	 * Method to retrieve an array of technician objects.
	 * 
	 * @return an array of ITechnician objects
	 */
	@Override
	public List<ITechnician> getTechnicians() {
		return (List<ITechnician>) this.technicians;
	}

	/**
	 * Method to save a new technician record.
	 * 
	 * @param technician contains an ITechnician object
	 * @param username contains a String value with username
	 * @param password contains a String value with password
	 * @param firstName contains a String value with first name
	 * @param lastName contains a String value with last name 
	 * @param phoneNumber contains a String value with phone number
	 * @param emailAddress contains a String value with email address
	 */
	@Override
	public void saveTechnician(ITechnician technician, String username, String password, String firstName, String lastName, String phoneNumber, String emailAddress) {
		long id = 1;

		if (technician == null) {
			technician = new Technician();
		}
		
		technician.setUsername(username);
		technician.setPassword(password);
		technician.setFirstName(firstName);
		technician.setLastName(lastName);
		technician.setPhoneNumber(phoneNumber);
		technician.setEmailAddress(emailAddress);

		if (!(technician.getId() > 0)) {
			technicians.add(new Technician(++id, username, password, firstName, lastName, phoneNumber, emailAddress));
		}
	}

	/**
	 * Method to retrieve an ITechnician object based on the username supplied
	 * 
	 * @param username contains the username to retrieve
	 * @return         the ITechnician object for the username supplied
	 */
	@Override
	public ITechnician getTechnicianByUsername(String username) {
		ITechnician ret = null;
		for (ITechnician technician : technicians) {
			if (technician.getUsername().equalsIgnoreCase(username)) {
				ret = technician;
			}
		}
		
		return ret;
	}

	/**
	 * Method to authenticate the username/password combination supplied by the user
	 * 
	 * @param username contains the username supplied by the user
	 * @param password contains the password supplied by the user
	 * @return         a boolean value showing whether the username/password combination matches the database
	 */
	@Override
	public boolean checkPassword(String username, String password) {
		System.out.println("The password is " + password);
		ITechnician ret = null;
		
		for (ITechnician user : technicians) {
			if (user.getUsername().equalsIgnoreCase(username)) {
				ret = user;
			}
		}
		
		if (ret != null) {
			return (ret.getPassword().equals(password));
		}
		else {
			return false;
		}
	}

	/**
	 * Method used to determine whether or not the supplied username is available for use.
	 * 
	 * @param username contains the username supplied by the user
	 * @return         a boolean value showing whether or not the username is available for use
	 */
	@Override
	public boolean usernameAvailable(String username) {
		boolean usernameExists = false;
		
		for (ITechnician user : technicians) {
			if (user.getUsername().equalsIgnoreCase(username)) {
				usernameExists = true;
			}
		}
		
		return usernameExists;
	}
}
