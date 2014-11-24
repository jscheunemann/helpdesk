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

import it.helpdesk.ui.interfaces.models.ITechnician;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name="person_id")
@Table(name="Technician")
public class Technician extends Person implements ITechnician {
	
	private String Username;
	private String Password;
	
	public Technician(long id, String firstName, String lastName, String username, String password, String phoneNumber, String emailAddress) {
		this.setId(id);
		this.setUsername(username);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setPhoneNumber(phoneNumber);
		this.setPassword(password);
		this.setEmailAddress(emailAddress);
	}

	public Technician() { }

	public String getUsername() {
		return this.Username;
	}

	public void setUsername(String username) {
		this.Username = username;
	}

	public String getPassword() {
		return this.Password;
	}

	public void setPassword(String password) {
		this.Password = password;
	}
}
