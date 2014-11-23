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

import it.helpdesk.ui.interfaces.IUser;

import javax.persistence.*;

@Entity
@Table(name="HelpDesk_User")
public class User implements IUser {

	@Id
	@GeneratedValue
	private Long User_Id;
	
	private String Username;
	private String Password;
	private String First_Name;
	private String Last_Name;
	private String Email;

	@Override
	public long getId() {
		return this.User_Id;
	}

	@Override
	public void setId(long id) {
		this.User_Id = id;
	}

	@Override
	public String getUsername() {
		return this.Username;
	}

	@Override
	public void setUsername(String username) {
		this.Username = username;
	}

	@Override
	public String getPassword() {
		return this.Password;
	}

	@Override
	public void setPassword(String password) {
		this.Password = password;
	}

	@Override
	public String getFirstName() {
		return this.First_Name;
	}

	@Override
	public void setFirstName(String firstName) {
		this.First_Name = firstName;
	}

	@Override
	public String getLastName() {
		return this.Last_Name;
	}

	@Override
	public void setLastName(String lastName) {
		this.Last_Name = lastName;
	}

	@Override
	public String getEmailAddress() {
		return this.Email;
	}

	@Override
	public void setEmailAddress(String emailAddress) {
		this.Email = emailAddress;
	}
}
