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

public class TechnicianDatasource implements ITechnicianDatasource {
	private List<ITechnician> technicians = null;
	
	public TechnicianDatasource() {
		technicians = new Vector<ITechnician>();
	}
	
	@Override
	public List<ITechnician> getTechnicians() {
		return (List<ITechnician>) this.technicians;
	}

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
