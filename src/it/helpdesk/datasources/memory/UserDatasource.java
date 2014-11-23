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

import it.helpdesk.ui.interfaces.*;

public class UserDatasource implements IUserDatasource {
	private List<IUser> users = null;
	
	public UserDatasource() {
		users = new Vector<IUser>();
	}
	
	@Override
	public List<IUser> getUsers() {
		return (List<IUser>) this.users;
	}

	@Override
	public void saveUser(IUser user, String username, String password, String firstName, String lastName, String emailAddress) {
		long id = 1;

		if (user == null) {
			user = new User();
		}
		
		user.setUsername(username);
		user.setPassword(password);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmailAddress(emailAddress);

		if (!(user.getId() > 0)) {
			users.add(new User(++id, username, password, firstName, lastName, emailAddress));
		}
	}

	@Override
	public IUser getUserByUsername(String username) {
		IUser ret = null;
		for (IUser user : users) {
			if (user.getUsername().equalsIgnoreCase(username)) {
				ret = user;
			}
		}
		
		return ret;
	}

	@Override
	public boolean checkPassword(String username, String password) {
		System.out.println("The password is " + password);
		IUser ret = null;
		
		for (IUser user : users) {
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
		
		for (IUser user : users) {
			if (user.getUsername().equalsIgnoreCase(username)) {
				usernameExists = true;
			}
		}
		
		return usernameExists;
	}
}
